package multithreading.communication_thread.medium_level_methods;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 5;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();   // condition for producer, makes new object every .newCondition()
    private final Condition notEmpty = lock.newCondition();  // condition for consumer

    public void produce(int value)  {
        lock.lock(); // acquire lock
        try {
            while (queue.size() == LIMIT) {
                System.out.println("Buffer full, producer waiting...");
                try {
                    notFull.await(); // wait until space is available
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            queue.add(value);
            System.out.println("Produced: " + value);

            notEmpty.signal(); // notify consumer that buffer has data
        } finally {
            lock.unlock(); // release lock
        }
    }

    public void consume()  {
        lock.lock(); // acquire lock
        try {
            while (queue.isEmpty()) {
                System.out.println("Buffer empty, consumer waiting...");
                try {
                    notEmpty.await(); // wait until data is available
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            int value = queue.poll();
            System.out.println("Consumed: " + value);

            notFull.signal(); // notify producer that space is available
        } finally {
            lock.unlock(); // release lock
        }
    }
}

public class SimpleConditionExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Producer
        Thread producer = new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    try {
                        Thread.sleep(500); // simulate work, just to output, not required at all
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    try {
                        Thread.sleep(1000); // simulate work, just to output, not required at all
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        });

        producer.start();
        consumer.start();
    }
}
//How it works:
//Lock ensures only one thread can touch the queue at a time.
//Condition notFull → used by producer to wait until there’s space.
//Condition notEmpty → used by consumer to wait until there’s data.
//await() works like wait() but for a specific condition of a lock.
//signal() works like notify() but for a specific condition object.
