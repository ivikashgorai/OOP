package multithreading.completable_future;

import java.util.concurrent.*;

public class CompletableFutureWithExecutorExample {
    public static void main(String[] args) throws Exception {

        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Run a task asynchronously using the executor
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started on: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello from CompletableFuture!";
        }, executor);

        // Add a continuation
        CompletableFuture<String> processedFuture = future.thenApplyAsync(result -> { // apply async means transform the result on different thread, then apply transforms the result on same thread
            System.out.println("Processing on: " + Thread.currentThread().getName());
            return result.toUpperCase();
        }, executor);

        // Block and get the final result (because Future interface is also implemented)
        String finalResult = processedFuture.get();
        System.out.println("Final Result: " + finalResult);

        executor.shutdown();
    }
}
