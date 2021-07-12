package lj.td.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        testLazy();
    }

    public static void testLazy() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
//        Lazy lazy = Lazy.getInstance();
        Field field =Lazy.class.getDeclaredField("XAFlag");
        Constructor<Lazy> constructor = Lazy.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Lazy lazy1 = constructor.newInstance();
        field.setAccessible(true);
        field.set(lazy1,false);
        Lazy lazy = constructor.newInstance();

        System.out.println(lazy);
        System.out.println(lazy1);
    }

    public static void testEager() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Eager eager = Eager.getInstance();

        Constructor<Eager> constructor = Eager.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Eager eager1 = constructor.newInstance();

        System.out.println(eager);
        System.out.println(eager1);
    }
}
