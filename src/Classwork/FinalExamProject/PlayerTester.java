package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 5/13/16.
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

        if (p.hasKeyItem("Gate Key"))
        {
            System.out.println("Player has key");
        }

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
    } //end main
} //end class
