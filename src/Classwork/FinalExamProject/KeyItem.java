package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 5/27/16.
 */
public class KeyItem extends Item
{
    //declare variables
    private String use;


    //constructor
    public KeyItem(String n, double c, String u)
    {
        super(n, c);
        this.use = u;
    }

    //getters and setters

    //get weapon damage
    public String getUse()
    {
        return this.use;
    }

    public String toString()
    {
        return "KeyItem: " + super.getItemName() + " | " + "$" + super.getCost() + " | " + use + "\n";
    }
} //end class
