package multitreading.priority;

public class Main {
    public static void main(String[] args) {
        M t2 = new M();
        M t1 = new M();
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.setPriority(5); // ye pehle run hoga pura execute hoga
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}

class M extends Thread{
    public void run(){
        String name = Thread.currentThread().getName();
       for(int i=0;i<5;i++){
         System.out.println(name);
       }
    }
}