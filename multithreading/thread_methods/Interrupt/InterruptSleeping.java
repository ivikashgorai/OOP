package multithreading.thread_methods.Interrupt;

public class InterruptSleeping {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread sleeping...");
                Thread.sleep(5000); // sleep for 5 sec
                System.out.println("Thread woke up");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep!");
            }
        });

        t1.start();

        try {
            Thread.sleep(2000); // wait 2 seconds before interrupting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt(); // interrupt during sleep
    }
}

