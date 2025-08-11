package multithreading.synchronization.without_sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count  = 0;


//        Read the current value of count
//        Increment the value
//        Write it back
    public void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
