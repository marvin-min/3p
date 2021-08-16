package oo;

//import org.openjdk.jol.info.ClassLayout;

public class Dog extends Animal{
    public Dog(){
        System.out.println(super.equals(this));
        System.out.println("I am a Dog");
    }

    public static void main(String[] args) {
        Animal Animal = new Dog();
//        System.out.println(ClassLayout.parseInstance(dog).toPrintable());
    }
}
