import java.util.LinkedList;
import java.util.Scanner;



public class TaskManagerDemo {
    public static void main(String[] args) {
    	
    	
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        int choice = 0;
        
        

        while (choice != 4) {
            System.out.println("\nOptions: \n1. Add Task"
            		+ "\n2. Complete Task "
            		+ "\n3. View Tasks "
            		+ "\n4. Exit");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.nextLine();
                choice = -1;
            }

            
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    manager.addTask(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter task to complete: ");
                    manager.removeTask(scanner.nextLine());
                    break;
                case 3:
                    manager.viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        
        
        scanner.close();
        
        
    }
}

class TaskManager {
	
	
    private LinkedList<String> tasks = new LinkedList<>();

    public void addTask(String task) {
    	
    	
        tasks.add(task);
        System.out.println("Task added: " + task);
        
        
    }

    public void removeTask(String task) {
    	
    	
        if (tasks.remove(task)) {
            System.out.println("Task completed: " + task);
            
            
        } else {
            System.out.println("Task not found.");
            
            
        }
    }

    public void viewTasks() {
    	
    	
        if (tasks.isEmpty()) {
            System.out.println("No pending tasks.");
            
            
        } else {
        	
        	
            System.out.println("Pending Tasks:");
            for (String task : tasks) {
                System.out.println("- " + task);
            }
        }
    }
}


