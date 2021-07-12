package lj.td.base;

import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile {
//    public volatile int inc = 0;

    public AtomicInteger inc = new AtomicInteger();
    public synchronized void increase() {
        inc.incrementAndGet();
    }

    public static void main(String[] args) {
        final TestVolatile testVolatile = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int i1 = 0; i1 <= 2; i1++) {
                        testVolatile.increase();
                        System.out.println(Thread.currentThread().getName() + "--->" + testVolatile.inc);
                    }
                }
            }.start();
        }
        System.out.println("----->" + Thread.activeCount() + "<------");
//        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
//            Thread.yield();
        System.out.println(testVolatile.inc);
    }
}
