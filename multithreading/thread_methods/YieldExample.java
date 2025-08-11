package multithreading.thread_methods;

public class YieldExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread A - " + i);
                Thread.yield(); // offer to yield
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread B - " + i);
                Thread.yield(); // offer to yield
            }
        });

        t1.start();
        t2.start();
    }
}
