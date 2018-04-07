package com.wb.week05;

public class GirlFriend {
    private String name;
    private int age;

    public GirlFriend() {
        super();
    }

    public GirlFriend(String name , int age) {
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
    public void recivePets(Pet[] pets) {
        for (int i = 0; i<pets.length; i++ ) {
            System.out.println(pets[i].getName()+"   ");
        }
        System.out.println("Thank you ! I have recived your pets !");
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
