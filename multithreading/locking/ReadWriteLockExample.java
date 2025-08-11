package multithreading.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockExample{
    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        Runnable taskRead = new Runnable() {
            @Override
            public void run() {
                readWrite.readMethod();
            }
        };

        Runnable taskWrite = new Runnable() {
            @Override
            public void run() {
                System.out.println(readWrite.writeMethod(5));
            }
        };

        Thread t1 = new Thread(taskRead,"Thread-1");
        Thread t2 = new Thread(taskWrite,"Thread-2");
        t1.start();
        t2.start();
    }
}


class ReadWrite {
       private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
       private final Lock readLock = readWriteLock.readLock(); // same interface, all method can be applied in this lock
       private final Lock writeLock = readWriteLock.writeLock();
       private int data = 0;

       public void readMethod(){
           readLock.lock();
           try{
               Thread.sleep(2000);
               System.out.println(Thread.currentThread().getName()+" Reading.... "+ data);
           }
           catch (Exception e){
               Thread.currentThread().interrupt();
           }
           finally {
               readLock.unlock();
           }
       }

       public int writeMethod(int val){
           writeLock.lock();
           try{
               data = val;
               System.out.println("Data written to "+data);
               return val;
           }
           finally {
               writeLock.unlock();
           }
       }


}
