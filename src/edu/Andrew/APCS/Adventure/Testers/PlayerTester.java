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
        p.inventory.add(p.getWeapon());
        p.inventory.add(medkit);
        p.inventory.add(sword);
        p.inventory.add(key);

        if (p.containsItem("Gate Key"))
            System.out.println("Player has key");


        p.setHealth(50);
        p.checkLife();
        System.out.println(p.alive);

        if ( p.alive )
            System.out.println("Barley alive");

        p.setHealth(0);
        p.checkLife();

        if (!p.alive)
            System.out.println("Im Dead");

        System.out.println(p.printInventory());

    }
}
