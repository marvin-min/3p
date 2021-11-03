package cl;

import com.sun.jdi.Bootstrap;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ClassLoader.getSystemClassLoader().loadClass("framework.zk.ZkTest");
        }finally {
            System.out.println("......");
        }
    }
}
