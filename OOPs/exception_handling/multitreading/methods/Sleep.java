package multitreading.methods;

public class Sleep {
    public static void main(String[] args) {
        A r = new A();
        Thread t1 = new Thread(r);
        t1.start();

    }
}

class A implements Runnable  {
    public void run(){
            try {
                 for(int i=0;i<=5;i++){
            System.out.println(i);
                Thread.sleep(1000);
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}