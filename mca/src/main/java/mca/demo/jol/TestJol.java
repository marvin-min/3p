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
    }

    private static void printObject(Object o){
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("-----------------------");
    }
}
