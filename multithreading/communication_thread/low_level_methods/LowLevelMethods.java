package multithreading.communication_thread.low_level_methods;

import java.util.LinkedList;
import java.util.Queue;

public class LowLevelMethods {
    public static void main(String[] args) {
    SharedResources sharedResources = new SharedResources();

    Thread t1 = new Thread(()->{
        //task
        for (int i=0;i<=10;i++){
            sharedResources.produce(i);
        }
    },"Producer-Thread");

        Thread t2 = new Thread(()->{
            for (int i=0;i<=10;i++){
                sharedResources.consume();
            }
        },"Consumer-Thread");

        t1.start();
        t2.start();
    }
}


class SharedResources {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 5;

    public synchronized void produce(int val){
        while(queue.size() == LIMIT){
            try {
                wait(); // interruptable (e.g. t1.interrupt())
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(val);
        System.out.println("Produced: " + val);
        notifyAll(); // as if any thread can wait when queue is empty, so it will notify those thread to consume
    }

    public synchronized void consume(){
        while(queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int num = queue.poll();
        System.out.println("Consumed: "+ num);
        notifyAll();
    }
}