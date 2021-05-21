package org.bd.java_exercise.reflection;

public class HelloImpl implements Hello{
    @Override
    public void sayHi(String name) {
        System.out.println("Hello, " + name);
    }
    
    private void diHola() {
        System.out.println("Como estas.");
    }
}