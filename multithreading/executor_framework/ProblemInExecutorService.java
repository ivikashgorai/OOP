package multithreading.executor_framework;

import java.util.concurrent.*;

public class ProblemInExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3); // wait till 3 task get completed
        Future<String> future1 = executorService.submit(new DependentService(latch));
        Future<String> future2 = executorService.submit(new DependentService(latch));
        Future<String> future3 = executorService.submit(new DependentService(latch));


//        future1.get(); // so much boiler plate, we can use countdown latch
//        future2.get();
//        future3.get();

//        executorService.invokeAll(future list here) // can be used this but to less complicate it we use CountDown latch

        latch.await(); // waits till count become
        System.out.println("All service finished..");
        executorService.shutdown();

    }
}


class DependentService implements Callable<String>{ // for example we used callable, can also be done using runnable interface

    private final CountDownLatch countDownLatch;

    DependentService(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception { // advantage of callable is that it throws exception in  method level so no try catch required in call method
       try{
           System.out.println(Thread.currentThread().getName()+" Thread running");
           Thread.sleep(2000);
       }
       finally {
           countDownLatch.countDown();
       }
        return "ok";
    }
}