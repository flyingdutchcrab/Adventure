package edu.Andrew.APCS.Adventure;

import java.util.*;

import edu.Andrew.APCS.Adventure.Utilities.Items.Armor;
import edu.Andrew.APCS.Adventure.Utilities.Items.Item;
import edu.Andrew.APCS.Adventure.Utilities.Locations.Location;
import edu.Andrew.APCS.Adventure.Utilities.Items.Weapon;

/**
 * Adventure
 *
 * Player
 *
 * The Player him/her slef!
 */
public class Player
{

    private final int THRESHOLD = 100;

    private double health;
    private double armorValue;
    private double damage;
    private int level;
    private int insight;
    private double xp;
    private String playerName;
    private Weapon weapon; //Expecting an Weapon here
    private Armor armor; //expecting a Armor here
    private double wallet;
    private boolean alive;
    private Location currentLoc;
    private ArrayList<Item> inventory;


    public Player() {
        this.health = 100.0; //sets players default health to 100
        this.playerName = "NotSet"; //sets players default name as not set
        this.level = 1;
        this.xp = 1.0;
        this.insight = 1;
        this.wallet = 100.0; //sets players default wallet as $0
        this.alive = true; //sets players default status to alive
        this.inventory = new ArrayList<>();
        this.currentLoc = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", false, null);

        Weapon stick = new Weapon("wooden stick", 25.0, 10.0); //sets players default weapon as no weapon
        equipWeapon(stick);
        inventory.add(stick);
        this.damage = weapon.getDamage(); //sets players default damage as 10

        Armor shirt = new Armor("T-Shirt", 10, 1);
        equipArmor(shirt);
        inventory.add(shirt);
        this.armorValue = armor.getArmorValue();


    }


    /**
     * Print the player's inventory
     * @return String with the inventory
     */
    public String printInventory()
    {
        String itemList = "These are the items in your inventory:\n";

        for(Item i : getInventory())
            itemList += i.toString();

        return itemList;

    }


    /**
     * Get a Single Location (adv.)
     * @param ID Location's ID
     * @return the Single Location
     */
    public Location getSingleLoc(String ID)
    {
        Adventure adv = new Adventure();
        Location singleLoc = null;

        for(Location aLoc : adv.getAllLocations())
        {
            if(aLoc.getID().equals(ID))
            {
                singleLoc = aLoc;
                break;
            }
        }

        return singleLoc;

    }


    /**
     * Check player's life
     *
     * Should be called each time after health is dealt
     */
    public void checkLife()
    {

        if (this.health <= 0)
        {
            if (this.health < 0 ) {

                this.health = 0.0;
                this.alive = false;

            } else
                this.alive = false;

        }
    }


    /**
     * Check if player has a Item in their inventory
     * @param item the item to search for
     * @return true if player has item; false if no item found
     */
    public boolean containsItem(String item) {

        for (int i = 0; i < this.getInventory().size(); i++)
            if (this.getInventory().get(i).getItemName().equalsIgnoreCase(item))
                return true;

        return false;

    }


    /**
     * Equips an item from the player's inventory
     * @param w the wepon to equip
     */
    public void equipWeapon(Weapon w) { this.weapon = w; }

    public void equipArmor(Armor a) { this.armor = a; }


    /**
     * Checks level based of XP.. yes.
     */
    private void checkLevel() {

        int oldLv = level;


        if (xp <= 0) //check to make sure that XP is not below 0
            xp = 1;


        //Maths: http://gamedev.stackexchange.com/a/110456
        level = (int) (Math.sqrt((THRESHOLD * THRESHOLD) + (8 * xp * THRESHOLD)) + THRESHOLD) / (2*THRESHOLD);


        if (oldLv < level)
            health += 50;

    }


    /**
     * Setters and getters
     */
    public void setPlayerName(String name) { this.playerName = name; }

    public String getPlayerName() { return playerName; }

    public double getHealth() { return this.health; }

    public void setHealth(double newhealth) { this.health = newhealth; }

    public int getLevel() { return this.level; }

    public int getXp() { return (int) this.xp; }

    public void setXp(double xp) { this.xp = xp; checkLevel(); }

    public void addXP(double xp) { this.xp += xp; checkLevel(); }

    public int getInsight() { return this.insight; }

    public double getDamage() { return this.damage; }

    public double getWallet() { return this.wallet; }

    public void addWallet(double amount) { wallet += amount;}

    public Item getWeapon() { return this.weapon; }

    public Item getArmor() { return this.armor; }

    public double getPlayerArmorValue() { return this.armorValue; }

    public Location getCurrentLoc() { return this.currentLoc; }

    public void setCurrentLoc(Location currentLoc) { this.currentLoc = currentLoc; }

    public double getArmorValue() { return armorValue; }

    public ArrayList<Item> getInventory() { return inventory; }

    public boolean isAlive() { return alive; }

    public void setAlive(boolean alive) { this.alive = alive; }




    /**
     * toString
     * @return toString
     */
    public String toString()
    {
        return "Player Name: " + playerName + "\n" + "Health: " + health + "\n" + "Weapon: " + weapon.getItemName() + "\n" + "Armor: " + armor.getItemName() + "\n" + "Wallet: " + "$" + wallet + "\n" + "Location: " + currentLoc.getName() + "\n";
    }



}
