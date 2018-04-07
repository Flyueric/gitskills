package com.wb.week05;

public class Pet {
    private String name;
    private int age;

    public Pet() {
        super();
    }
    public Pet(String name , int age) {
        super();
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
    public void jiao() {
        System.out.println("jiao jiao jiao !");
    }
    public void run() {
        System.out.println("I can run !");
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
