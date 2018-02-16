package com.capgemini;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Closet!");

        /**
         * create clothes
         */
        ArrayList<Clothes> clothes = new ArrayList<Clothes>();
        Clothes pants = new Clothes(EClothesType.PANTS, "black", "year round");
        Clothes tshirt = new Clothes(EClothesType.TSHIRT, "blue", "summer");
        Clothes shorts = new Clothes(EClothesType.SHORTS, "navy", "summer");
        Clothes skirt = new Clothes(EClothesType.SKIRT, "grey", "year round");
        Clothes dress = new Clothes(EClothesType.DRESS, "green", "year round");
        clothes.add(pants);
        clothes.add(tshirt);
        clothes.add(shorts);
        clothes.add(skirt);
        clothes.add(dress);

        Closet closet = new Closet(EState.CLOSED);

        Person lucy = new Person("Lucy");

        lucy.hangClothesInCloset(closet, dress);

    }
}
