package lj.td.pc;

import java.util.ArrayList;
import java.util.List;

/**
 * 共同资源
 *
 * 生产者消费者问题
 * 生产者:
 *     判断
 *       等待
 *     生产
 *     唤醒
 *
 * 消费者:
 *    判断
 *      等待
 *    消费
 *    唤醒
 */
public class Restaurant {
    public static void main(String[] args) {
        FoodBox fb = new FoodBox();
        new Thread(new Cooker(fb)).start();
//        new Thread(new Cooker(fb)).start();
//        new Thread(new Diner(fb)).start();
        new Thread(new Diner(fb)).start();
    }
}
