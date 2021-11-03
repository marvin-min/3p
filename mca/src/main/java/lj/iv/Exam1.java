package lj.iv;

import java.util.Date;

public class Exam1 {
    public static void main(String[] args) {

        int i = 1;
        Integer j = new Integer(10);
        String hello = "hello";
        String world = new String("hello");
        int []arr = {1,2,3,4,5};
        change(i,j,hello,world, arr);
        System.out.println(i);
        System.out.println(j);
        System.out.println(hello);
        System.out.println(world);
        System.out.println(hello == world);
        System.out.println(hello.equals(world));
        System.out.println(arr[0]);
        System.out.println("----------------------");
        User user = new User("lc",32);
        modifyUser(user);
        System.out.println(user.getName());
    }

    private static void modifyUser(User user){
        user = new User("hello",333);
        user.setName("hello0000");
//        user.setName("hellllo");

    }

    private static void change(int i, int j, String hello, String world, int []k){
        i += 2;
        j += 3;
        k[0] = 0;
        world = "asdfsafa";
        hello = hello.replace('l','I');
    }
}
