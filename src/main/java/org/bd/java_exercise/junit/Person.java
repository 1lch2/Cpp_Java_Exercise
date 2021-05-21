package org.bd.java_exercise.junit;

public class Person {
    int uid;
    int age;
    String name;
    String address;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uid=" + uid +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getBirthYear(int age) {
        if (age >= 120) {
            throw new IllegalArgumentException();
        }
        return 2021 - age;
    }

    public int getBirthYear() {
        return 2021 - this.age;
    }
}
