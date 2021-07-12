package mca.demo.jol;

public class JolUser {
    private int age;
    private Integer grade;
    private String name;

    public JolUser(){

    }
    public JolUser(int age, Integer grade, String name) {
        this.age = age;
        this.grade = grade;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
