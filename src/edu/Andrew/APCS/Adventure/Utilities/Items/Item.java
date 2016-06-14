package edu.Andrew.APCS.Adventure.Utilities.Items;

/**
 * Adventure
 *
 * Item
 *
 * Item is used for things in the player's inv. and the shop.
 */
public class Item
{

    private String itemName;
    private double cost;


    public Item(String itemName, double cost)
    {
        this.itemName = itemName;
        this.cost = cost;

    }


    /**
     * getters
     */

    public String getItemName() { return this.itemName; }

    public double getCost() { return this.cost; }


    /**
     * toString
     * @return the toString of this item
     */
    public String toString()
    {
        return "Item: " + itemName + " | " + "$" + cost + "\n";
    }


}
