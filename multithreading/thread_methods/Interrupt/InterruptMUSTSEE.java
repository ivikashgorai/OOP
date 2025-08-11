package multithreading.thread_methods.Interrupt;

public class InterruptMUSTSEE {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread going to sleep...");
                Thread.sleep(5000); // sleeps for 5 seconds
                // as we know once exception come no further code will execute in try block
                System.out.println("Thread woke up normally.");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep.");
            }
            System.out.println("Thread continues after handling interrupt.");
        });

        t.start();
        t.interrupt();      // Interrupt while it's sleeping

    }
}
