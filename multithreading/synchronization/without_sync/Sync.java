package multithreading.synchronization.without_sync;
public class Sync {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        //t1 and t2 sharing same resource
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (Exception e){

        }
        //as counter is same object using in both thread and both thread runs 1000 times so value of count should be 2000 at the end
        // but it is not assured, as both thread running concurrently, sometimes its print less than 2000
        // thread 1 reads the value of count, thread 2 also reads the same value of count
        // thread 1 increment by 1, thread 2 increment by 1
        // thread1 and 2 write backs the same value by incrementing only one , not two , see image to understand
        // this is called race condition
        System.out.println(counter.getCount());
    }
}
