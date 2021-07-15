package jvm.hm;

public class StringTableTest {
    public static void main(String[] args) {

        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2; //new StringBuilder().append("a").append("b").toString()
        String s5 = "a" + "b"; //编译期优化
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);

        String s6 = new String("d") + new String("f");
        String s7 = s6.intern();
        System.out.println(s6==s7);

        s5= "asdfs";
        System.out.println(s3);//ab
        System.out.println(s5);//asdfs


    }
}
