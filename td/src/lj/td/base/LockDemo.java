package lj.td.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) throws InterruptedException {
        TestLock2 lockDemo = new TestLock2();
        Thread t1 = new Thread(lockDemo, "A");
        Thread t2 =  new Thread(lockDemo, "B");
        Thread t3 =  new Thread(lockDemo, "C");
//        t2.setPriority(8);
//        t1.setPriority(1);
//        t3.setPriority(10);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println("888888888888888888888");

    }
}
class TestLock2 implements Runnable{
    Integer ticketNum = 10000;
    private final Lock lock = new ReentrantLock();
    boolean flag = true;
    @Override
    public void run() {
        sale();
    }

    public void sale(){
        while (flag)
            try {
                lock.lock();
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了第几" + ticketNum--);
                    Thread.sleep(10);
                }else{
                    flag = false;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
    }
}
