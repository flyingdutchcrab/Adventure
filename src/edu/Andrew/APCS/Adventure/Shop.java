package edu.Andrew.APCS.Adventure;


import java.util.*;

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

        Item wep1 = new Weapon("Boomstick", 300, 100);
        Item wep2 = new Weapon("Bow and Arrow", 50, 18);
        Item wep3 = new Weapon("Iron Sword", 70 , 20);
        Item key = new KeyItem("Grave Key", 20, "Opens a strange grave");
        Item arm1 = new Armor("Iron Armor", 100, 4);
        this.shopInventory.add(wep1);
        this.shopInventory.add(wep2);
        this.shopInventory.add(wep3);
        this.shopInventory.add(key);

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