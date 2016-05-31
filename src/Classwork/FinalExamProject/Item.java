package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 5/12/16.
 */
public class Item
{
    private String itemName;
    private double cost;

    public Item(String n, double c)
    {
        this.itemName = n;
        this.cost = c;

    } //end Item constructor

    public String getItemName()
    {
        return this.itemName;
    } //end getItemName

    public double getCost()
    {
        return this.cost;
    } //end getCost

    public String toString()
    {
        return "Item: " + itemName + " | " + "$" + cost + "\n";
    } //end toString
} //end class
