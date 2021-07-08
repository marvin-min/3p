package lj.td.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JMMDemo {
    public static volatile   int demo =0;
    AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (demo < 1){
//                System.out.println("....");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        demo = 1;
        System.out.println(demo);
    }
}
