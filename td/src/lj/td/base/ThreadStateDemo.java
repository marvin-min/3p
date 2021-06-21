package lj.td.base;

public class ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("..........");
        });

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());

        while (thread.getState() != Thread.State.TERMINATED){
            Thread.sleep(100);
            System.out.println(thread.getState());
        }
    }
}
