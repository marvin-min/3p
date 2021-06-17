package lj.td.base;

public class BaseThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("worker #########" + i);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BaseThread().start();
        normalPrint();
    }

    private static void normalPrint() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("main ------------------>" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
