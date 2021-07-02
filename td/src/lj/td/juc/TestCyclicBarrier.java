package lj.td.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    public static void main(String[] args) {
        int N = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Runnable() {//当所有线程都执行完后会随机选择一个线程去执行runnable
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });
        for(int i=0;i<N;i++) {
            new Writer(cyclicBarrier).start();
        }
        System.out.println("------->当前线程"+Thread.currentThread().getName());

        System.out.println("----------------------------------------------------------------------");
        System.out.println("CyclicBarrier重用");

        for(int i=0;i<N;i++) { //CyclicBarrier是可以重用
            new Writer(cyclicBarrier).start();
        }
    }
}

class Writer extends Thread {
    private CyclicBarrier cyclicBarrier;
    public Writer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
        try {
            Thread.sleep(5000);      //以睡眠来模拟写入数据操作
            System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch(BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"所有线程写入完毕，继续处理其他任务...");
    }
}