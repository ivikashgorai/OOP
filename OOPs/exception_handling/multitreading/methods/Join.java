package multitreading.methods;

public class Join {
    public static void main(String[] args)  {
        J t1 = new J();
        J t2 = new J();
        J t3 = new J();

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
        t3.start(); // sabse pehle t3 ko start karre aur as t3.join karre neeche toh ek baar wo start ho gaya toh pura exceute hoke hi koi aur thread execute hoga
        
        try{
            t3.join(); // suru hua kabhi bhi toh last tak execute hoke rukega .. neeche ka code wait karega7
        }
        catch(Exception e){}

        //below code will execute in any order
        t1.start();
        t2.start(); 
        System.out.println(t3.isAlive()); // returns false cause t3 is finished executing
}
}
class J extends Thread{
    
    public void run(){
        String name = Thread.currentThread().getName();
        for(int i=0;i<=5;i++){
            System.out.println(name);
    }
}
}