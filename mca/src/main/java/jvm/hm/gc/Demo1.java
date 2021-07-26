package jvm.hm.gc;

import java.util.ArrayList;

//-Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC  -XX:+PrintGCDetails -verbose:gc
public class Demo1 {
    private static final int _1M = 1024 * 1024;
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        list.add(new byte[8*_1M]);
        list.add(new byte[8*_1M]);
    }
}
