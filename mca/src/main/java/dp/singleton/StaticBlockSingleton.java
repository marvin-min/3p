package dp.singleton;

/**
 * 饿汉式:
 * 缺点：一上来就创建，占用系统资源
 * 优点： 简单、线程安全
 * 可以通过 newInstance() 方法创建第二个实例
 */
public class StaticBlockSingleton {
    private static  StaticBlockSingleton instance = null;

    static {
        instance = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() {}

    public void hello(){
        System.out.println("StaticInstanceSingleton");
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StaticBlockSingleton.getInstance().hello();
        //返回false
        System.out.println((StaticBlockSingleton.class.newInstance() == StaticBlockSingleton.getInstance()));
    }
}
