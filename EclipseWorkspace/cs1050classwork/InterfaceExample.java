
public class InterfaceExample
{

	public static void main(String[] args)
	{
        Bulldog myDog = new Bulldog("Max", 30.5, "Dog Food", "Backyard");
        myDog.eat();
        myDog.beFriendly();
        myDog.play();

	}

}

// Interface defining behaviors for a Pet // 

interface Pet {
 void beFriendly();
 void play();
}

//Abstract class Animal
abstract class Animal {
 private String name;
 private double weight;
 private String food;
 private String location;

 // Constructor
 public Animal(String name, double weight, String food, String location) {
     this.name = name;
     this.weight = weight;
     this.food = food;
     this.location = location;
 }

 // Abstract method - must be implemented by subclasses
 public abstract void eat();

 // Getters
 public String getName() { return name; }
 public double getWeight() { return weight; }
 public String getFood() { return food; }
 public String getLocation() { return location; }
}

// Abstract class Canine extending Animal //
// Abstract class defines the methods for the subclasses //

abstract class Canine extends Animal {
 public Canine(String name, double weight, String food, String location) {
     super(name, weight, food, location);
 } 
}

//Concrete class Bulldog extending Canine and implementing Pet//

class Bulldog extends Canine implements Pet {
 public Bulldog(String name, double weight, String food, String location) {
     super(name, weight, food, location);
 }

 @Override
 public void eat() {
     System.out.println(getName() + " is eating " + getFood() + ".");
 }

 @Override
 public void beFriendly() {
     System.out.println(getName() + " is wagging its tail happily!");
 }

 @Override
 public void play() {
     System.out.println(getName() + " is playing with a ball.");
 }
}

