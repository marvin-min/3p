package lj.td.base;

public class BaseRunnable implements Runnable {
    String printInfo = "";

    public BaseRunnable(String pi) {
        this.printInfo = pi;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("worker #########" + i);
            Thread.currentThread().getName();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.printInfo);
    }

    public static void main(String[] args) {
        BaseRunnable baseRunnable = new BaseRunnable("-------->");
        new Thread(baseRunnable, "1111").start();
        new Thread(baseRunnable, "2222").start();
        new Thread(baseRunnable, "3333").start();
        normalPrint();
    }


    private static void normalPrint() {
        for (int i = 0; i < 10; i++) {
            System.out.println("main ------------------>" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
