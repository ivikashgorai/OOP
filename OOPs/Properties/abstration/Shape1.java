package abstration;

public class Shape1 {
    public static void main(String[] args) {
        // Create instances of concrete classes
        Circle circle = new Circle();
        Square square = new Square();

        // Call methods on the objects
        circle.draw();
        circle.display();

        square.draw();
        square.display();
    }
}

// Abstract class
abstract class Shape {
    // Abstract method (no implementation)
    abstract void draw();

    // Concrete method
    void display() {
        System.out.println("Displaying the shape.");
    }
}

// Concrete subclass
class Circle extends Shape {
    // Implementing the abstract method
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

// Concrete subclass
class Square extends Shape {
    // Implementing the abstract method
    void draw() {
        System.out.println("Drawing a square.");
    }
}
