package iv.singleton;

import sun.reflect.Reflection;

public class LazySingleton {
    private static final LazySingleton instance = new LazySingleton();
    private LazySingleton(){}

    public static LazySingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) throws ClassNotFoundException {

    }
}
