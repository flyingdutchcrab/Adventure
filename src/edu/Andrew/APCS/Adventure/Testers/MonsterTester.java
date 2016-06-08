package edu.Andrew.APCS.Adventure.Testers;

import edu.Andrew.APCS.Adventure.Utilities.Mobs.Monster;

/**
 * Adventure
 *
 * MonsterTester
 *
 * Test the Monster class
 */
public class MonsterTester
{
    public static void main(String args[]) {
        Monster skrub = new Monster("skrub", 20, 10, 1, 10, 25, 5, 25, true, null);
        Monster skrublord = new Monster("skrublord", 25, 20, 10, 50, 35, 10, 45, true, null);
        Monster wyvern = new Monster("Wyvern", 400, 1, 50, 50, 1000, 45, 2000, true, null);


        System.out.println(skrub.toString());
        System.out.println(skrublord.toString());
        System.out.println(wyvern.toString());


    }
}
