package multithreading.executor_framework;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(3,()-> {
            System.out.println("All task done... "); // this runs when all thread call barrier.await(), here 3 threads
        }); // wait till 3 task get completed, does not block main thread
        Future<String> future1 = executorService.submit(new DependentService2(barrier));
        Future<String> future2 = executorService.submit(new DependentService2(barrier));
        Future<String> future3 = executorService.submit(new DependentService2(barrier));
        System.out.println("Main thread"); // so we can use it when we dont want to block main thread , see notes when to use it
        executorService.shutdown();

    }
}


class DependentService2 implements Callable<String>{

    private final CyclicBarrier cyclicBarrier;

    public DependentService2(CyclicBarrier barrier){
        this.cyclicBarrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" Started....");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" Waiting at barrier");
        cyclicBarrier.await(); // also have method with timeout, threads will wait here until all thread come here
        return "All Threads done";
    }
}