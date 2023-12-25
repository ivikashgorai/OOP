package polymorphism.overriding;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Shapes circle = new Circle();
        Shapes square = new Square();

        circle.area(); //here shapes area method should be called ut due to overriding circle area method called, overriding is defined by type of object
        square.area();
        shape.area();
    }
}
