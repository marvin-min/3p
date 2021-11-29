package dp.singleton;

/**
 * 饿汉式
 * 延迟加载
 * 线程安全
 * 代码复杂， 注意volatile 是必须的, 因为 instance = new DoubleCheckLockSingleton()并不是一个原子操作
 */
public class DoubleCheckLockSingleton {
    private volatile DoubleCheckLockSingleton instance = null;
    private DoubleCheckLockSingleton(){}

    public DoubleCheckLockSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLockSingleton.class) {
                if(instance == null){
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}
