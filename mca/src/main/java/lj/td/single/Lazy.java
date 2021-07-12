package lj.td.single;

import javafx.scene.control.Label;

import java.util.concurrent.TimeUnit;

public class Lazy {
    private static boolean XAFlag = false;
   private Lazy() {
       synchronized (Lazy.class) {
           if(!XAFlag){
               XAFlag = true;
           }else{
               throw new RuntimeException("exists");
           }
       }
        System.out.println(Thread.currentThread().getName() + "--> ok");
    }

    private volatile static Lazy lazy;

    public static Lazy getInstance(){
        if(lazy == null){
            synchronized(Lazy.class){
                if(lazy == null){
                    lazy = new Lazy();
                }
            }
        }

        return lazy;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10; i++) {
            new Thread(()->{
                 Lazy.getInstance();
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
