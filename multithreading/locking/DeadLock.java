package multithreading.locking;

public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();


        Thread t1 = new Thread(()->{
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+" Lock1");
                try{
                Thread.sleep(1000);
                }
                catch (Exception e){}
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+" Lock2");
                }

            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+" Lock2");
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e){}
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+" Lock1");
                }
            }

        });

        t1.start();
        t2.start();
    }
}
