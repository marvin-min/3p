package jvm.hm;

import sun.nio.ch.DirectBuffer;

import java.util.concurrent.TimeUnit;

public class HeapDebug {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1......");
        TimeUnit.SECONDS.sleep(60);
        byte[] arr = new byte[1024*1024*10];
        System.out.println("2.......");
        TimeUnit.SECONDS.sleep(60);
        arr = null;
        System.gc();
        System.out.println("3.......");
        TimeUnit.SECONDS.sleep(30000000);

    }
}
