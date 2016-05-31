package Classwork.FinalExamProject;

import java.util.*;
import javax.swing.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;

/**
 * Created by andrewbrook on 5/11/16.
 */
public class Player
{
    public double health;
    public double damage;
    public String playerName;
    private String jobSkill;
    public Item weapon; //Expecting an Weapon here
    public Item armor; //expecting a Armor here
    public double wallet;
    public boolean alive;
    public Location currentLoc;
    public ArrayList<Item> inventory;
    private Scanner scan;
    @FXML public TextArea text;
    @FXML public TextArea inputText;



    public Player()
    {
        this.health = 150.0; //sets players default health to 100
        this.playerName = "NotSet"; //sets players default name as not set
        this.damage = 10.0; //sets players default damage as 10
        this.wallet = 100.0; //sets players default wallet as $0
        this.jobSkill = "NotSet"; //sets players default skill as not set
        Weapon stick = new Weapon("wooden stick", 25.0, 10.0); //sets players default weapon as no weapon
        this.weapon = stick;
        Armor shirt = new Armor ("T-Shirt", 10, 2);
        this.armor = shirt;
        this.alive = true; //sets players default status to alive
        this.inventory = new ArrayList<Item>();
        inventory.add(stick);
        inventory.add(shirt);
        Location start = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", false, null);
        this.scan = new Scanner(System.in);
        this.currentLoc = start;
    } //end default constructor

    public void setPlayerName(String name)
    {
        this.playerName = name;
    }

    public String getPlayerName()
    {
        return playerName;
    }


    public double getHealth() //gets health
    {
        return this.health;
    } //end getHealth

    public void setHealth(double newhealth) //sets health
    {
        this.health = newhealth;
    } //end setHealth

    public double getDamage() //gets damage
    {
        return this.damage;
    } //end getDamage

    public double getWallet()
    {
        return this.wallet;
    }

    public Item getWeapon()
    {
        return this.weapon;
    } //end getWeapon

    public Item getArmor()
    {
        return this.armor;
    }

    public String printInventory()
    {
        String itemList = "These are the items in your inventory:\n";
        for(Item i : inventory)
        {
            itemList += i.toString();
        }
        return itemList;

    } //end printInventory

    public Location getCurrentLoc()
    {
        return this.currentLoc;
    } //end getCurrentLoc

    public String toString()
    {
        return "Player Name: " + playerName + "\n" + "Health: " + health + "\n" + "Weapon: " + weapon.getItemName() + "\n" + "Armor: " + armor.getItemName() + "\n" + "Wallet: " + "$" + wallet + "\n" + "Location: " + currentLoc.getName() + "\n";
    } //end toString


    public Location getSingleLoc(String ID)
    {
        Adventure adv = new Adventure();
        Location l = new Location();
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
    } //end getSingleLoc

    public void checkLife()
    {

        //System.out.println("Checking Life");
        if (this.health <= 0)
        {
            if (this.health < 0 )
            {
                this.health = 0.0;
                this.alive = false;
            }
            else
            {
                this.alive = false;
            }
        }
    } //end checkLife

    public boolean hasKeyItem(String keyItemName)
    {
        boolean found = false;
        for (int i = 0; i < this.inventory.size(); i++)
        {
            if (this.inventory.get(i).getItemName().equals(keyItemName))
            {
                found = true;
            }
        }

        return found;
    } //end hasKeyItem

    public void equipWeapon(Item w)
    {
        this.weapon = w;
    }

    public void equipArmor(Item a)
    {
        this.armor = a;
    }
/*
    public void setNewLoc(String ID)
    {
        this.currentLoc = this.getSingleLoc(ID);
        if(this.currentLoc == null)
        {
            text.appendText("You have been killed!" + "\n");
            this.alive = false;

        }
        else
        {
            text.setText("You are now in " + this.currentLoc.getName() + "\n" + this.currentLoc.getDescription() + "\n");
        }
    } //end setNewLoc



    public void makeMove(String move)
    {
        Location l = new Location();
        Adventure adv = new Adventure();
        ArrayList<String> locExits = this.currentLoc.getExits();
        if (locExits.contains(move))
        {
            this.setNewLoc(this.currentLoc.getConnectedLoc(move));
        }

        else
        {
            text.appendText("You have been destroyed by the world!" + "\nGAME OVER" + "\n");
            this.alive = false;
            text.appendText("\nPlay again? (Y/N)" + "\n");
            String answer = inputText.getText();
            answer = answer.toUpperCase();
            if (answer.equals("Y")) //if they want to play again
            {
                text.appendText("Alright! Let's go!" + "\n");
                adv.reset();
            }
            else //if they want to quit
            {
                text.appendText("Wow. What a skrub, okay bye." + "\n");
                System.out.close();
            }
        }
    } //end makeMove
    */
} //end class
