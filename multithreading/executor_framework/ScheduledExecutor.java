package multithreading.executor_framework;

import java.sql.Time;
import java.util.concurrent.*;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
                    System.out.println("Task Runing...");
                },
                5,
                5,
                TimeUnit.SECONDS);
        // if we call shutdown here then task will not start as it will take 5 second initially to start the first task also after every 5 second it will take task , so we have to handle it properly, all task should be started then call shutdown

        scheduledExecutorService.schedule(()->{
            scheduledExecutorService.shutdown();
        },20,TimeUnit.SECONDS); // so 4 time task will run

    }
}
