package multithreading.executor_framework;

public class WithoutExecutor {
    public static void main(String[] args) {
        // finding factorial from 1 to 10 // asynchronously

        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++){
            int finalI = i; // individually finding factorial by creating thread for each i
            threads[i] = new Thread(()->{
               int result = factorial(finalI);
                System.out.println(result);
            });
            threads[i].start();
        }

        // waiting all threads to get finished
        for(int i=0;i<10;i++){ // to see how much time it take
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        //here we are creating new thread for each factorial call
        // also we have to manage the threads here
        // wastage of resource for creating multiple threads
        // here come executor service which just manage and create the threads in best way internally we just have to give the task to it

        System.out.println("Time take - "+(System.currentTimeMillis()-startTime)); // in ms, will take 4-5 ms , if not done async then it will take 9-10 sec
    }

    private static int factorial(int num){
        int ans = 1;
        for(int i=1;i<=num;i++){
            ans*=i;
        }
        return ans;
    }
}

