package multitreading.thread_class;

public class Main  {
    public static void main(String[] args) {
        A thread1 = new A();
        thread1.start();
        for(int i=1;i<=5;i++){
        System.out.println("Second");
        } // both executin at same time output will be order

    }
}

class A extends Thread{
    @Override
    public void run(){
        for(int i=0;i<=5;i++){
             System.out.println("First");
}
        }
}
