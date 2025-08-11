package multithreading.thread_methods;

public class SetDaemon {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           for(;;){
               System.out.println("Hello"); // it will not run infinitely as it is daemon thread
           }
        });
        for(int i=0;i<10;i++){
            System.out.println("World");
        }
        t1.setDaemon(true);
        t1.start();
        //jmv will terminate once all user thread completes , it does not wait for daemon thread
    }
}
