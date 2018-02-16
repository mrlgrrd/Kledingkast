package com.capgemini;

public class Clothes {

    public Clothes(EClothesType type, String color, String season) {
        this.type = type;
        this.color = color;
        this.season = season;
        this.inCloset = false;
    }

    EClothesType type;

    String color;

    String season;

    boolean inCloset;
}
