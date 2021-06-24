package lj.td.pc;

import java.util.List;

public class Diner implements Runnable {
    FoodBox list = null;

    public Diner(FoodBox list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("吃了" + list.pop());
        }
    }
}
