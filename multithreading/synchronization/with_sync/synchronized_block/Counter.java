package multithreading.synchronization.with_sync.synchronized_block;

public class Counter {
    private int count  = 0;

    public void increment(){
        synchronized (this) { // allows one thread at a time, this represent the counter object, this block is locked on counter object
            count++;
        }
    }
    public int getCount(){
        return count;
    }
}


class CounterPrivateObject {
    private int count  = 0;

    private final Object lock = new Object();

    public void increment(){
        synchronized (lock) { // allows one thread at a time, this represent the counter object, this block is locked on counter object
            count++;
        }
    }
    public int getCount(){
        return count;
    }
}