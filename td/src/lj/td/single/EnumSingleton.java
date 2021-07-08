package lj.td.single;

import java.lang.reflect.Constructor;

//enum 本身也是一个类
public enum EnumSingleton {
    INSTANCE;

    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumSingleton lazy1 = constructor.newInstance();
    }

}

