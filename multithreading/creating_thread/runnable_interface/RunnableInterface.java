package multithreading.creating_thread.runnable_interface;

public class RunnableInterface {
    public static void main(String[] args) {

        NewThreadByImplementingRunnable threadByImplementingRunnable = new NewThreadByImplementingRunnable();
        //RUNNABLE
        Thread t1 = new Thread(threadByImplementingRunnable); // make new Thread object and pass the class implementing Runnable in the constructor
        t1.start(); //RUNNABLE
        for (;;){
            System.out.println("Hello");
        }
    }
}


class NewThreadByImplementingRunnable implements Runnable {

    @Override
    public void run() {
        for (;;){
            System.out.println("World");
        }
    }
}