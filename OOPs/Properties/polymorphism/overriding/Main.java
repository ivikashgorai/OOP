package polymorphism.overriding;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Shapes circle = new Circle();
        Shapes square = new Square();
        Circle circle2 = new Circle();
        System.out.println(circle2.a); // dependes on refrence variable, if not method overriding


        //only in case of method overriding depends on object
        circle.area(); //here shapes area method should be called ut due to overriding circle area method called, overriding is defined by type of object
        square.area();
        shape.area();
    }
}
