package inheritance;

public class Box {
    double l;
    double w;
    double h;

    Box() {
        super(); // it will not give an error because every single class
        // we create is subclass of object class(Super class) which is implemented in java 
        l = -1;
        w = -1;
        h = -1;
    }

    Box(double side) {
        this.l = side;
        this.w = side;
        this.h = side;

    }

    Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box(Box other) {
        this.l = other.l;
        this.w = other.w;
        this.h = other.h;
    }
}
