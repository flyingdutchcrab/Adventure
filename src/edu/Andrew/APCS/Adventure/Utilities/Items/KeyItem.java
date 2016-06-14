package edu.Andrew.APCS.Adventure.Utilities.Items;

/**
 * Adventure
 *
 * KeyItem, extends Item
 *
 * And item that can be used as a key to unlock a location
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

}
