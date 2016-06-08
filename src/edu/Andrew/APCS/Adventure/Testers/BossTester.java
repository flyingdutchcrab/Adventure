package edu.Andrew.APCS.Adventure.Testers;

import edu.Andrew.APCS.Adventure.Utilities.Mobs.Boss;
import edu.Andrew.APCS.Adventure.Utilities.Mobs.Monster;

/**
 * Adventure
 *
 * BossTester
 *
 * Test the Boss (Monster) class
 */
public class BossTester
{

    public static void main(String args[]) {
        Monster skrub = new Boss("skrub", 20, 10, 1, 10, 25, 5, 25, true, null, 500, 5000);
        Monster skrublord = new Boss("skrublord", 25, 20, 10, 50, 35, 10, 45, true, null, 500, 5000);
        Monster wyvern = new Boss("Wyvern", 400, 1, 50, 50, 1000, 45, 2000, true, null, 500, 5000);


        System.out.println(skrub.toString());
        System.out.println(skrublord.toString());
        System.out.println(wyvern.toString());

    }

}
