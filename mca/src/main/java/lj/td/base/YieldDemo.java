package lj.td.base;

public class YieldDemo {
    public static void main(String[] args) {
        MyYield yield = new MyYield();
        new Thread((yield),"A").start();
        new Thread((yield),"B").start();
        new Thread((yield),"C").start();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始执行");
        Thread.yield();//让出cpu时间，让cpu重新调度所有线程（重新竞争cpu）
        System.out.println(Thread.currentThread().getName()+" 执行结束");
    }
}

