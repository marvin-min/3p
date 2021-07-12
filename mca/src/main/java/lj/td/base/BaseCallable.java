package lj.td.base;

import java.util.concurrent.*;

public class BaseCallable implements Callable<Boolean> {
    private int ticketNums = 10;

    @Override
    public synchronized Boolean call() throws Exception {

        while (ticketNums > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ---> get ticket" + ticketNums-- + ";");
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BaseCallable baseCallable = new BaseCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        Future<Boolean> f1 = executorService.submit(baseCallable);
        Future<Boolean> f2 = executorService.submit(baseCallable);
        Future<Boolean> f3 = executorService.submit(baseCallable);
        Future<Boolean> f4 = executorService.submit(baseCallable);
        Future<Boolean> f5 = executorService.submit(baseCallable);
        Future<Boolean> f6 = executorService.submit(baseCallable);
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        f5.get();
        f6.get();
        executorService.shutdown();
    }
}
