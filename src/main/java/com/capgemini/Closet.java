package com.capgemini;

import java.util.ArrayList;

public class Closet implements ICloset {

    EState state;
    ArrayList<Clothes> clothesInCloset = new ArrayList<Clothes>();

    private boolean personInCloset;

    private int power;

    /**
     * constructor for the closet
     * @param state is the closet open, closed or broken
     */
    public Closet(EState state) {
        this.state = state;
        this.personInCloset = false;
    }

    /**
     * open the closet
     * @param closet which closet
     */
    public void open(Closet closet) {
        System.out.println("Opening the closet...");
        switch (closet.state) {
            case CLOSED:
                closet.state = EState.OPEN;
                System.out.println("The closet is now open.");
                enter(closet);
                break;
            case OPEN:
                System.out.println("The closet was already open.");
                break;
            case BROKEN:
                System.out.println("You cannot open an broken closet!");
                break;
        }


    }

    /**
     * enter the closet
     * @param closet which closet
     */
    public void enter(Closet closet) {
        switch (closet.state) {
            case OPEN:
                this.personInCloset = true;
                System.out.println("You are now in the closet");
                int random = (int) (Math.random() * 10 + 1);
                if (random == 1) {
                    System.out.println("You have entered the mystical land of Narnia!");
                    narnia(closet);
                }
                if (random != 1){
                    System.out.println("Nothing interesting to see here.");
                    exit(closet);
                }
                break;
            case CLOSED:
                System.out.println("You need to open the door first.");
                break;
            case BROKEN:
                System.out.println("How would you get in an broken closet? Maybe you should get a new one first.");
                break;
        }
    }

    /**
     * exit the closet
     * @param closet which closet
     */
    public void exit(Closet closet) {
        if (closet.personInCloset && closet.state != EState.BROKEN) {

            switch (closet.state) {
                case OPEN:
                    closet.personInCloset = false;
                    System.out.println("You have come out of the closet.");
                    System.out.println("");
                    System.out.println("You decide to get back in the closet.");
                    enter(closet);
                    break;
                case CLOSED:
                    System.out.println("Open the door first.");
                    break;

            }

        } else if (closet.state.equals(EState.BROKEN)) {
            System.out.println("you can't exit a broken closet.");
        } else {
            System.out.println("You are not in the closet.");
        }

    }

    /**
     * kick the closet
     * chance is 1:5 that the maid hears you
     * chance is 3:10 that you break the closet
     * chance is 1:2 that nothing happens
     * @param closet which closet
     * @param power your current power
     */
    public void kick(Closet closet, int power) {
        System.out.println("You're angry and decide to kick the closet.");
        this.power = power;
        if (closet.state != EState.BROKEN) {

            int random = (int) (Math.random() * 10 + 1);
            switch (random) {
                case 1:
                case 2:
                    System.out.println("You kicked the closet. The maid ia coming for you, she's very angry! RUN!");
                    System.out.println("\033[31mThe maid sends you to your room.\033[0m");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("");
                    System.out.println("You sneak back to the closet");
                    kick(closet, power);
                    break;
                case 4:
                case 5:
                case 3:
                    System.out.println("\033[31mYou kicked it good! The closet is now broken.\033[0m");
                    closet.state = EState.BROKEN;
                    fix(closet);
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    System.out.println("You kicked the closet.");
                    System.out.println("Nothing special happened.");
                    System.out.println("");
                    open(closet);
                    break;
            }
        } else {
            System.out.println("The closet is already broken");
        }

    }

    /**
     * enter narnia.
     * the chance is 1:100 that you defeat the witch in one try.
     * if you lose you exit narnia and start over.
     * if you start over, your power goes up by 1
     * @param closet which closet
     */
    private void narnia(Closet closet) {
        System.out.println("Welcome in Narnia. You must talk to King Aslan as soon as you can!");
        System.out.println("But beware, before you can talk to him you must first defeat the white witch!");
        System.out.println("Your power is " + this.power + ".");
        System.out.println("O NO! HERE SHE COMES!");
        System.out.println("The battle starts!");
        int random = (int) (Math.random() * 100 + 1);
        if (random <= power) {
            System.out.println("You have defeated the white witch!");
            System.out.println("You can talk to King Aslan now.");
            System.out.println("\033[33m__________________________¶¶¶¶¶____________\n" +
                    "__________________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_________\n" +
                    "_______________¶¶¶¶¶¶¶¶¶¶¶¶¶  ¶  ¶¶¶¶¶¶¶¶¶¶¶¶\n" +
                    "______________¶¶¶¶¶¶¶¶¶   ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
                    "________________¶¶¶ ¶¶¶¶  ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶    \n" +
                    "__________________¶¶¶¶¶¶¶¶¶¶¶¶¶    ¶¶¶¶¶¶¶¶¶¶\n" +
                    "_________________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶   ¶¶¶¶¶\n" +
                    "_______________¶¶¶¶¶    ¶¶¶¶¶¶ ¶¶ ¶¶¶  ¶¶¶¶¶¶\n" +
                    "_____________¶¶¶          ¶¶¶¶¶   ¶¶¶       ¶\n" +
                    "___________¶¶¶              ¶¶¶  ¶¶¶¶        \n" +
                    "__________¶¶¶                  ¶¶  ¶¶        \n" +
                    "_________¶¶¶¶¶¶¶                ¶¶ ¶¶¶   ¶¶  \n" +
                    "_______¶¶  ¶¶¶¶               ¶¶¶¶ ¶¶¶   ¶¶¶ \n" +
                    "_____¶¶                       ¶¶¶¶ ¶¶¶    ¶¶ \n" +
                    "___¶¶¶                        ¶¶¶¶ ¶¶     ¶¶ \n" +
                    "__¶¶¶  ¶                      ¶¶¶¶ ¶¶     ¶¶ \n" +
                    "_¶¶   ¶¶                      ¶¶¶¶ ¶¶     ¶¶ \n" +
                    "¶¶¶¶¶¶¶                       ¶¶¶ ¶¶      ¶¶ \n" +
                    "_¶¶¶¶¶                       ¶¶¶¶ ¶¶      ¶¶ \n" +
                    "__¶¶              ¶¶¶      ¶¶¶¶¶         ¶¶¶ \n" +
                    "___¶¶¶¶¶¶¶¶¶   ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶          ¶¶¶ \n" +
                    "____¶¶¶¶¶¶¶¶ ¶¶¶¶  ¶¶¶¶¶¶¶¶¶¶¶           ¶¶¶¶\n" +
                    "___¶¶     ¶  ¶¶       ¶¶¶¶¶¶¶    ¶¶     ¶¶¶¶¶\n" +
                    "__¶¶¶        ¶¶    ¶¶¶¶¶ ¶¶¶    ¶¶      ¶¶¶¶¶\n" +
                    "___¶¶¶¶¶¶ ¶¶¶¶    ¶¶¶¶  ¶¶¶    ¶¶¶      ¶¶¶¶¶\n" +
                    "____¶¶¶¶¶¶¶¶    ¶¶¶¶¶  ¶¶¶    ¶¶¶        ¶¶¶_\n" +
                    "_______¶¶      ¶¶¶¶¶   ¶¶  ¶¶ ¶¶¶        ¶¶¶_\n" +
                    "_____________¶¶¶¶¶¶¶  ¶¶¶ ¶¶  ¶¶¶        ¶¶¶_\n" +
                    "____________¶¶¶  ¶¶   ¶¶¶¶¶   ¶¶¶  ¶¶     ¶¶_\n" +
                    "____________¶¶   ¶¶   ¶¶¶¶     ¶¶¶¶¶¶¶       \n" +
                    "___________¶¶¶   ¶¶    ¶¶¶      ¶¶¶¶¶¶¶      \n" +
                    "___________¶¶    ¶¶    ¶¶¶      ¶¶¶¶¶¶¶¶     \n" +
                    "__________¶¶¶     ¶    ¶¶¶        ¶¶  ¶¶¶    \n" +
                    "__________¶¶¶                           ¶¶¶  \n" +
                    "___________¶¶¶                            ¶¶¶\n" +
                    "___________¶¶¶                              ¶\n" +
                    "___________¶¶¶                               \n" +
                    "____________¶¶¶                              \n" +
                    "____________¶¶¶      ¶¶          ¶¶¶¶¶¶¶     \n" +
                    "_____________¶¶¶   ¶¶¶¶¶¶       ¶¶¶¶¶¶¶¶¶¶¶  \n" +
                    "______________¶¶¶¶ ¶¶   ¶¶       ¶¶¶¶¶¶¶¶¶¶¶¶\n" +
                    "________________¶¶¶¶¶    ¶¶¶      ¶¶¶¶¶¶¶¶¶¶¶\n" +
                    "__________________¶¶¶¶    ¶¶¶     ¶¶         \033[0m");
            System.out.println("");
            return;

        } else if (random > power) {
            System.out.println("\33[31mThe witch has defeated you. Your quest begins over.\33[0m");
            ++this.power;
            this.personInCloset = false;
            System.out.println("You are outside of the closet.");
            System.out.println("");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("");
            this.state = EState.CLOSED;
            open(closet);
        }
    }

    /**
     * fix the closet if it is broken
     * @param closet which closet
     */
    private void fix(Closet closet){
        System.out.println("You decide to fix the closet so you can kick it again.");
        closet.state = EState.CLOSED;
        kick(closet, this.power);

    }
}
