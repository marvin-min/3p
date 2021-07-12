package lj.td.pc;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cooker implements Runnable {
    FoodBox list = null;

    public Cooker(FoodBox list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            list.push(i);
            System.out.println("生产了第" + i);
        }
    }
}
