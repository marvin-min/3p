package dp.singleton;

/**
 * 饿汉式:
 * 缺点：一上来就创建，占用系统资源
 * 优点： 简单、线程安全
 * 可以通过 newInstance() 方法创建第二个实例
 */
public class StaticInstanceSingleton {
    private static final StaticInstanceSingleton INSTANCE = new StaticInstanceSingleton();

    private StaticInstanceSingleton() {}

    public void hello(){
        System.out.println("StaticInstanceSingleton");
    }

    public static StaticInstanceSingleton getInstance(){
        return INSTANCE;
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StaticInstanceSingleton.getInstance().hello();
        //返回false
        System.out.println((StaticInstanceSingleton.class.newInstance() == StaticInstanceSingleton.INSTANCE));
    }
}
