package dp.singleton;

/**
 * 饿汉式:
 * 缺点：一上来就创建，占用系统资源
 * 优点： 简单、线程安全
 * 且可以通过 newInstance() 方法创建第二个实例
 * EunmSingleton.class.newInstance(); 会报异常
 */
public enum EunmSingleton {
    INSTANCE;
    public void hello(){
        System.out.println(this.getClass().getName());
    }
}
