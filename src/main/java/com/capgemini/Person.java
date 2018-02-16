package com.capgemini;

public class Person {

    String name;
    int power;

    public Person(String name) {
        this.name = name;
    }
    public void hangClothesInCloset(Closet closet, Clothes clothes) {
        this.power = 1;
        if (closet.state.equals(EState.BROKEN)) {
            System.out.println("You cannot place clothes in a broken closet!");
            return;
        }
        if (!clothes.inCloset) {
            clothes.inCloset = true;
            System.out.println("The " + clothes.type + " is now in your closet.");
            closet.clothesInCloset.add(clothes);
            closet.kick(closet, this.power);
            return;
        } else {
            System.out.println("You cannot hang this item in your closet.");
            return;
        }

    }
}
