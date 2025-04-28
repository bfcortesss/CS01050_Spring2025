
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * CS2050 - CarVendingMachine Project Iteration 02 
 * By. Brian Flores 
 * 
 * Objectives: dynamic LinkedList + HashMap storage,
 * abstract Car + subclasses, Collections.sort, search, queue, remove.
 */
public class CarVendingMachineProject {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.print("Enter the number of floors for the car vending machine: ");
        int floors = console.nextInt();
        
        System.out.print("Enter the number of spaces for the car vending machine: ");
        int spaces = console.nextInt();

        VendingMachine vendingmachine = new VendingMachine(floors, spaces);
        int choice;
        do {
            System.out.println("\n=== Car Vending Machine Menu ===");
            System.out.println("1. Load Car Data from File");
            System.out.println("2. Display Vending Machine");
            System.out.println("3. Retrieve a Car by Location (Floor & Space)");
            System.out.println("4. Print Sorted Inventory (Price)");
            System.out.println("5. Print Sorted Inventory (Year)");
            System.out.println("6. Search for Cars (Manufacturer & Type)");
            System.out.println("7. Add Car to Wash Queue");
            System.out.println("8. Process Car Wash Queue");
            System.out.println("9. Sell a Car");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = console.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the file name: ");
                    String filename = console.next();
                    vendingmachine.readFile(filename);
                    break;
                case 2:
                    vendingmachine.display();
                    break;
                case 3:
                    System.out.print("Enter floor: ");
                    int rf = console.nextInt();
                    System.out.print("Enter space: ");
                    int rs = console.nextInt();
                    Car testCar = vendingmachine.retrieveCar(rf, rs);
                    if (testCar != null) {
                        System.out.println("Car retrieved: " + testCar);
                    } else {
                        System.out.println("Car not found at this location.");
                    }
                    break;
                case 4:
                    vendingmachine.printSortedInventoryByPrice();
                    break;
                case 5:
                    vendingmachine.printSortedInventoryByYear();
                    break;
                case 6:
                    console.nextLine(); // consume newline
                    System.out.print("Enter manufacturer: ");
                    String manu = console.nextLine();
                    System.out.print("Enter car type (Basic/Premium): ");
                    String type = console.nextLine();
                    vendingmachine.searchCars(manu, type);
                    break;
                case 7:
                    System.out.print("Enter floor: ");
                    int wf = console.nextInt();
                    System.out.print("Enter space: ");
                    int ws = console.nextInt();
                    vendingmachine.addToWashQueue(wf, ws);
                    break;
                case 8:
                    vendingmachine.processWashQueue();
                    break;
                case 9:
                    System.out.print("Enter floor of the car to sell: ");
                    int sf = console.nextInt();
                    System.out.print("Enter space of the car to sell: ");
                    int ss = console.nextInt();
                    vendingmachine.sellCar(sf, ss);
                    break;
                case 10:
                    System.out.println("Have a nice day. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1–10.");
            }
        } while (choice != 10);

        console.close();
    }
}

/**
 * New Abstract Class Car created with shared attributes, and behaviors that "Basic" or "Premium" Cars can hold. 
 * 
 * Creates opportunity to create additional sub-classes that hold the same traits and behaviors. 
 */
abstract class Car {
    protected int year;
    protected double price;
    protected String manufacturer;
    protected String model;
    protected Position pos;

    public Car(int year, double price, String manu, String model, Position pos) {
        this.year = year;
        this.price = price;
        this.manufacturer = manu;
        this.model = model;
        this.pos = pos;
    }

    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getManufacturer() { return manufacturer; }
    public Position getPosition() { return pos; }

    /** Marker for type (“Basic” or “Premium”). */
    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%s Car: %s %s %d - $%.1f (Floor: %d, Space: %d)",
            getType(), manufacturer, model, year, price, pos.floor, pos.space);
    }
}

/** Subclass for BasicCar extends and implemts the methods of the Abstract Car class. */
class BasicCar extends Car {
    public BasicCar(int year, double price, String manu, String model, Position pos) {
        super(year, price, manu, model, pos);
    }
    @Override public String getType() { return "Basic"; }
}

/** Subclass for Premium Car extends and implements the methods of the Abstract Car class. */
class PremiumCar extends Car {
    public PremiumCar(int year, double price, String manu, String model, Position pos) {
        super(year, price, manu, model, pos);
    }
    @Override public String getType() { return "Premium"; }
}

/** Simple immutable key for HashMap positions */
class Position {
    public final int floor, space;
    public Position(int floor, int space) {
        this.floor = floor;
        this.space = space;
    }
    @Override public boolean equals(Object o) {
        if (!(o instanceof Position)) return false;
        Position p = (Position)o;
        return p.floor == floor && p.space == space;
    }
    @Override public int hashCode() {
        return Objects.hash(floor, space);
    }
}

/**
 * VendingMachine manages dynamic inventory, locations, search, wash queue, and sales.
 * 
 * transition of a 2D array to a linkedList:
 * 
 * LinkedList "inventoryList" created to manage the dynamic sturcture of the growing/shrinking Car inventory.
 * (holds and stores each car in the inventory). 
 *  
 * HashMap "locationMap" manages the searching of each car in the "inventoryList" more effciently O(1)
 * 
 * Queue created to manage Car Wash managemnet system. 
 */
class VendingMachine {
    private int floors, spaces;
    private LinkedList<Car> inventoryList = new LinkedList<>();
    private Map<Position,Car> locationMap = new HashMap<>();
    private Queue<Car> washQueue = new LinkedList<>();

    public VendingMachine(int floors, int spaces) {
        this.floors = floors;
        this.spaces = spaces;
    }

    /**
     * Read Car information from a specified file. 
     * Each line inludesL row number, column number, year, price, manufacturer, and model. 
     * Each line is read, created and added to the "inventoryList"
     * @param filename (File containing car data).
     * @param vm (vending machine where cars will be added).  
     */
    
    public static void readFile(String filename, VendingMachine vm) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNext()) {
                String type = fileScanner.next();        
                int floor = fileScanner.nextInt();       
                int space = fileScanner.nextInt();
                int year  = fileScanner.nextInt();
                double price = fileScanner.nextDouble();
                String manu  = fileScanner.next();
                String model = fileScanner.next();

                Position pos = new Position(floor, space);
                Car car = type.equalsIgnoreCase("B")
                    ? new BasicCar(year, price, manu, model, pos)
                    : new PremiumCar(year, price, manu, model, pos);

                // use your new addCar method
                if (!vm.addCar(car, pos)) {
                    System.out.printf("Cannot place Car: %s%n", car);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } finally {
            if (fileScanner != null) fileScanner.close();
        }
       
    }

    
    	

    private boolean addCar(Car car, Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	/** Prints each Car in inventory—no EMPTY slots. */
    public void display() {
        for (Car carToPrint : inventoryList) {
            System.out.println(carToPrint);
        }
    }

    /**
     * Retrieve (for test drive): remove from inventory & map.
     * Returns Car or null.
     */
    
    public Car retrieveCar(int floor, int space) {
        Position pos = new Position(floor, space);
        Car c = locationMap.remove(pos);
        if (c != null) inventoryList.remove(c);
        return c;
    }

    /** Sort & print by price ascending. */
    public void printSortedInventoryByPrice() {
        List<Car> copy = new ArrayList<>(inventoryList);
        copy.sort(Comparator.comparingDouble(Car::getPrice));
        System.out.println("\nSorted Inventory by Price:");
        copy.forEach(System.out::println);
    }

    /** Sort & print by year ascending. */
    public void printSortedInventoryByYear() {
        List<Car> copy = new ArrayList<>(inventoryList);
        copy.sort(Comparator.comparingInt(Car::getYear));
        System.out.println("\nSorted Inventory by Year:");
        copy.forEach(System.out::println);
    }

    /**
     * Search by manufacturer & type, case-insensitive.
     * Sort results by manufacturer alphabetically.
     */
    public void searchCars(String manufacturer, String type) {
        String manLow = manufacturer.toLowerCase();
        String tLow = type.toLowerCase();
        List<Car> results = new ArrayList<>();
        for (Car c : inventoryList) {
            if (c.getManufacturer().toLowerCase().equals(manLow)
             && c.getType().toLowerCase().equals(tLow)) {
                results.add(c);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }
        results.sort(Comparator.comparing(Car::getManufacturer));
        results.forEach(System.out::println);
    }

    /** Remove and enqueue car for wash. */
    public void addToWashQueue(int floor, int space) {
        Car CartoWash = retrieveCar(floor, space);
        if (CartoWash == null) {
            System.out.println("No car found at this location.");
        } else {
            washQueue.offer(CartoWash);
            System.out.println("Car retrieved: " + CartoWash);
            System.out.println("Car added to wash queue.");
        }
    }

    /** Process all queued cars in FIFO order. */
    public void processWashQueue() {
        while (!washQueue.isEmpty()) {
            Car CartoWash = washQueue.poll();
            System.out.println("Washing: " + CartoWash);
        }
    }

    /** Sell a car permanently. */
    public void sellCar(int floor, int space) {
        Car CartoSell = retrieveCar(floor, space);
        if (CartoSell == null) {
            System.out.printf("No car found at Floor %d Space %d.%n", floor, space);
        } else {
            System.out.println("Car Sold: " + CartoSell);
        }
    }
}

        	
    
    
	    
	   
	
	
	
	