package lj.td.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TenDown {
    public static void main(String[] args) {
        try {
            tendown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tendown() throws InterruptedException {
        int number = 10;
        while (true) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(date));
            if (number <= 0) {
                break;
            }
            number--;
            Thread.sleep(1000);
        }
    }
}
