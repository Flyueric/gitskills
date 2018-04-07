package com.wb.week05;

public class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, age);
    }

    public Dog() {
        super();
    }

    @Override
    public void jiao() {
        System.out.println("Wang wang !");
    }
    @Override
    public void run() {
        System.out.println("Dog run !");
    }
    public void swim() {
        System.out.println("I can swim !");
    }
}
