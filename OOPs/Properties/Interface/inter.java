package Interface;

// Interface
interface Drawable {
    // Abstract method
    void draw();

    // Default method with a body
    default void display() {
        System.out.println("Displaying the drawable.");
    }
}

// Class implementing the interface
class Circle implements Drawable {
    // Implementing the abstract method from the interface
    public void draw() {
        System.out.println("Drawing a circle.1");
    }
}

// Class implementing multiple interfaces
class Square implements Drawable {
    // Implementing the abstract method from the interface
    public void draw() {
        System.out.println("Drawing a square.");
    }
}
