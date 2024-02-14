package multitreading.methods;

public class Wait {
   /*Main Thread */ public static void main(String[] args) throws InterruptedException {
        // main and t1 thread is executing at same time thats why t1.total will give initial value
        C t1 = new C();
       /*t1 thread */ t1.start();
        // System.out.println(t1.total); //ye main thread ke andar ayega
        synchronized(t1){
            try{
                t1.wait();
                System.out.println(t1.total);
            }
            catch(Exception e){}
        }
        

       
    }/*Main thread ends */ // both main thread and t1 is executing at same time so t1.total will be zero as both will start at same time
}

class C extends Thread{
    int total  = 0;
    
    public void run(){
        synchronized(this){
        for(int i=0;i<=100;i++){
            total+=i;
        }
        this.notify();
    }
}
}
