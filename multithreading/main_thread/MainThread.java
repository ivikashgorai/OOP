package multithreading.main_thread;

public class MainThread {
    public static void main(String[] args) {
        System.out.println("Hello World"); // main thread runs the main method
        System.out.println(Thread.currentThread().getName());
    }
}
