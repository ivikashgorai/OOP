package multithreading.completable_future;

import java.util.concurrent.*;

public class CompletableFutureSecondExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 1. Fetch user profile
        // CF often runs on daemon thread
        CompletableFuture<String> userProfile = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            System.out.println("Fetched user profile");
            return "User: John";
        }); // now task will run on thread of executor service(user thread), // more control over thread type

        // 2. Fetch order history
        CompletableFuture<String> orderHistory = CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            System.out.println("Fetched order history");
            return "Orders: [#123, #456]";
        });

        //Future.get() will be blocking the main thread for result , completable future is very good in that case as it process after the previous task done auto.

        // 3. Combine profile + orders
        CompletableFuture<String> combinedData = userProfile.thenCombine(orderHistory,
                (profile, orders) -> profile + " | " + orders);

        // 4. Fetch recommendations from two APIs, take faster one
        CompletableFuture<String> recFromApi1 = CompletableFuture.supplyAsync(() -> {
            sleep(800);
            System.out.println("Recommendation API 1");
            return "Rec from API1";
        });

        CompletableFuture<String> recFromApi2 = CompletableFuture.supplyAsync(() -> {
            sleep(1200);
            System.out.println("Recommendation API 2");
            return "Rec from API2";
        });

        CompletableFuture<Object> fastRecommendation =
                CompletableFuture.anyOf(recFromApi1, recFromApi2);

        // 5. Wait for all and save
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(combinedData, fastRecommendation)
                .thenRun(() -> { // see methods in notes
                    try {
                        String finalData = combinedData.join(); // getting only result from join, as task already completed, otherwise it waits till task complete by blocking thread like get()
                        String rec = (String) fastRecommendation.join();
                        System.out.println("Saving: " + finalData + " | " + rec);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        // Main thread can do other stuff...
        System.out.println("Main thread is free while tasks run...");

        // Block only at the very end
        allTasks.join(); // as CF often runs on daemon thread , we can process the main thread at end after CF task finishes
        System.out.println("All done!");
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
