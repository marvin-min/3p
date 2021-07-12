package lj.iv;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ListDemo {
    public static void main(String[] args) {
        //Object 有哪些方法
       /* Object o   = new Object();
        Method methods[] = o.getClass().getMethods();
        Arrays.stream(methods).forEach(System.out::println);*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocal<String> threadLocal = new ThreadLocal<>();
                threadLocal.set("hello");
                System.out.println(threadLocal.get());
            }
        }).start();

    }
}
