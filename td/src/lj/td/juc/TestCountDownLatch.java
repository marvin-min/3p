package lj.td.juc;

import java.util.concurrent.CountDownLatch;

/**
 * https://docs.oracle.com/javase/8/docs/api/
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        try {
            System.out.println("等待子线程执行完毕...");
            countDownLatch.await();
            System.out.println("子线程执行完毕...");
            System.out.println("继续执行主线程...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
