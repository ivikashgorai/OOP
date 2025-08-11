package multithreading.synchronization.without_sync;

public class MyThread extends Thread{

    private final Counter counter;

    @Override
    public  void run() {
        for(int i=0;i<1000;i++){
            counter.increment();
        }
    }

    public MyThread(Counter counter){
        this.counter = counter;
    }
}
