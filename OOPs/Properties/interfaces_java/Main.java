package interfaces_java;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.acc();
        //Engine car2 = new Car(); // we can but we cannot access any another method of interface other than Engine
        // car2.play() this will give error as it can only override method which is present in engine
    }
}

interface Engine {
    static void v(){ // static concrete method can be created // non static nhi bana sakte
        System.out.println("jgvj");
    }
    void start();

    void acc();

    void brea();
}

interface Media {
    void play();

    void pause();
}

interface Stop {
    void stop();
}

class Car implements Engine, Media, Stop {

    public void start() {
        System.out.println("Car Started");
    }

    public void brea() {
        System.out.println("Breaks Applied");
    }

    public void acc() {
        System.out.println("Car accelerated");
    }

    public void play() {
        System.out.println("Radio played");
    }

    public void pause() {
        System.out.println("Radio Paused");
    }

    public void stop() {
        System.out.println("Car stopped");
    }

}