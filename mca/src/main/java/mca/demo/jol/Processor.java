package mca.demo.jol;

public class Processor implements Runnable{
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors() * 0.5 * (1+1));
        new Thread(new Processor()).start();
    }

    @Override
    public void run() {
        System.out.println("====");
    }
}
