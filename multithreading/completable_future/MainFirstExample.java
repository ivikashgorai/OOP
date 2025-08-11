package multithreading.completable_future;

import java.util.concurrent.CompletableFuture;

public class MainFirstExample {
    public static void main(String[] args) {
        CompletableFuture<Void> future =
                CompletableFuture.supplyAsync(() -> {
                            // Simulate fetching data (API/DB)
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {

                            }
                            System.out.println("Fetched data");
                            return "user data";
                        })
                        .thenApply(data -> {
                            // Process the data
                            System.out.println("Processing: " + data);
                            return data.toUpperCase();
                        })
                        .thenAccept(processedData -> {
                            // Save the data somewhere
                            System.out.println("Saving: " + processedData);
                        });

        System.out.println("Main thread is free to do other work...");

        // Wait for all steps to finish (only at the very end)
        future.join(); // use this when you want to block main thread(calling thread)

        System.out.println("All tasks completed!");
    }
}
