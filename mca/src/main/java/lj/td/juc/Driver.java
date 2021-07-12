package lj.td.juc;

import java.util.concurrent.CountDownLatch;

//One or more countdownlatch Cooperation to finish a task
//https://www.jianshu.com/p/128476015902
//countDown()方法用于使计数器减一，其一般是执行任务的线程调用，await()方法则使调用该方法的线程处于等待状态，其一般是主线程调用。
//这里需要注意的是，countDown()方法并没有规定一个线程只能调用一次，当同一个线程调用多次countDown()方法时，每次都会使计数器减一；
//另外，await()方法也并没有规定只能有一个线程执行该方法，如果多个线程同时执行await()方法，那么这几个线程都将处于等待状态，并且以共享模式享有同一个锁
//CountDownLatch是基于AbstractQueuedSynchronizer实现的

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
