package lj.td.single;

import java.lang.reflect.Constructor;

//enum 本身也是一个类
public enum EnumSingleton {
    INSTANCE;

//    public static EnumSingleton getInstance(){
//        return INSTANCE;
//    }

    public void say(){
        System.out.println("...hl...");
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        //failed to create instance by reflect
     /*   Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumSingleton lazy1 = constructor.newInstance();*/
        EnumSingleton demo = EnumSingleton.INSTANCE;
        demo.say();
    }

}

