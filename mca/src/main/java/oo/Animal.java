package oo;

public class Animal {
    private int age;
    private String name;

    public Animal(){
        System.out.println("Animal");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("Can you run?");
    }
}
