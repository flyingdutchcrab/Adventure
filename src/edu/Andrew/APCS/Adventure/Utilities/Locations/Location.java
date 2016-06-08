package edu.Andrew.APCS.Adventure.Utilities.Locations;

/**
 * Adventure
 *
 * Location
 *
 * This is a location, stores data for that location.
 */

import java.util.*;

import edu.Andrew.APCS.Adventure.Player;
import edu.Andrew.APCS.Adventure.Utilities.Items.Item;
import edu.Andrew.APCS.Adventure.Utilities.Mobs.Monster;
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
    private String keyItemUnlock;
    private Player p;


    public Location()
    {
        this.Name = "";
        this.id = "";
        this.description = "";
        this.image = null;
        this.p = new Player();
        this.locked = false;
        this.keyItemUnlock = "";

    }

    public Location (String name, String id, String desc, boolean isLocked, Image img) {
        this.Name = name;
        this.id = id;
        this.description = desc;
        this.locked = isLocked;
        this.image = img;
        exits = new ArrayList<>();
        connectedLocs = new ArrayList<>();
        monsters = new ArrayList<>();
        strayItems = new ArrayList<>();
        this.keyItemUnlock = "";

        if (isLocked && keyItemUnlock.isEmpty())
            System.out.println("WARNING: NO UNLOCK ITEM SET IN " + name + ", " + id);


    }

    public Location (String name, String id, String desc, boolean isLocked, Image img, String keyItemUnlock) {
        this.Name = name;
        this.id = id;
        this.description = desc;
        this.locked = isLocked;
        this.image = img;
        exits = new ArrayList<>();
        connectedLocs = new ArrayList<>();
        monsters = new ArrayList<>();
        strayItems = new ArrayList<>();
        this.keyItemUnlock = keyItemUnlock;


        if (isLocked && keyItemUnlock.isEmpty())
            System.out.println("WARNING: NO UNLOCK ITEM SET");


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
     * @param monster the monster to be added
     */
    public void addMonster(Monster monster) { monsters.add(monster); }


    /**
     * Add a stray item to the location
     * @param item the location to be added
     */
    public void addStrayItem(Item item) { strayItems.add(item); }


    /**
     * Lock/Unlock functions
     */

    public void unlock() {
        locked = false;
    }

    public void lock() {
        locked = true;
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

    public ArrayList<Item> getStrayItems() { return strayItems; }

    public void setAllMonsters(ArrayList<Monster> newMonsters) { this.monsters = newMonsters; }

    public String checkLocID() { return p.currentLoc.getID(); }

    public void removeStrayItem(Item item) { strayItems.remove(item); }

    public String getKeyItemUnlock() { return keyItemUnlock; }

    public ArrayList<String> getConnectedLocs() { return connectedLocs; }

    public boolean isKeyItem(String key) { return keyItemUnlock.equalsIgnoreCase(key); }

} //end class
