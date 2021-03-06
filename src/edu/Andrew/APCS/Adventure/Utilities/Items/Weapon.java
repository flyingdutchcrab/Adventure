package edu.Andrew.APCS.Adventure.Utilities.Items;

/**
 * Adventure
 *
 * Weapon, extends Item
 *
 * A weapon that can be used to attack monsters
 */
public class Weapon extends Item
{

    private double damage;


    public Weapon(String n, double c, double dmg)
    {
        super(n, c);
        this.damage = dmg;
    }


    /**
     * Get weapon's damage
     * @return double of damage
     */
    public double getDamage() { return this.damage; }


    /**
     * toString
     * @return toStirng
     */
    public String toString()
    {
        return "Weapon: " + super.getItemName() + " | " + "$" + super.getCost() + " | " + damage + "\n";
    }

}
