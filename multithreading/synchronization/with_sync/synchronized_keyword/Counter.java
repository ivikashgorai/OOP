package multithreading.synchronization.with_sync.synchronized_keyword;

public class Counter {
    private int count  = 0;

    public synchronized void increment(){ // allows one thread at a time
        count++;
    }
    public int getCount(){
        return count;
    }
}
