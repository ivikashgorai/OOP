package multithreading.creating_thread.thread_class;

public class ThreadClass {
    public static void main(String[] args) {
        NewThreadByExtendingThread threadByExtendingThread = new NewThreadByExtendingThread(); // NEW
        threadByExtendingThread.start(); // RUNNABLE
        // we can see in output Hello and world are printing randomly
        // therefore multithreading is happening
        // here 2 threads are present
        // so both threads running concurrently
        for (;;){
            System.out.println("Hello");
        }
    }
}


class NewThreadByExtendingThread extends Thread{

    @Override
    public void run() {
        for (;;){
            System.out.println("World");
        }
    }
}