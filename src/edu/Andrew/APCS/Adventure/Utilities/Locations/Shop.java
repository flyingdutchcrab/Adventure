package edu.Andrew.APCS.Adventure.Utilities.Locations;


import java.util.*;

import edu.Andrew.APCS.Adventure.Utilities.Items.Armor;
import edu.Andrew.APCS.Adventure.Utilities.Items.Item;
import edu.Andrew.APCS.Adventure.Utilities.Items.KeyItem;
import edu.Andrew.APCS.Adventure.Utilities.Items.Weapon;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    @FXML private TextArea text;
    @FXML private TextField inputText;


    public Shop() {
        this.shopInventory = new ArrayList<>();
    }


    /**
     * Init. shop inv
     * @return ArrayList of the init. shop inv
     */
    public ArrayList<Item> initializeShopInventory() {

        Item wep1 = new Weapon("Boomstick", 430, 1000);
        Item wep2 = new Weapon("Bow and Arrow", 50, 18);
        Item wep3 = new Weapon("Iron Sword", 70 , 40);
        Item wep4 = new Weapon("Crystal Sword", 350, 600);
        Item wep5 = new Weapon("Crossbow", 200, 500);
        Item wep6 = new Weapon("Handcannon", 570, 1300);
        Item wep7 = new Weapon("Dark Sword", 600, 2000);

        Item arm1 = new Armor("Iron Armor", 100, 2);

        Item key1 = new KeyItem("Grave Key", 100, "Opens a strange grave");

        this.shopInventory.add(wep1);
        this.shopInventory.add(wep2);
        this.shopInventory.add(wep3);
        this.shopInventory.add(wep4);
        this.shopInventory.add(wep5);
        this.shopInventory.add(wep6);
        this.shopInventory.add(wep7);

        this.shopInventory.add(arm1);


        this.shopInventory.add(key1);


        return shopInventory;
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