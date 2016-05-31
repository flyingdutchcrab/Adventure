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
    //declare variables
    private String Name;
    private String id;
    private String description;
    private boolean locked;
    public Image image;
    public ArrayList<String> exits;
    public ArrayList<String> connectedLocs;
    public ArrayList<Monster> monsters;
    //public ArrayList<Location> allLocs;
    public Player p;
    @FXML public TextArea text;
    @FXML public TextArea inputText;
    /*
    public Image homeImg;
    public Image townImg;
    public Image forestImg;
    public Image caveImg;
    public Image shopImg;
    public Image mountainImg;
    */



    //constructor
    public Location()
    {
        this.Name = "";
        this.id = "";
        this.description = "";
        this.image = null;
        //this.allLocs = new ArrayList<Location>();
        this.p = new Player();
        this.locked = false;
        /*
        this.homeImg = new Image("childbedroom.jpg");
        this.townImg = new Image("town.jpg");
        this.forestImg = new Image("forest.jpg");
        this.caveImg = new Image("cave.jpg");
        this.shopImg = new Image("shop.jpg");
        this.mountainImg = new Image("mountain.jpg");
        */

    }
    public Location (String n, String id, String d, boolean lckd, Image img)
    {
        this.Name = n;
        this.id = id;
        this.description = d;
        this.locked = lckd;
        this.image = img;
        exits = new ArrayList<String>();
        connectedLocs = new ArrayList<String>();
        monsters = new ArrayList<Monster>();
    } //end Location constructor

    public String getID()
    {
        return this.id;
    }

    //setters and getters

    //Set and get and print for name
    public void setName ( String newName )
    {
        this.Name = newName;
    } //end setName

    public String getName()
    {
        return this.Name;
    } //end getName

    public void printName()
    {
        System.out.printf(this.Name);
    } //end printName

    public Image getImage()
    {
        return this.image;
    } //end getImage



    //Set and get for description
    public void setDescription( String newDescript )
    {
        this.description = newDescript;
    } //end setDescription

    public String getDescription()
    {
        return this.description;
    } //end getDescription

    public boolean isLocked()
    {
        return locked;
    }

    // Adds an exit to this location
    public void addExit (String newExit, String locID)
    {
        //add something here
        this.exits.add(newExit);
        this.connectedLocs.add(locID);
    } //end addExit

    public void removeExit(String exit)
    {
        if (this.exits.contains(exit))
        {
            this.connectedLocs.remove(exits.indexOf(exit));
            this.exits.remove(exit);
        }
    } //end removeExit

    //Returns an ArrayList of exits
    public ArrayList<String> getExits ()
    {
        return this.exits;
    } //end getExits

    public String getConnectedLoc(String exit)
    {
        return this.connectedLocs.get(exits.indexOf(exit));
    } //end getConnectedLoc

    //gets Monster array list
    public ArrayList<Monster> getMonsters()
    {
        return monsters;
    } //end getMonsters

    //adds a monster to a location
    public void addMonster(Monster monster)
    {
        monsters.add(monster);
    } //end addMonster

    public void setAllMonsters(ArrayList<Monster> newMonsters)
    {
        this.monsters = newMonsters;
    } //end setAllMonsters

    /*public ArrayList<Monster> makeMonsterArray()
    {
        //make 3 monsters
        Monster mob1 = new Monster("skrub", 20, 5, 25, true);
        Monster mob2= new Monster("skrublord", 25, 10, 45, true);
        Monster mob3 = new Monster("land shark", 20, 20, 60, true);
        Monster mob4 = new Monster("mingebag", 15, 5, 20, true);
        Monster mob5 = new Monster("troll", 20, 15, 30, true);
        Monster mob6 = new Monster("smurf", 25, 15, 50, true);
        Monster mob7 = new Monster("Lizardman", 25, 15, 100, true);

        //create a Monster array
        ArrayList<Monster> mobCollection = new ArrayList<Monster>();

        //put the monsters in the array
        mobCollection.add(mob1);
        mobCollection.add(mob2);
        mobCollection.add(mob3);
        mobCollection.add(mob4);
        mobCollection.add(mob5);
        mobCollection.add(mob6);
        mobCollection.add(mob7);

        //return the array
        return mobCollection;

    } //end makeMonsterArray
    */
/*
    public void initLocs()
    {
        Location start = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", null);
        start.addExit("N", "TOWN");

        Location town = new Location("town", "TOWN", "You are in a small town. There is a massive menacing mountain over the northern horizon, a store to the west, and a spooky forest to the east.", null);
        town.addExit("N", "MOUNTAIN");
        town.addExit("E", "FOREST");
        town.addExit("S", "START");
        town.addExit("W", "STORE");

        Location forest = new Location("forest", "FOREST", "You are in a spooky forest. Many spooky monsters can be found here. There is a cave to the east", null);
        forest.addExit("W", "TOWN");
        forest.addExit("E", "CAVE");
        Monster noob = new Monster("Noob", 40, 8, 10, true);
        forest.addMonster(noob);
        forest.setAllMonsters(this.makeMonsterArray());

        Location cave = new Location("cave", "CAVE", "You are in a spooky cave", null);
        cave.addExit("W", "FOREST");

        Location store = new Location("store", "STORE", "You are in a store. A wide variety of weapons and items can be bought here", null);
        store.addExit("E", "TOWN");

        Location mountain = new Location("mountain", "MOUNTAIN", "You are at Mount Valve, where all wallets are stored, guarded by our omnipotent Lord Gaben. You can choose to fight him or wait until you are ready", null);
        mountain.addExit("S", "TOWN");
        Monster gabe = new Monster("Lord Gaben", 300, 35, 9000, true);
        mountain.addMonster(gabe);

        //add Locations to allLocs
        this.allLocs.add(start);
        this.allLocs.add(town);
        this.allLocs.add(forest);
        this.allLocs.add(cave);
        this.allLocs.add(store);
        this.allLocs.add(mountain);
    } //end initLocs
*/
    public String checkLocID()
    {
        return p.currentLoc.getID();
    } //end checkLocID



} //end class
