// Brian Flores Guided Exploration 1 //



public class FloresTestSimpleRectangle {

	public static void main(String[] args) {
		
SimpleRectangle rectangle1 = new SimpleRectangle();

// Create rectangle2 //

 SimpleRectangle rectangle2 = new SimpleRectangle(5, 3);

// Create rectangle3 //
 
SimpleRectangle rectangle3 = new SimpleRectangle(4, -2);

	        
System.out.println("Rectangle 1 - Area: " + rectangle1.getArea() + ", Perimeter: " + rectangle1.getPerimeter());
System.out.println("Rectangle 2 - Area: " + rectangle2.getArea() + ", Perimeter: " + rectangle2.getPerimeter());
System.out.println("Rectangle 3 - Area: " + rectangle3.getArea() + ", Perimeter: " + rectangle3.getPerimeter());
	        
	}
	
		


}


// Class created for SimpleRectangle //


class SimpleRectangle {
	
	// Attributes //
	
	double length;
	double width; 
	
	// Constructors //
	
    public SimpleRectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    public SimpleRectangle(double newLength, double newWidth) {
        this.length = (newLength > 0) ? newLength : 1;
        this.width = (newWidth > 0) ? newWidth : 1;
    }

    // Calculate area //
    
    public double getArea() {
        return length * width;
    }

    // Calculate perimeter //
    
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Setter //
    
    public void setLength(double newLength) {
        if (newLength > 0) {
            this.length = newLength;
        }
    }

    // Setter // 
    
    public void setWidth(double newWidth) {
        if (newWidth > 0) {
            this.width = newWidth;
        }
    }
}
	
	
