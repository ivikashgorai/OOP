package multithreading.thread_methods;

public class StartSleep extends Thread {

    @Override
    public void run() {
        for(int i=0;i<2;i++){
            try {
                Thread.sleep(2000);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        StartSleep t1 = new StartSleep();
        t1.start();
    }
}
