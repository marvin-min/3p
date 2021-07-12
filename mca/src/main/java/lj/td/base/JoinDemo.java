package lj.td.base;

public class JoinDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Join Thread---------------------->" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        Thread thread = new Thread(joinDemo);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if(i == 200){
                thread.join();
            }
            System.out.println("Main Thread ---->" +i);
        }
    }
}
