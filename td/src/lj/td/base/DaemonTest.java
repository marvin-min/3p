package lj.td.base;

public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread godThread = new Thread(god);
        godThread.setDaemon(true);
        Thread youThread = new Thread(you);
        godThread.start();
        youThread.start();
    }
}


class God implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.println("-=========God bless you=========-");
        }
    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 365500; i++) {
            System.out.println("=======开心的....=========");
        }
        System.out.println("----->Goodbye<------");
    }
}
