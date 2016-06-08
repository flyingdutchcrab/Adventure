package edu.Andrew.APCS.Adventure.Testers;


/**
 * Adventure
 *
 * ItemTester
 *
 * Test the Item class
 */
import edu.Andrew.APCS.Adventure.Utilities.Items.Item;
import edu.Andrew.APCS.Adventure.Utilities.Items.KeyItem;
import edu.Andrew.APCS.Adventure.Utilities.Items.Weapon;

public class ItemTester {
    public static void main(String args[])
    {
        Item medkit = new Item("Med-Kit", 25.0);
        Item sword = new Weapon("Iron Sword", 100.0, 50.0);
        Item key = new KeyItem("Gate Key", 300.0, "Opens the gate to the castle");

        System.out.println(medkit.toString());
        System.out.println(sword.toString());
        System.out.println(key.toString());

    } //end main
} //end ItemTester
