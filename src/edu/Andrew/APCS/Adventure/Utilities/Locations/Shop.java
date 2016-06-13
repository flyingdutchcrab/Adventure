package edu.Andrew.APCS.Adventure.Utilities.Locations;

import java.util.*;
import edu.Andrew.APCS.Adventure.Utilities.Items.Armor;
import edu.Andrew.APCS.Adventure.Utilities.Items.Item;
import edu.Andrew.APCS.Adventure.Utilities.Items.KeyItem;
import edu.Andrew.APCS.Adventure.Utilities.Items.Weapon;

/**
 * Adventure
 *
 * Shop
 *
 * The Shop class containing the shop information.
 */

public class Shop
{

    private ArrayList<Item> shopInventory;


    public Shop() {
        this.shopInventory = new ArrayList<>();

        /**
         * populate the Shop's inventory
         */
        this.shopInventory.add(new Weapon("Boomstick", 1000, 430));    //wep 1
        this.shopInventory.add(new Weapon("Bow and Arrow", 50, 18));   //wep 2
        this.shopInventory.add(new Weapon("Iron Sword", 70 , 40));     //wep 3
        this.shopInventory.add(new Weapon("Crystal Sword", 600, 350)); //wep 4
        this.shopInventory.add(new Weapon("Crossbow", 500, 200));      //wep 5
        this.shopInventory.add(new Weapon("Handcannon", 1300, 570));   //wep 6
        this.shopInventory.add(new Weapon("Dark Sword", 2000, 600));   //wep 7
        this.shopInventory.add(new Armor("Iron Armor", 100, 2));       //arm 1
        this.shopInventory.add(new KeyItem("Grave Key", 100, "Opens a strange grave")); //key1
        //this.shopInventory.add(new KeyItem("King's Key", 50, "Opens the king's chamber, and something else"));
        //this.shopInventory.add(new KeyItem("Mysterious Rune", 50, "An ominous face-like rune whose purpose is completely unknown"));
        /*These were just for tests, you're not supposed to buy them
        this.shopInventory.add(new KeyItem("Gate Key", 100, "Opens the castle gate"));
        this.shopInventory.add(new KeyItem("Twin Peak Key", 100, "Opens twin peak"));
        this.shopInventory.add(new KeyItem("Reef Key", 100, "Opens the reef"));
        */

    }


    /**
     * Get the shop's inventory.
     * @return ArrayList of shop's inventory
     */
    public ArrayList<Item> getShopInventory() {
        return shopInventory;
    }


    /**
     * toString for shop
     * @return toString
     */
    public String printShopInventory()
    {
        String shopItemList = "These are the items for sale:\n";
        for(Item i: shopInventory)
        {
            shopItemList += i.toString();
        }
        return shopItemList;

    }

    /**
     * toString
     * @return toString
     */
    public String toString() {
        return printShopInventory();
    }


}