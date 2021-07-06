package lj.td.pool;

import java.util.concurrent.*;

public class CustomerThreadPool {

    public static void main(String[] args) {
        // new ThreadPoolExecutor.CallerRunsPolicy() 返回给原来线程
        //new ThreadPoolExecutor.AbortPolicy() 直接报异常
        //new ThreadPoolExecutor.DiscardPolicy() 默默丢弃新的
        //new ThreadPoolExecutor.DiscardOldestPolicy() 丢弃老的
        ExecutorService executor = new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors(),
                10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(80), new ThreadPoolExecutor.AbortPolicy());

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


    }
}
