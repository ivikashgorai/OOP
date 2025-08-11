package multithreading.thread_methods;

public class SetNameOfThread extends Thread{


    public SetNameOfThread(String name){
        super(name); // calling Thread constructor to set name of thread
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SetNameOfThread t1 = new SetNameOfThread("Vikash");
        t1.start();
    }
}