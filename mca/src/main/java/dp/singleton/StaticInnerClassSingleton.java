package dp.singleton;

/**
 * 线程安全
 * 实现简单
 * 可以通过 newInstance() 方法创建第二个实例
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public StaticInnerClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
