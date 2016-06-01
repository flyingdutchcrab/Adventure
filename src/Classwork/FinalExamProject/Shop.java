package Classwork.FinalExamProject;

import javax.swing.*;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by andrewbrook on 5/13/16.
 */
public class Shop
{

    public ArrayList<Item> shopInventory;
    private Scanner scan;
    @FXML private TextArea text;
    @FXML private TextField inputText;


    public Shop() {
        this.shopInventory = new ArrayList<Item>();
    }


    /**
     * Init. shop inv
     * @return ArrayList of the init. shop inv
     */
    public ArrayList<Item> initializeShopInventory() {

        Item wep1 = new Weapon("Boomstick", 300, 100);
        Item wep2 = new Weapon("Bow and Arrow", 50, 18);
        Item wep3 = new Weapon("Iron Sword", 70 , 20);
        Item key = new KeyItem("Gate Key", 20, "Opens the castle gate");
        Item arm1 = new Armor("Iron Armor", 100, 4);
        this.shopInventory.add(wep1);
        this.shopInventory.add(wep2);
        this.shopInventory.add(wep3);
        this.shopInventory.add(key);

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

    @Override
    public String toString() {
        return printShopInventory();
    }


}