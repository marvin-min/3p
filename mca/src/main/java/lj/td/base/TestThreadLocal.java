package lj.td.base;

public class TestThreadLocal {
//    private static User user = new User("jerry", 23);

    private static ThreadLocal<User> user = ThreadLocal.withInitial(() -> new User("jerry", 23));

    public void fun(User user) {
        System.out.println(Thread.currentThread().getName() + "开始执行，修改前的username[" + user.getName() + "]");
        user.setName("tom");
        System.out.println(Thread.currentThread().getName() + "执行完毕，修改后的username[" + user.getName() + "]");
    }

    public static void main(String[] args) {
        TestThreadLocal te = new TestThreadLocal();
        new Thread(()->{
            te.fun(user.get());
        },"Thread A").start();

        new Thread(()->{
            te.fun(user.get());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Thread B").start();
    }
}

