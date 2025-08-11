package multithreading.thread_methods;

public class Join extends Thread{

    @Override
    public void run() {
//        for(int i=0;i<4;i++){
//            System.out.println("Hello");
//        }

        for (;;){
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        Join j = new Join();
        j.start();
       try{
//           j.join()
           j.join(2000);
           // here main thread is running,
           // so caller is main thread,
           // so main thread will wait till the j thread complete its execution indefinitely
           // we can also define how much time it will wait to finish ,
           // if not finished in that time , caller thread will continue its own execution j.join(ms)
           // after 2s main thread will print World but Hello will be infinite cause the j thread will not stop until finished
           // it just allow the caller thread to continue after 2s
       }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("World");
    }
}
