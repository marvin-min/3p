package lj.td.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

// divide a problem into N parts
public class Driver2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(10);
        long start = System.currentTimeMillis();
        Executor e = new Executor() {
            @Override
            public void execute(Runnable command) {
                new Thread(command).start();
            }
        };
        for (int i = 0; i < 10; ++i) { // create and start threads
            e.execute(new WorkerRunnable(doneSignal, i));
//            new Thread(new WorkerRunnable(doneSignal,i)).start();
        }
        doneSignal.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}

class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;

    WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            doWork(i);
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doWork(int i) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("task " + i + " was done...");
    }
}