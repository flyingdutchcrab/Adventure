package edu.Andrew.APCS.Adventure.Testers;

import edu.Andrew.APCS.Adventure.Utilities.Locations.Location;
import edu.Andrew.APCS.Adventure.Player;
import edu.Andrew.APCS.Adventure.Utilities.Locations.Shop;

/**
 * Adventure
 *
 * ShopTester
 *
 * Test the Shop class
 */
public class ShopTester
{
    public static void main(String args[])
    {
        Shop s = new Shop();
        Player ply = new Player();
        Location store = new Location("store", "STORE", "You are in a store. A wide variety of weapons and items can be bought here", false, null);
        ply.setCurrentLoc(store);

        System.out.println(s.toString());
        System.out.println(store.toString());


    }
}
