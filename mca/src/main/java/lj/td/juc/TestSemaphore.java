package lj.td.juc;

import java.util.concurrent.Semaphore;

/**
 * semaphore翻译成字面意思为 信号量，Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 */
public class TestSemaphore {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(6); //机器数目
        for(int i=0;i<N;i++) {
            new Worker3(i, semaphore).start();
        }
    }
}

class Worker3 extends Thread {
    private int num;
    private Semaphore semaphore;

    public Worker3(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("👷" + this.num + "上班...");
            Thread.sleep(2000);
            System.out.println("👷" + this.num + "下班...");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
