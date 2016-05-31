package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 4/6/16.
 */
import java.util.*;
public class Weapon extends Item
{
    //declare variables
    private double damage;


    //constructor
    public Weapon(String n, double c, double dmg)
    {
        super(n, c);
        this.damage = dmg;
    }

    //getters and setters

   /* //accesses weapon name
    public String getItemName()
    {
        super.getItemName();
    }
*/
    //get weapon damage
    public double getDamage()
    {
        return this.damage;
    }
/*
    //get weapon cost
    public double getCost()
    {
        super.getCost();
    }
*/
    public String toString()
    {
        return "Weapon: " + super.getItemName() + " | " + "$" + super.getCost() + " | " + damage + "\n";
    }
}
