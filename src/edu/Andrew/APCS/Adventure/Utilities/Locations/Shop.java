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
        this.shopInventory.add(new Weapon("Boomstick", 430, 1000));    //wep 1
        this.shopInventory.add(new Weapon("Bow and Arrow", 50, 18));   //wep 2
        this.shopInventory.add(new Weapon("Iron Sword", 70 , 40));     //wep 3
        this.shopInventory.add(new Weapon("Crystal Sword", 350, 600)); //wep 4
        this.shopInventory.add(new Weapon("Crossbow", 200, 500));      //wep 5
        this.shopInventory.add(new Weapon("Handcannon", 570, 1300));   //wep 6
        this.shopInventory.add(new Weapon("Dark Sword", 600, 2000));   //wep 7
        this.shopInventory.add(new Armor("Iron Armor", 100, 2));       //arm 1
        this.shopInventory.add(new KeyItem("Grave Key", 100, "Opens a strange grave")); //key1
        this.shopInventory.add(new KeyItem("Gate Key", 100, "Opens the castle gate")); //key2
        this.shopInventory.add(new KeyItem("Twin Peak Key", 100, "Opens twin peak"));


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