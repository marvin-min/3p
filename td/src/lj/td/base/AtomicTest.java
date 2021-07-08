package lj.td.base;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private volatile int i =0;
    //fix thread issue
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public  void add() {
       // i++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            AtomicTest atomicTest = new AtomicTest();
            Thread[] threads = new Thread[10];
            for (int j=0;j<threads.length;j++){
                threads[j] = new Thread(()->{
                    for (int jj = 0; jj <1000; jj++) {
                        atomicTest.add();
                    }
                });
                threads[j].start();
            }

            Arrays.stream(threads).forEach(th-> {
                try {
                    th.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("第" + (i + 1) + "次执行结果:" + atomicTest.atomicInteger.get());
        }

    }
}
