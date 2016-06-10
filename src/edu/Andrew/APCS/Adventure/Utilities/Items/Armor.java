package edu.Andrew.APCS.Adventure.Utilities.Items;

/**
 * Adventure
 *
 * Armor, extends Item
 *
 * Armor class is used for items that can hold health for the player
 */
public class Armor extends Item
{

    private double armorValue;


    public Armor(String itemName, double cost, double armorValue)
    {
        super(itemName, cost);
        this.armorValue = armorValue;
    }


    /**
     * Get the armor's value
     * @return double of armor's value
     */
    public double getArmorValue() { return this.armorValue; }


    /**
     * toString
     * @return the toString
     */
    @Override
    public String toString()
    {
        return "Armor: " + super.getItemName() + " | " + "$" + super.getCost() + " | " + armorValue + "\n";
    }
}
