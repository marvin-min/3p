package lj.td.base;

import java.util.concurrent.*;

public class TestFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task1 task = new Task1();
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> task1 = new FutureTask<>(task);
        FutureTask<Integer> task2 = new FutureTask<>(task);
        executor.submit(task1);
        executor.submit(task2);
        System.out.println(task1.get());
        System.out.println(task2.get());
        executor.shutdown();
    }
}

class Task1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("running .... ");
        return 2;
    }
}
