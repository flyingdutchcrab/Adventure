package edu.Andrew.APCS.Adventure.Testers;

import edu.Andrew.APCS.Adventure.*;
import edu.Andrew.APCS.Adventure.Utilities.Items.Item;
import edu.Andrew.APCS.Adventure.Utilities.Items.KeyItem;
import edu.Andrew.APCS.Adventure.Utilities.Items.Weapon;

/**
 * Adventure
 *
 * PlayerTester
 *
 * Tests the Player class
 */
public class PlayerTester
{
    public static void main(String args[])
    {
        Player p = new Player();
        System.out.println(p.toString());

        Item medkit = new Item("Med-Kit", 25.0);
        Item sword = new Weapon("Iron Sword", 100.0, 50.0);
        Item key = new KeyItem("Gate Key", 20, "Opens the castle gate");
        p.getInventory().add(p.getWeapon());
        p.getInventory().add(medkit);
        p.getInventory().add(sword);
        p.getInventory().add(key);

        if (p.containsItem("Gate Key"))
            System.out.println("Player has key");


        p.setHealth(50);
        p.checkLife();
        System.out.println(p.isAlive());

        if ( p.isAlive() )
            System.out.println("Barley alive");

        p.setHealth(0);
        p.checkLife();

        if (!p.isAlive())
            System.out.println("Im Dead");

        System.out.println(p.printInventory());

    }
}
