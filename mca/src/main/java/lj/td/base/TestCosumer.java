package lj.td.base;

import mca.demo.jol.JolUser;
import sun.misc.Unsafe;

import java.util.function.Consumer;


/**
 * 典型应用
 * 从Java 8开始，JDK使用invokedynamic及VM Anonymous Class结合来实现Java语言层面上的Lambda表达式。
 *
 * invokedynamic： invokedynamic是Java 7为了实现在JVM上运行动态语言而引入的一条新的虚拟机指令，它可以实现在运行期动态解析出调用点限定符所引用的方法，
 * 然后再执行该方法，invokedynamic指令的分派逻辑是由用户设定的引导方法决定。
 * VM Anonymous Class：可以看做是一种模板机制，针对于程序动态生成很多结构相同、仅若干常量不同的类时，可以先创建包含常量占位符的模板类，
 * 而后通过Unsafe.defineAnonymousClass方法定义具体类时填充模板的占位符生成具体的匿名类。生成的匿名类不显式挂在任何ClassLoader下面，
 * 只要当该类没有存在的实例对象、且没有强引用来引用该类的Class对象时，该类就会被GC回收。
 * 故而VM Anonymous Class相比于Java语言层面的匿名内部类无需通过ClassClassLoader进行类加载且更易回收。
 * 在Lambda表达式实现中，通过invokedynamic指令调用引导方法生成调用点，在此过程中，会通过ASM动态生成字节码，
 * 而后利用Unsafe的defineAnonymousClass方法定义实现相应的函数式接口的匿名类，然后再实例化此匿名类，并返回与此匿名类中函数式方法的方法句柄关联的调用点；
 * 而后可以通过此调用点实现调用相应Lambda表达式定义逻辑的功能。下面以如下图所示的Test类来举例说明。
 */
public class TestCosumer {
    public static void main(String[] args) throws InstantiationException {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lambda");
    }

}
