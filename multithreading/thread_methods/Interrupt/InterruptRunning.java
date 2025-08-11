package multithreading.thread_methods.Interrupt;

public class InterruptRunning {
    public static void main(String[] args) {
        Thread t2 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Running thread detected interrupt, exiting...");
                    break;
                }
                System.out.println("Running...");
            }
        });

        t2.start();

        try {
            Thread.sleep(1000); // wait before interrupt
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt(); // thread is running
    }
}
