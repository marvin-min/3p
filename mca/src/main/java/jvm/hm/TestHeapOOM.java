package jvm.hm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class TestHeapOOM {
    public static void main(String[] args) {
        int i=0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
