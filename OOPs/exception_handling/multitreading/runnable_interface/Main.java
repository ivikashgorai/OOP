package multitreading.runnable_interface;

public class Main {
    public static void main(String[] args) {
        A runnable = new A();
        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}

class A implements Runnable{
    public void run(){
        System.out.println("Vikash");
    }
}