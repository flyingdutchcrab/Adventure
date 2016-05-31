package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 5/27/16.
 */
public class Armor extends Item
{
    //declare variables
    private double armorValue;


    //constructor
    public Armor(String n, double c, double av)
    {
        super(n, c);
        this.armorValue = av;
    }

    //getters and setters

    //get armor value
    public double getArmorValue()
    {
        return this.armorValue;
    }


    public String toString()
    {
        return "Armor: " + super.getItemName() + " | " + "$" + super.getCost() + " | " + armorValue + "\n";
    }
}
