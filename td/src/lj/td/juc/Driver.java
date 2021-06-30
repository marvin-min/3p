package lj.td.juc;

import java.util.concurrent.CountDownLatch;

//One or more countdownlatch Cooperation to finish a task
public class Driver {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(startSignal,doneSignal)).start();
        }
        System.out.println("main thread...");
        startSignal.countDown();
        System.out.println("do a heavy job");
        doneSignal.await();
        System.out.println("----all worker done----");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doWork() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在干活。。。。");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"干完了活。。。。");
    }
}
