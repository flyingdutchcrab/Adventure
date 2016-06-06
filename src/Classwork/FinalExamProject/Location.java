package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 4/6/16.
 */
import Classwork.FinalExamProject.Monster;

import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;


public class Location
{

    private String Name;
    private String id;
    private String description;
    private boolean locked;
    private Image image;
    private ArrayList<String> exits;
    private ArrayList<String> connectedLocs;
    private ArrayList<Monster> monsters;
    private ArrayList<Item> strayItems;
    //public ArrayList<Location> allLocs;
    private Player p;
    @FXML public TextArea text;
    @FXML public TextArea inputText;


    public Location()
    {
        this.Name = "";
        this.id = "";
        this.description = "";
        this.image = null;
        this.p = new Player();
        this.locked = false;

    }


    public Location (String name, String id, String desc, boolean isLocked, Image img) {
        this.Name = name;
        this.id = id;
        this.description = desc;
        this.locked = isLocked;
        this.image = img;
        exits = new ArrayList<String>();
        connectedLocs = new ArrayList<String>();
        monsters = new ArrayList<Monster>();
        strayItems = new ArrayList<Item>();

    }


    /**
     * Adds an exit to this location
     */
    public void addExit (String newExit, String locID) {

        this.exits.add(newExit);
        this.connectedLocs.add(locID);
    }


    /**
     * Removes exit from location
     * @param exit the exit to be removed
     */
    public void removeExit(String exit) {
        if (this.exits.contains(exit)) {

            this.connectedLocs.remove(exits.indexOf(exit));
            this.exits.remove(exit);
        }
    }


    /**
     * Add a monster to the location
     * @pram the monster
     */
    public void addMonster(Monster monster) { monsters.add(monster); }

    public void addStrayItem(Item item)
    {
        strayItems.add(item);
    }


    /**
     * Getters and setters
     */

    public String getID() { return this.id; }

    public void setName ( String newName ) { this.Name = newName; }

    public String getName() { return this.Name; }

    public void printName() { System.out.printf(this.Name); }

    public Image getImage() { return this.image; }

    public void setDescription( String newDescript ) { this.description = newDescript; }

    public String getDescription() { return this.description; }

    public boolean isLocked() { return locked; }

    public ArrayList<String> getExits () { return this.exits; }

    public String getConnectedLoc(String exit) { return this.connectedLocs.get(exits.indexOf(exit)); }

    public ArrayList<Monster> getMonsters() { return monsters; }

    public ArrayList<Item> getStrayItems()
    {
        return strayItems;
    }

    public void setAllMonsters(ArrayList<Monster> newMonsters) { this.monsters = newMonsters; }

    public String checkLocID() { return p.currentLoc.getID(); }

    public void removeStrayItem(Item item) { strayItems.remove(item); }


} //end class
