package multithreading.executor_framework;


import java.util.concurrent.*;

public class WithExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        // creates a thread poll of 3 threads, it will reuse these 3 threads everytime
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<Integer> submit = executorService.submit(() -> { // it can also return and we can take it with future
                int result = factorial(finalI);
//                System.out.println(result);
                return result;
            });
            //instead of printing inside the task we returns the result which will be stored in Future, we can take it by get method
            System.out.println(submit.get());
        }


        // this will shut down all running task as well as not further task will be submitted
        // no above task will be able to run if we call it
//        executorService.shutdownNow();

//  Tell the executor no new tasks will be submitted, after shutdown call
        executorService.shutdown();

// Wait until all tasks are finished (or timeout occurs)
        try {
            //if timeout then it will return false and main thread will continue, else returns true also main thread will continue
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Some tasks did not finish within timeout.");
            }

            //say i want to wait till the all task get completed , but i want to wait to indefinite time
            // so i can apply below logic
//            while(!executorService.awaitTermination(1,TimeUnit.SECONDS)){
//                System.out.println("Waiting......");
//            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    // will run below code after await is over,

        System.out.println("Hi");

//        executorService.submit(new // will give error as executor is already shut down
//                Thread(()->{
//            System.out.println("Vikash");
//        }));


//        System.out.println("Time take - "+(System.currentTimeMillis()-startTime)); // in ms, will take 4-5 ms , if not done async then it will take 9-10 sec
    }

    private static int factorial(int num){
        int ans = 1;
        for(int i=1;i<=num;i++){
            ans*=i;
        }
        return ans;
    }
}
