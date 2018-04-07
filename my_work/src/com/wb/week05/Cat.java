package com.wb.week05;

public class Cat extends Pet {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void jiao() {
        System.out.println("Miao miao !");
    }
    @Override
    public void run() {
        System.out.println("Miao run .");
    }
    public void captureMice() {
        System.out.println("Capture mice !");
    }
}
