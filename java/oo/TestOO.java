package oo;

public class TestOO {
    public static void main(String[] args) {
        var someone = new Person("Dow Joe", 30);
        someone.getInfo();
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name.strip();
    }

    public void setAge(int age){
        if (age < 0){
            throw new IllegalArgumentException("age cannot be negative.");
        }
        this.age = age;
    }

    public void getInfo(){
        System.out.println("Name: " +  this.name);
        System.out.println("Age: " + this.age);
    }
}