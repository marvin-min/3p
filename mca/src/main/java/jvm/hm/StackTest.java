package jvm.hm;

import java.util.concurrent.TimeUnit;

public class StackTest {
    static volatile int x=0;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new  Thread(()->add()).start();
        }
    }
    static synchronized void add(){

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(i%2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x++;
        }

        System.out.println(Thread.currentThread().getName()+"-->"+x);
    }
}
