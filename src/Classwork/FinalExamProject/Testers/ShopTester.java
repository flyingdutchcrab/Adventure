package Classwork.FinalExamProject.Testers;

import Classwork.FinalExamProject.*;

import Classwork.FinalExamProject.Location;
import Classwork.FinalExamProject.Player;
import Classwork.FinalExamProject.Shop;

/**
 * Created by andrewbrook on 5/13/16.
 */
public class ShopTester
{
    public static void main(String args[])
    {
        Shop s = new Shop();
        Player ply = new Player();
        Location store = new Location("store", "STORE", "You are in a store. A wide variety of weapons and items can be bought here", false, null);
        ply.currentLoc = store;
        //s.doShop();


    }
}
