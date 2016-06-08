package edu.Andrew.APCS.Adventure;

/**
 * Created by andrewbrook on 5/27/16.
 */
public class KeyItem extends Item
{

    private String use;


    public KeyItem(String itemName, double cost, String use)
    {
        super(itemName, cost);
        this.use = use;
    }


    /**
     * Getters
     */

    public String getUse() { return this.use; }


    /**
     * toString
     * @return toString
     */
    public String toString()
    {
        return "KeyItem: " + super.getItemName() + " | " + "$" + super.getCost() + " | " + use + "\n";
    }
} //end class
