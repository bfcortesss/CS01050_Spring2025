/**
 *  Add comments to explain concepts
 */

/**
 * 
 */

public class AnimalPolymorphism
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("Super Cool Polymorphism with Dynamic Binding Example");
		// Create an array to hold Animal objects
		AnimalP[] animals = new AnimalP[4];
		animals[0] = new HippoP();
		animals[1] = new LionP();
		animals[2] = new TigerP();
		animals[3] = new WolfP();
		
		VetP animalDoc = new VetP();

		// Now let's demonstrate the power of polymorphism!
		for (int i = 0; i < animals.length; i++)
		{
			System.out.println();
			System.out.print("Animal [" + i + "] is a ");
			if(animals[i] instanceof HippoP)
			{
				System.out.print("hippo\n");
			}else if(animals[i] instanceof LionP)
			{
				System.out.print("lion\n");
			}else if(animals[i] instanceof TigerP)
			{
				System.out.print("Tiger\n");
			}else
			{
				System.out.print("Wolf\n");
			}
				
			animals[i].eat();
			animals[i].sleep();
			System.out.print("Vet is giving a shot.");
			animalDoc.giveShot(animals[i]);
		}
		


	}// end of main

}// end of AnimalPolymorphism class

class AnimalP
{

	public AnimalP()
	{
	}

	public void eat()
	{
		System.out.println("Animal is eating");
	}

	public void sleep()
	{
		System.out.println("Animal is sleeping");
	}


	
	public void makeNoise() {
		System.out.println("Animal making noise");
	}

} // Animal

class HippoP extends AnimalP
{

	public HippoP()
	{
	}

	
	@Override
	public void makeNoise() {
		System.out.println("Hippo Snort Snort");
	}

} // Hippo

class LionP extends AnimalP
{

	public LionP()
	{
	}

	@Override
	public void eat()
	{
		System.out.println("Lion is eating - eat method overridden");
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Lion ROARRRRRR");
	}

} // Lion

class TigerP extends AnimalP
{

	public TigerP()
	{
	}

	@Override
	public void sleep()
	{
		System.out.println("Tiger is sleeping - sleep method overridden");
	}

} // Tiger

class CanineP extends AnimalP
{

	public CanineP()
	{
	}

	// Other Canine methods go here...

} // Canine

class WolfP extends CanineP
{

	public WolfP()
	{
	}

} // Wolf


class VetP {
	
	public void giveShot (AnimalP anyAnimal) {		
		anyAnimal.makeNoise();				
	}									
} // Vet	
