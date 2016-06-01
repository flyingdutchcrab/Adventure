package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 5/27/16.
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
     * Get the armor's valuse
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
