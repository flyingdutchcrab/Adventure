package edu.Andrew.APCS.Adventure;

import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Adventure
 *
 * Player
 *
 * The Player him/her slef!
 */
public class Player
{

    private double health;
    private double damage;
    private int level;
    private int insight;
    private int xp;
    private String playerName;
    private String jobSkill;
    private Item weapon; //Expecting an Weapon here
    private Item armor; //expecting a Armor here
    private double wallet;
    public boolean alive;
    public Location currentLoc;
    public ArrayList<Item> inventory;
    private Scanner scan;
    @FXML public TextArea text;
    @FXML public TextArea inputText;


    public Player() {
        this.health = 150.0; //sets players default health to 100
        this.playerName = "NotSet"; //sets players default name as not set
        this.damage = 10.0; //sets players default damage as 10
        this.level = 1;
        this.xp = 0;
        this.insight = 1;
        this.wallet = 100.0; //sets players default wallet as $0
        this.jobSkill = "NotSet"; //sets players default skill as not set
        Weapon stick = new Weapon("wooden stick", 25.0, 10.0); //sets players default weapon as no weapon
        this.weapon = stick;
        Armor shirt = new Armor("T-Shirt", 10, 2);
        this.armor = shirt;
        this.alive = true; //sets players default status to alive
        this.inventory = new ArrayList<>();
        inventory.add(stick);
        inventory.add(shirt);
        Location start = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", false, null);
        this.scan = new Scanner(System.in);
        this.currentLoc = start;

    }


    /**
     * Print the player's inventory
     * @return String with the inventory
     */
    public String printInventory()
    {
        String itemList = "These are the items in your inventory:\n";

        for(Item i : inventory)
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

        for(Location aLoc : adv.allLocs)
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

        for (int i = 0; i < this.inventory.size(); i++)
            if (this.inventory.get(i).getItemName().equalsIgnoreCase(item))
                return true;

        return false;

    }


    /**
     * Equips an item from the player's inventory
     * @param w the wepon to equip
     */
    public void equipWeapon(Item w) { this.weapon = w; }

    public void equipArmor(Item a) { this.armor = a; }


    /**
     * Setters and getters
     */
    public void setPlayerName(String name) { this.playerName = name; }

    public String getPlayerName() { return playerName; }

    public double getHealth() { return this.health; }

    public void setHealth(double newhealth) { this.health = newhealth; }

    public int getLevel()
    {
        return this.level;
    }

    public int getXp()
    {
        return this.xp;
    }

    public int getInsight()
    {
        return this.insight;
    }

    public double getDamage() { return this.damage; }

    public double getWallet() { return this.wallet; }

    public void addWallet(double amount) { wallet += amount;}

    public Item getWeapon() { return this.weapon; }

    public Item getArmor() { return this.armor; }

    public Location getCurrentLoc() { return this.currentLoc; }


    /**
     * toString
     * @return toString
     */
    public String toString()
    {
        return "Player Name: " + playerName + "\n" + "Health: " + health + "\n" + "Weapon: " + weapon.getItemName() + "\n" + "Armor: " + armor.getItemName() + "\n" + "Wallet: " + "$" + wallet + "\n" + "Location: " + currentLoc.getName() + "\n";
    } //end toString





} //end class
