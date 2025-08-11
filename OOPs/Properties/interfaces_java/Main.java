package interfaces_java;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.acc();
        System.out.println(Engine.maxSpeed);
        car.v1();
        // car.v(); not valid, static method in interface only belong to Interface
        //Engine car2 = new Car(); // we can but we cannot access any another method of interface other than Engine
        // car2.play() this will give error as it can only override method which is present in engine
    }
}

interface Engine {
    int maxSpeed  = 100; // by implicity public static final
    static void v(){ // static concrete method can be created // non static nhi bana sakte
        System.out.println("jgvj");
    }
    default void v1(){
        v3();
        System.out.println("default"); 
    }

    private void v3(){
        System.out.println("Private");
    }
    void start();

    void acc();

    void brea();
}

interface Media {
     default void v1(){
        System.out.println("default"); 
    } // if class implementing interfaces are have same default method then class must override this method
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

    @Override
    public void v1() { // we have to ovveride it cause it implements interface which have same default method
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'v1'");
    }

}