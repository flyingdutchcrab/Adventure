package edu.Andrew.APCS.Adventure.Testers;

import edu.Andrew.APCS.Adventure.*;

/**
 * Created by andrewbrook on 6/7/16.
 */
public class MonsterTester
{
    public static void main(String args[]) {
        Monster skrub = new Monster("skrub", 20, 10, 1, 10, 25, 5, 25, true, null);
        Monster skrublord = new Monster("skrublord", 25, 20, 10, 50, 35, 10, 45, true, null);
        Boss wyvern = new Boss("Wyvern", 400, 45, 2000, true, null, 500, 5000);

        System.out.println(skrub.toString());
        System.out.println(skrublord.toString());

        System.out.println(wyvern.toString());


    }
}
