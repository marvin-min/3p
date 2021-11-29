package dp.singleton;

public class SingleTonTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        EunmSingleton.INSTANCE.hello();
        EunmSingleton.class.newInstance();
    }
}
