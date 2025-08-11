package multithreading.lifecycle;

public class Lifecycle extends Thread{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Lifecycle lifecycle = new Lifecycle();
        System.out.println(lifecycle.getState()); // WIll give new
        lifecycle.start();
        System.out.println(lifecycle.getState()); // RUNNABLE
    }
}
