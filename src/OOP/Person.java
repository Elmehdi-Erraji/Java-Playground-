package src.OOP;

public class Person {

    String name ;
    int age ;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void identification(String name, int age) {
        System.out.println(this.name + " " + age );
    }
}
