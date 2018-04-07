package com.wb.week05;

public class Test {
    public static void main(int args,String[] arg) {
        Pet[] pets = new Pet[3];
        pets[1] = new Pet("father",33);
        pets[2] = new Dog("Son",12);
        pets[3] = new Cat("daughter",11);
        for( int i = 0 ; i < pets.length;i++ ) {
            pets[i].jiao();
            pets[i].toString();
        }
        GirlFriend gf = new GirlFriend("Lisa",18);
        gf.toString();
        gf.recivePets(pets);
    }
}
