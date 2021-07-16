package jvm.hm;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//-verbose:gc
// -Xmx20m -verbose:gc  一直触发GC
public class SoftReferenceTest {
    public static void main(String[] args) throws IOException {
//        softReference();
//        strongerReference();
        weakReference();
    }


    //软引用。
    public static void softReference() throws IOException {

        List<SoftReference<byte[]>> bytes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[1024 * 1024 * 10]);
            System.out.println(ref.get());
            bytes.add(ref);
            System.out.println(bytes.size());
        }
        System.in.read();
    }

    //软引用。
    public static void weakReference() throws IOException {

        List<WeakReference<byte[]>> bytes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[1024 * 1024 * 10]);
            bytes.add(ref);
            System.out.println(bytes.size());
        }
        System.in.read();
    }

    public static void strongerReference() throws IOException {
        /**
         * 强引用 GC 失败
         */
        List<Byte[]> bytes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Byte[] b = new Byte[1024 * 1024 * 10];
            bytes.add(b);
        }
        System.in.read();
    }

}
