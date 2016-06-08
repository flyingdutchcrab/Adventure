package edu.Andrew.APCS.Adventure;

/**
 * Created by andrewbrook on 5/12/16.
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


} //end class
