// ArrayListBirdLab Project //
// By: Brian Flores //



public class ArrayListBirdLabProject {

	
	public static void main(String[] args) {
		

	}

}


abstract class Bird {
	
public String BirdType;
public String name;
public int swimSpeed;
	
	
	
	public Bird(String BirdType, String name, int swimSpeed) {
		
		this.BirdType = BirdType;
		this.name = name;
		this.swimSpeed = swimSpeed;
		
		
		
	}
	
interface Swimmers {
	int getswimSpeed();

	
}

class penguin extends Bird implements Swimmers






