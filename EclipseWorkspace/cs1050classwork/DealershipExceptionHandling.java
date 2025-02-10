import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Main class to test dealership functionalities.
 */
public class DealershipExceptionHandling
{
	public static void main(String[] args)
	{
		//see how exception works then fix to be a 5
		final int MAX_NUM_CARS = -5;
		// see how exception works then fix to find file
		final String DEALERSHIP1_FILE = "ealership1.txt";

		try
		{
			// Create a new dealership instance
			Dealership dealership1 = new Dealership("Deb's Dealership", MAX_NUM_CARS);
			System.out.println("Setting up " + dealership1.getName());

			// Read car data from file
			dealershipSetUp(dealership1, DEALERSHIP1_FILE);
			System.out.println("Number of cars in dealership: " + dealership1.getNumberCars());
			System.out.println("Adding more cars...");

			// Adding extra cars
			Car car5 = new Car("Porsche", "Spyder", 164200.00);
			Car car6 = new Car("Hyundai", "Ioniq", 29000.00);
			dealership1.addCar(car5);
			dealership1.addCar(car6);

			dealership1.displayCars();

			// Display the most expensive car
			Car mostExpensive = dealership1.findMostExpensiveCar();
			if (mostExpensive != null)
			{
				System.out.println("\nCar with highest price in dealership:");
				System.out.println("Dealership: " + dealership1.getName());
				System.out.println("Make:       " + mostExpensive.getMake());
				System.out.println("Model:      " + mostExpensive.getModel());
				System.out.println("Price:      $" + mostExpensive.getPrice());
			}
		} catch (InvalidCarCountException e)
		{
			System.out.println("Failed to create dealership: " + e.getMessage());
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: Can't upload dealership information\n" + e.getMessage());
		}
	}

	/**
	 * Reads car data from a file and adds them to the dealership.
	 */
	public static void dealershipSetUp(Dealership dealership, String filename) throws FileNotFoundException
	{
		Scanner fileScanner = null;
		try
		{
			fileScanner = new Scanner(new File(filename));
			while (fileScanner.hasNextLine())
			{
				String make = fileScanner.next().trim();
				String model = fileScanner.next().trim();
				double price = Double.parseDouble(fileScanner.next().trim());
				Car currentCar = new Car(make, model, price);
				dealership.addCar(currentCar);
			}
		} finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}
}

/**
 * Custom Exception for Invalid Car Count. Ensures maxNumCars is within a valid
 * range.
 */
class InvalidCarCountException extends Exception
{
	// Do not worry about this part - without it there is a warning 
	// Not enough time to go into this
	private static final long serialVersionUID = 1L; // Avoids serialization warning

	public InvalidCarCountException(String message)
	{
		super(message);
	}
}

/**
 * Represents a single Car with make, model, and price attributes.
 */
class Car
{
	private String make;
	private String model;
	private double price;

	public Car(String make, String model, double price)
	{
		this.make = make;
		this.model = model;
		this.price = price;
	}

	public String getMake()
	{
		return make;
	}

	public String getModel()
	{
		return model;
	}

	public double getPrice()
	{
		return price;
	}
}

/**
 * Represents a Car Dealership that manages a list of cars.
 */
class Dealership
{
	private String name;
	private Car[] cars;
	private int numCars;

	/**
	 * Constructor with exception handling to validate maxNumCars.
	 */
	public Dealership(String name, int maxNumCars) throws InvalidCarCountException
	{
		setMaxNumCars(maxNumCars);
		this.name = name;
		cars = new Car[maxNumCars];
		numCars = 0;
	}

	/**
	 * Validates maxNumCars before setting it.
	 */
	private void setMaxNumCars(int maxNumCars) throws InvalidCarCountException
	{
		if (maxNumCars <= 0)
		{
			throw new InvalidCarCountException("Error: Max number of cars must be a positive integer.");
		} else if (maxNumCars > 100)
		{
			throw new InvalidCarCountException("Error: Dealership cannot store more than 100 cars.");
		}
	}

	public String getName()
	{
		return name;
	}

	public int getNumberCars()
	{
		return numCars;
	}

	/**
	 * Adds a new car to the dealership if there is space.
	 */
	public void addCar(Car carToAdd)
	{
		if (numCars < cars.length)
		{
			cars[numCars] = carToAdd;
			numCars++;
		} else
		{
			System.out.println("Dealership is full. Couldn't add car: " + carToAdd.getMake() + " " + carToAdd.getModel()
					+ " " + carToAdd.getPrice());
		}
	}

	/**
	 * Finds the car with the highest price in the dealership.
	 */
	public Car findMostExpensiveCar()
	{
		if (numCars == 0)
		{
			System.out.println("No cars in dealership.");
			return null;
		}
		double highestPrice = cars[0].getPrice();
		int highestPriceIndex = 0;
		for (int i = 1; i < numCars; i++)
		{
			if (cars[i].getPrice() > highestPrice)
			{
				highestPrice = cars[i].getPrice();
				highestPriceIndex = i;
			}
		}
		return cars[highestPriceIndex];
	}

	/**
	 * Displays all cars in the dealership.
	 */
	public void displayCars()
	{
		if (numCars == 0)
		{
			System.out.println("No cars available in " + name);
			return;
		}
		System.out.println("--------------------------------------------");
		System.out.println(name);
		System.out.println("Make \t\t Model \t\t Price ");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < numCars; i++)
		{
			Car car = cars[i];
			System.out.printf("%s\t\t%s\t\t%.2f\n", car.getModel(), car.getMake(), car.getPrice());
		}
	}
}


