package multithreading.thread_methods;


public class SetPriority extends Thread{

    public SetPriority(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Priority-"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        SetPriority t1 = new SetPriority("Thread-1");
        SetPriority t2 = new SetPriority("Thread-2");
        SetPriority t3 = new SetPriority("Thread-3");
        t1.setPriority(3); // set Priority before thread start
        t2.setPriority(6);
        t3.setPriority(Thread.MAX_PRIORITY);

        // still randomly , priority only affect scheduling , it does not guarantee thet Thread-3 will execute first
        t1.start();
        t2.start();
        t3.start();
    }
}
