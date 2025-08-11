package multithreading.BlockingQueue;

import java.util.concurrent.*;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // already done using synchronized and locks
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer
        Runnable producer = () -> {
            int value = 0;
            try {
                while (true) {
                    System.out.println("Producing " + value);
                    queue.put(value++);
                    Thread.sleep(500); // Simulate work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer
        Runnable consumer = () -> {
            try {
                while (true) {
                    int val = queue.take();
                    System.out.println("Consuming " + val);
                    Thread.sleep(1000); // Simulate work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
