package lj.td.base;

public class PriorityDemo {
    public static void main(String[] args) {
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority,"111111");
        Thread t2 = new Thread(myPriority,"222222");
        Thread t3 = new Thread(myPriority,"333333");
        Thread t4 = new Thread(myPriority,"444444");
        Thread t5 = new Thread(myPriority,"555555");
        t1.setPriority(1);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(4);
        t5.setPriority(8);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " -----> " + Thread.currentThread().getPriority());
    }
}
