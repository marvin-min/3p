package mca.demo.jol;

import org.openjdk.jol.info.ClassLayout;

public class TestJol {
    public static void main(String[] args) {
        Object o = new Object();
        printObject(o);
        JolUser jolUser = new JolUser(23,4,"marvin");
        printObject(jolUser);
        JolUser jo = new JolUser();
        printObject(jo);
        hello(3);
    }

    //java.lang.StackOverflowError
    public static void hello(int a){
        a = a+3;
        b(a);
    }

    public static void b(int b){
        b = b++;
        c(b);
    }
    public static void c(int c){
        c = c++;
        System.out.println(c);
    }
    private static void printObject(Object o){
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("-----------------------");
    }
}
