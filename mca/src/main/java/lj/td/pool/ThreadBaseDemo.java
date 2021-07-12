package lj.td.pool;

import java.util.concurrent.*;

public class ThreadBaseDemo {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//       ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (long i = 0; i < 100l; i++) {
                final long j = i;
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "--->" + j);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
