package lj.td.proxy;

//1. 代理类可以完成一些真是类无法完成的事情
//2. 真是类只用关注自身的业务，代理类来完成其它事情。
public class ProxyDemo {
    public static void main(String[] args) {
        new ProxyCompany(new JavaCompany()).run();
    }
}


interface RunCompany {
    public void run();
}


class JavaCompany implements RunCompany {

    @Override
    public void run() {
        System.out.println("经营业务");
    }
}

class ProxyCompany implements RunCompany {
    private RunCompany target;

    public ProxyCompany(RunCompany target) {
        this.target = target;
    }

    @Override
    public void run() {
        System.out.println("工商注册。。。。。");
        target.run();
        System.out.println("报税+年审");
    }
}
