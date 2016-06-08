package edu.Andrew.APCS.Adventure;

/**
 * Adventure
 *
 * Adventure
 *
 * The Adventure class, there's a lot of methods here.
 */

import java.util.*;
import java.lang.*;
import edu.Andrew.APCS.Adventure.Utilities.Items.Armor;
import edu.Andrew.APCS.Adventure.Utilities.Items.Item;
import edu.Andrew.APCS.Adventure.Utilities.Items.KeyItem;
import edu.Andrew.APCS.Adventure.Utilities.Items.Weapon;
import edu.Andrew.APCS.Adventure.Utilities.Locations.Location;
import edu.Andrew.APCS.Adventure.Utilities.Locations.Shop;
import edu.Andrew.APCS.Adventure.Utilities.Mobs.Boss;
import edu.Andrew.APCS.Adventure.Utilities.Mobs.Monster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;


public class Adventure
{

    /**
     * Buttons and other things
     */
    @FXML
    private Button north;
    private Button east;
    private Button south;
    private Button west;
    private ToggleButton inventory;
    private Button map;
    private boolean gameWon;
    private Player p;
    private Location location;
    private Shop s;
    private ArrayList<Location> allLocs;
    private boolean invBtnActive = false;


    @FXML
    private TextArea text;
    @FXML
    private TextArea playerInfo;
    @FXML
    private TextField inputText;
    @FXML
    private ImageView imagePane;
    @FXML
    private ImageView mobImagePane;
    @FXML
    private Pane inventoryPane;
    @FXML
    private TextArea invText;
    @FXML
    private TextField invInputText;


    /**
     * Images
     */
    private Image homeImg;
    private Image townImg;
    private Image forestImg;
    private Image grottoImg;
    private Image caveImg;
    private Image altarImg;
    private Image shopImg;
    private Image meadowImg;
    private Image coveImg;
    private Image lakeImg;
    private Image reefImg;
    private Image mountainImg;
    private Image icyPassImg;
    private Image twinPeakImg;
    private Image pathImg;
    private Image graveyardImg;
    private Image catacombsImg;
    private Image treeImg;
    private Image hellImg;
    private Image endImg;
    private Image tundraImg;
    private Image gateImg;
    private Image castleImg;
    private Image swampImg;
    private Image cabinImg;
    private Image gameOverImg;
    private Image skeletonImg;
    private Image skeletonImg2;
    private Image spritieImg;
    private Image lizardImg;
    private Image landSharkImg;
    private Image llamaImg;
    private Image godImg;
    private Image wyvernImg;
    private Image dagonImg;
    private Image ghostGirlImg;
    private Image princeImg;
    private Image alrothiaImg;
    private Image forestSpiritImg;


    public Adventure() {

        this.gameWon = false;
        this.p = new Player();
        this.location = new Location();
        this.s = new Shop();
        this.allLocs = new ArrayList<>();

        this.homeImg = new Image("locations/rsz_bedroom2.jpg");
        this.townImg = new Image("locations/rsz_nighttown.jpg");
        this.pathImg = new Image("locations/forgottenpath.gif");
        this.graveyardImg = new Image("locations/graveyard.gif");
        this.catacombsImg = new Image("locations/catacombs.gif");
        this.treeImg = new Image("locations/hangingtree.gif");
        this.forestImg = new Image("locations/bestforest.gif");
        this.meadowImg = new Image("locations/bettermeadow.gif");
        this.grottoImg = new Image("locations/bettergrotto.png");
        this.lakeImg = new Image("locations/finallake.gif");
        this.coveImg = new Image("locations/covefinal.gif");
        this.reefImg = new Image("locations/reef.jpg");
        this.caveImg = new Image("locations/crystalcave.gif");
        this.altarImg = new Image("locations/chamber.gif");
        this.shopImg = new Image("shop3.gif");
        this.mountainImg = new Image("locations/mountain.gif");
        this.icyPassImg = new Image("locations/icypass.gif");
        this.twinPeakImg = new Image("locations/mountainanim.gif");
        this.hellImg = new Image("locations/hellsurface2.gif");
        this.endImg = new Image("locations/scarybackground.gif");
        this.tundraImg = new Image("locations/rsz_anothertundra.jpg");
        this.gateImg = new Image("locations/castlegate2.gif");
        this.castleImg = new Image("locations/wintercastle.jpg");
        this.swampImg = new Image("locations/8bitswamp.gif");
        this.cabinImg = new Image("locations/cabin.gif");
        this.gameOverImg = new Image("locations/gameover.jpg");


        this.skeletonImg = new Image("monsters/skeletonwarrior.gif");
        this.skeletonImg2 = new Image("monsters/skeletonwarrior2.gif");
        this.spritieImg = new Image("monsters/spritie.gif");
        this.lizardImg = new Image("monsters/lizardman.gif");
        this.landSharkImg = new Image("monsters/landshark.gif");
        this.llamaImg = new Image("monsters/llama.gif");
        this.godImg = new Image("monsters/specimen9.gif");
        this.dagonImg = new Image("monsters/dagon.gif");
        this.ghostGirlImg = new Image("monsters/spookyghost.gif");
        this.wyvernImg = new Image("monsters/rathian.gif");
        this.princeImg = new Image("monsters/fireprince.gif");
        this.alrothiaImg = new Image("monsters/alrothia.gif");
        this.forestSpiritImg = new Image("monsters/forestspirit.gif");


        allLocs = new ArrayList<>();
        initLocs();


    }


    /**
     * Init. Things. This should be only called once.
     */
    public void initialize()
    {
        imagePane.setImage(new Image("yetanotherforest.jpg"));  //need to force this.
        imagePane.setVisible(true);


        inventoryPane.setVisible(false);
        text.appendText("Welcome to the land of euphoria!\n");
        text.appendText("What's your name?\n");

        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event ->
        {
            if (p.getPlayerName().equals("NotSet")) {

                p.setPlayerName(inputText.getText());
                text.appendText("Welcome, " + p.getPlayerName() + "\n");
                playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n" + "Weapon: " + p.getWeapon().getItemName() + "\n");
                this.setNewLoc("START");
                inputText.deleteText(0, inputText.getLength());

            } else {

                inputText.deleteText(0, inputText.getLength());
                text.appendText("\nThere is nothing to input at this time. ");

            }

        });

        //rest to restore health at home
        if (p.currentLoc.getID().equals("START") && p.getHealth() < 100) {

            p.setHealth(100.0);
            text.appendText("You have rested! Your health is now " + p.getHealth() + "\n");
        }


    }


    /**
     * Start the Adventure
     */
    public void startAdventure()
    {
        //welcome user
        text.appendText("Welcome to the land of euphoria!" + "\n");

        //gets users name
        text.appendText("What's your name?" + "\n");
        p.setPlayerName(inputText.getText());
        text.appendText("Really? Welcome, " + p.getPlayerName() + "\n");


        //sets start location
        this.setNewLoc("START");

        while(p.alive) {

            if(p.getCurrentLoc().getMonsters().size() > 0) {

                ArrayList<Monster> monsters = p.getCurrentLoc().getMonsters();
                Monster randomMob = monsters.get(random_int(0, monsters.size()));
                doBattle(randomMob); //does multibattle if there are monsters

                if(p.alive && randomMob.getName().equals("GOD")) {

                    this.win();
                    text.setText("You have beaten the steam sales, you have won life!" + "\n");
                    text.appendText("Play again? (Y/N)" + "\n");
                    String answer = inputText.getText();
                    answer = answer.toUpperCase();
                    if (answer.equals("Y")) //if they want to play again{
                        text.setText("Alright! Let's go!" + "\n");
                        this.reset();
                    } else {
                        text.appendText("Wow. What a skrub, okay bye." + "\n");
                        System.out.close();
                    }

                }

            } //end while


            //rest to restore health at home
            if (p.currentLoc.getID().equals("START") && p.getHealth() < 100) {

                p.setHealth(100.0);
                text.appendText("You have rested! Your health is now " + p.getHealth() + "\n");

            }

    } //end adventure


    /**
     * Takes a monster and simulates a battle until the monster or player dies
     */
    private void doBattle(Monster enemy) {
        System.out.print("doBattle");
        //first time run
        text.appendText("\n" + "A wild Lvl. " + enemy.getLvl() + " " + enemy.getName() + " has appeared!" + "\n" );
        mobImagePane.setImage(enemy.getImage());
        centerMobImage();


        //Prompts user to attack or run
        text.appendText("Attack " + enemy.getName() + "? (Y/N) " + "\n");


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event ->
        {
            String theInputText = inputText.getText();
            inputText.deleteText(0, theInputText.length());


            if (theInputText.equalsIgnoreCase("y") && enemy.isAlive()) //if they want to fight
            {

                //Player turn
                enemy.setHealth(enemy.getHealth() - p.getDamage()); //Sets the monsters health as their current health minus the players damage
                text.appendText("You attack " + enemy.getName() + " for " + p.getDamage() + " damage!" + "\n" + "Enemy health is " + enemy.getHealth() + "\n");

                //Monster turn
                //enemy.setDamage(enemy.getDamage() / p.getArmor().getArmorValue());
                p.setHealth(p.getHealth() - enemy.getDamage()); //Sets the players health as their current health minus the monsters damage
                text.appendText("The " + enemy.getName() + " hit you for " + enemy.getDamage() + " damage!" + "\n" + "Your health is " + p.getHealth() + "\n"); //prints how much damage the monster does to the player
                playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n" + "Weapon: " + p.getWeapon().getItemName() + "\n");

                if (p.getHealth() < 20.0)
                    text.appendText("Your health is low, you should return home and restore health!" + "\n");


                //checks if the player or monster is dead
                p.checkLife(); //calculate if dead
                enemy.checkLife(); //calculate if dead


                //when someone dies
                if (p.alive && !enemy.isAlive()) // if you are still standing
                {
                    //print results (money earned, health remaining)
                    mobImagePane.setImage(null);
                    p.addWallet(enemy.getLoot());
                    playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");
                    text.setText("You shrekt the " + enemy.getName() + "\n" + "You got $" + enemy.getLoot() + " for winning!" + "\n");


                } else if (!p.alive) { //if you died

                    mobImagePane.setImage(null);
                    text.setText("You have been shrekt by the " + enemy.getName());
                    setNewLoc(null);


                } else {
                    text.appendText("Attack again? (Y/N) \n");
                }

            } else if (theInputText.equalsIgnoreCase("n")) { // if they don't want to fight
                    mobImagePane.setImage(null);
                    text.appendText("You fled from the fight!" + "\n");
                    setNewLoc("MEADOW"); // brings you back to town
                    //System.out.print("Will i run?"); //DEBUG

            } else // they don't make any sense
                text.appendText("Unrecognized command" + theInputText + "\n");

        });


    } //end doBattle


    /**
     * Resets adventure to default
     */
    private void reset() {
        this.gameWon = false;
        p.alive = true;
        this.setNewLoc("START");

    }


    /**
     * Generate a random int
     * @param min smalled number expected
     * @param max largest number expected
     * @return a random int
     */
    private static int random_int(int min, int max) { return (int) (Math.random()*(max-min))+min; }


    /**
     * YOU WON!
     */
    private void win() { this.gameWon = true; }


    /**
     * Did you win?
     * @return true if won; false if not yet won
     */
    public boolean won() { return this.gameWon; }


    /**
     * Creates the monster's array. Should only be called when resetting the array of monsters.
     * @return array of monsters
     */
    private ArrayList<Monster> makeMonsterArray()
    {
        //make 3 monsters
        Monster skrub = new Monster("skrub", 20, 10, 1, 10, 25, 5, 25, true, skeletonImg);
        Monster skrublord= new Monster("skrublord", 25, 20, 10, 50, 35, 10, 45, true, skeletonImg2);
        Monster landShark = new Monster("land shark", 20, 15, 8, 35, 20, 20, 60, true, landSharkImg);
        Monster llama = new Monster("llama", 20, 5, 1, 15, 10, 30, 20,  true, llamaImg);
        Monster smurf = new Monster("smurf", 25, 5, 1, 15, 10, 15, 50, true, spritieImg);
        Monster lizardman = new Monster("Lizardman", 25, 15, 8, 35, 20,  15, 100, true, lizardImg);

        //create a Monster array
        ArrayList<Monster> mobCollection = new ArrayList<>();

        //put the monsters in the array
        mobCollection.add(skrub);
        mobCollection.add(skrublord);
        mobCollection.add(landShark);
        mobCollection.add(llama);
        mobCollection.add(smurf);
        mobCollection.add(lizardman);

        //return the array
        return mobCollection;

    }


    /**
     * Multibattle takes in an array of monsters and does battle with each of them if the player is in the forest
     */
    public void multiBattle(ArrayList<Monster> arrayOfMonsters)
    {
        for(Monster mob : arrayOfMonsters)
            this.doBattle(mob);
    }


    /**
     * Get the current LocID
     * @return String of current location ID
     */
    public String checkLocID() { return p.currentLoc.getID(); }


    /**
     * Gets a sinle locaion baised off a location String ID
     * @param ID Location's ID
     * @return the Location
     */
    private Location getSingleLoc(String ID)
    {
        Location singleLoc = null;
        for(Location aLoc : allLocs)
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
     * doShop function to run the shop
     */
    private void doShop()
    {
        if (s.getShopInventory().isEmpty())
            s.initializeShopInventory(); //THIS SHOULD ONLY BE CALLED ONCE!

        text.appendText(s.printShopInventory() + "\n");
        text.appendText("Type the item name to buy a weapon here. Go back west to leave shop." + "\n");


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event -> {
            String answer = inputText.getText();
            inputText.deleteText(0, answer.length());


            boolean item_found = false;
            for (Item i : s.getShopInventory()) {
                if (i.getItemName().equalsIgnoreCase(answer)) {
                    item_found = true;
                    if (p.getWallet() >= i.getCost()) {

                        text.appendText("You bought the " + i.getItemName() + " for " + i.getCost() + "\n");
                        p.inventory.add(i);
                        p.addWallet(-i.getCost());
                        playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");
                        break;

                    } else {
                        text.appendText("You don't have enough money to buy that." + "\n");
                    }
                }
            } //end for


            if (item_found)
                item_found = false;

            else
                text.appendText("Sorry we didn't find that item, try again. ");

        });


    } //end doShop


    /**
     * Sets a new location
     * @param ID new Location
     */
    private void setNewLoc(String ID)
    {

        /**
         * reset all things that need to be, yeah
         */
        mobImagePane.setImage(null); //always remove mob when location chances
        inputText.setOnAction(event -> {
            text.appendText("\nNo input at this time. ");
            inputText.deleteText(0, inputText.getText().length());
        });


        p.currentLoc = this.getSingleLoc(ID);

        if(p.currentLoc == null) {

            text.appendText("\n\nYou have been killed!\n");
            imagePane.setImage(gameOverImg);
            p.alive = false;

        } else if (p.getCurrentLoc().getMonsters().size() > 0) {

            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            ArrayList<Monster> monsters = p.getCurrentLoc().getMonsters();
            Monster randomMob = monsters.get(random_int(0, monsters.size()));
            doBattle(randomMob); //does multibattle if there are monsters

        } else if (p.getCurrentLoc().getStrayItems().size() > 0) {
            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            text.appendText("There is an item here! Pick it up? (Y/N)" + "\n" );
            Item strayItemFound = p.currentLoc.getStrayItems().get(random_int(0, p.currentLoc.getStrayItems().size())); //Item
            inputText.setOnAction(event ->
            {
                String theInputText = inputText.getText();
                inputText.deleteText(0, theInputText.length());
                if (theInputText.equalsIgnoreCase("y"))
                {
                    p.inventory.add(strayItemFound);
                    p.currentLoc.removeStrayItem(strayItemFound);
                    text.appendText("You picked up the " + strayItemFound.getItemName() + "\n");

                }
                else if(theInputText.equalsIgnoreCase("n"))
                {
                    text.appendText("You chose to leave the " + strayItemFound.getItemName() + "\n");
                }
                else
                {
                    text.appendText("Unrecognized command" + "\n");
                }


            });

        } else if (p.currentLoc.getID().equals("START") && p.getHealth() < 100) {

            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            p.setHealth(100.0);
            playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");
            text.appendText("You have rested! Your health is now " + p.getHealth() + "\n");

        } else if(p.currentLoc.getID().equals("STORE")) {

            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            doShop();

        } else {

            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());

        }

    }


    /**
     * Creates all locations for the game and puts them in allLocs. Should only be called once
     */
    private void initLocs()
    {
        Location start = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", false, homeImg);
        start.addExit("N", "TOWN");
        start.addExit("S", "MEADOW");

        Location meadow = new Location("meadow", "MEADOW", "You are in a meadow, there are lots of flowers, it's nice.", false, meadowImg);
        meadow.addExit("N", "START");
        meadow.addExit("E", "LAKE");
        meadow.addExit("S", "CAVE");
        meadow.addExit("W", "FOREST");

        Location forest = new Location("forest", "FOREST", "You are in a spooky forest. Many spooky monsters can be found here. There is a cave to the east", false, forestImg);
        forest.addExit("E", "MEADOW");
        forest.addExit("W", "GROTTO");
        Monster noob = new Monster("Noob", 40, 5, 1, 15, 10,  8, 10, true, null);
        forest.addMonster(noob);
        forest.setAllMonsters(this.makeMonsterArray());

        Location grotto = new Location("grotto", "GROTTO", "You are now in a grotto, the feeling of nature is excellent", true, grottoImg);
        grotto.addExit("E", "FOREST");
        Monster forestSpirit = new Boss("Forest Spirit", 300, 1, 50, 50, 1000, 35, 9000, true, forestSpiritImg, 300, 1000);
        grotto.addMonster(forestSpirit);


        Location town = new Location("town", "TOWN", "You are in a small town. There is a massive menacing mountain over the northern horizon, a store to the west, and a forgotten path to the east.", false, townImg);
        town.addExit("N", "MOUNTAIN");
        town.addExit("E", "PATH");
        town.addExit("S", "START");
        town.addExit("W", "STORE");

        Location cave = new Location("cave", "CAVE", "You are in a crystal cave, a lot of crystals here", false, caveImg);
        cave.addExit("N", "MEADOW");
        cave.addExit("S", "ALTAR");

        Location altar = new Location("altar", "ALTAR", "You are at an altar, there is an ominous feeling in the air here, almost like you really shouldn't be here", true, null);
        altar.addExit("N", "CAVE");

        Location lake = new Location("lake", "LAKE", "You are at a lake, go do some fishin", false, lakeImg);
        lake.addExit("N", "SWAMP");
        lake.addExit("E", "COVE");
        lake.addExit("W", "MEADOW");


        Location cove = new Location("cove", "COVE", "You are in a cove, it's got a cool ancient vibe to it", false, coveImg);
        cove.addExit("E", "REEF");
        cove.addExit("W", "LAKE");

        Location reef = new Location("reef", "REEF", "You are in a reef, there is a lot of ruins down here", true, reefImg);
        reef.addExit("W", "COVE");
        Monster dagon = new Boss("Dagon", 300, 90, 200, 900, 3000, 35, 9000, true, dagonImg, 400, 2000);
        reef.addMonster(dagon);


        Location swamp = new Location("swamp", "SWAMP", "You are in a spooky swamp", false,  swampImg);
        swamp.addExit("N", "PATH");
        swamp.addExit("E", "CABIN");
        swamp.addExit("S", "LAKE");

        Location cabin = new Location("abandoned cabin", "CABIN", "You are in an abandoned cabin, the walls are rotting and the floor is overgrown", false, cabinImg);
        cabin.addExit("W", "SWAMP");
        Item rune = new KeyItem("Eye Rune", 1000, "Reveals secrets, if you are smart enough to find them");
        cabin.addStrayItem(rune);

        Location path = new Location("forgotten path", "PATH", "You are in a forgotten path, few of the living have tread upon it recently", false, pathImg);
        path.addExit("N", "TUNDRA");
        path.addExit("E", "GRAVEYARD");
        path.addExit("S", "SWAMP");
        path.addExit("W", "TOWN");

        Location graveyard = new Location("graveyard", "GRAVEYARD", "You are in a graveyard, where the dead come to life, and the living come to die", false, graveyardImg);
        graveyard.addExit("N", "CATACOMBS");
        graveyard.addExit("E", "TREE");
        graveyard.addExit("W", "PATH");

        Location tree = new Location("hanging tree", "TREE", "You are at a hanging tree, creepy whispers can be heard all around you", true, treeImg, "Grave Key");
        tree.addExit("W", "GRAVEYARD");
        Monster ghostGirl = new Boss("Vengeful Spirit", 300, 0, 100, 100, 2000, 35, 9000, true, ghostGirlImg, 250, 1500);
        tree.addMonster(ghostGirl);

        Location catacombs = new Location("catacombs", "CATACOMBS", "You are in the catacombs, there are bones literally everywhere", true, catacombsImg);
        catacombs.addExit("S", "GRAVEYARD");

        Location tundra = new Location("tundra", "TUNDRA", "You are in a freezing tundra, not much is happening here...", false, tundraImg);
        tundra.addExit("S", "PATH");
        tundra.addExit("W", "MOUNTAIN");

        Location mountain = new Location("mountain", "MOUNTAIN", "You are at a mountain, there's a great view up here", false, mountainImg);
        mountain.addExit("N", "GATE");
        mountain.addExit("E", "TUNDRA");
        mountain.addExit("S", "TOWN");
        mountain.addExit("W", "PASS");

        Location store = new Location("store", "STORE", "You are in a store. A wide variety of weapons and items can be bought here", false, shopImg);
        store.addExit("E", "TOWN");

        Location pass = new Location("icy pass", "PASS", "You are in an icy pass, it's very high up, and there's not much visibility", false, icyPassImg);
        pass.addExit("E", "MOUNTAIN");
        pass.addExit("W", "TWINPEAK");

        Location twinpeak = new Location("twin peak", "TWINPEAK", "You are at the Twin Peak, a dragon can be found here", true, twinPeakImg);
        twinpeak.addExit("E", "PASS");
        Monster wyvern = new Boss("Wyvern", 400, 1, 75, 90, 1000, 45, 2000, true, wyvernImg, 500, 5000);
        twinpeak.addMonster(wyvern);


        Location gate = new Location("castle gate", "GATE", "You are at the castle gate, you have to do a lot of stuff till you can open it", false, gateImg);
        gate.addExit("N", "CASTLE");
        gate.addExit("S", "MOUNTAIN");


        Location castle = new Location("castle", "CASTLE", "You are the castle, you will face some very challenging foes here", true, castleImg);
        castle.addExit("N", "HALL");
        castle.addExit("E", "BARRACKS");
        castle.addExit("S", "GATE");
        castle.addExit("W", "ARMORY");



        Location barracks = new Location("barracks", "BARRACKS", "You are at the barracks, a lot of faithful servants to the land were properly here", false, null);
        barracks.addExit("W", "CASTLE");

        Location armory = new Location("armory", "ARMORY", "You are at the armory, I'm sure you could find something useful here", false, null);
        armory.addExit("E", "CASTLE");

        Location hall = new Location("Hall of Chosen", "HALL", "You are at the Hall of the Chosen, nearly every direction here will challenge your destiny", false, null);
        hall.addExit("N", "SANCTUM");
        hall.addExit("E", "EASTTOWER");
        hall.addExit("S", "CASTLE");
        hall.addExit("W", "WESTTOWER");

        Location etower = new Location("east tower", "EASTTOWER", "You are at the East Tower, prepare for a fight", false, null);
        etower.addExit("W", "HALL");
        Monster alrothia = new Boss("Alrothia", 400, 150, 300, 400, 1000, 45, 2000, true, alrothiaImg, 450, 6000);
        etower.addMonster(alrothia);

        Location wtower = new Location("west tower", "WESTTOWER", "You are at the West Tower, prepare for a fight", false, null);
        wtower.addExit("E", "HALL");

        Location sanctum = new Location("Inner Sanctum", "SANCTUM", "You are in the Inner Sanctum, home of the prince", true, null);
        sanctum.addExit("N", "THRONE");
        sanctum.addExit("S", "HALL");
        Monster prince = new Boss("Prince Jerry", 400, 1, 75, 800, 1500, 45, 2000, true, princeImg, 500, 8000);
        sanctum.addMonster(prince);

        Location throne = new Location("Throne", "THRONE", "You are at the throne, where you will face your destiny and fight the king", true, null);
        throne.addExit("N", "CHAMBER");
        throne.addExit("S", "SANCTUM");

        Location chamber = new Location("king's chamber", "CHAMBER", "You are at the king's chamber, there's a weird feeling coming from an object in this room", true, null);
        chamber.addExit("S", "THRONE");


        Location hell = new Location("hell", "HELL", "Welcome to hell, you must have screwed something up to end here", false, hellImg);


        Location end = new Location("end", "END", "awkfnawlfnalwkfnalkwf", true, endImg);
        Monster god = new Boss("GOD", 300, 9998, 9999, 4999, 5000, 35, 9000, true, godImg, 1000, 100000000);
        end.addMonster(god);


        //add Locations to allLocs
        this.allLocs.add(start);
        this.allLocs.add(meadow);
        this.allLocs.add(grotto);
        this.allLocs.add(lake);
        this.allLocs.add(altar);
        this.allLocs.add(path);
        this.allLocs.add(cove);
        this.allLocs.add(reef);
        this.allLocs.add(graveyard);
        this.allLocs.add(tree);
        this.allLocs.add(catacombs);
        this.allLocs.add(cabin);
        this.allLocs.add(pass);
        this.allLocs.add(twinpeak);
        this.allLocs.add(gate);
        this.allLocs.add(castle);
        this.allLocs.add(barracks);
        this.allLocs.add(armory);
        this.allLocs.add(hall);
        this.allLocs.add(etower);
        this.allLocs.add(wtower);
        this.allLocs.add(sanctum);
        this.allLocs.add(throne);
        this.allLocs.add(chamber);
        this.allLocs.add(town);
        this.allLocs.add(forest);
        this.allLocs.add(cave);
        this.allLocs.add(tundra);
        this.allLocs.add(swamp);
        this.allLocs.add(store);
        this.allLocs.add(mountain);
        this.allLocs.add(hell);
        this.allLocs.add(end);

    }


    /**
     * Makes a move based on user input
     */
    private void makeMove(String move) {

        String moveName;

        switch (move) {
            case "N":
                moveName = "North";
                break;
            case "S":
                moveName = "South";
                break;
            case "E":
                moveName = "East";
                break;
            case "W":
                moveName = "West";
                break;
            default:
                moveName = "move not found";
                break;
        }


        if (p.currentLoc.getExits().contains(move)) { //valid move
            for (int i = 0; i < allLocs.size(); i++)
                if (allLocs.get(i).getID().equalsIgnoreCase(p.currentLoc.getConnectedLoc(move))) //find move Location
                    if (!allLocs.get(i).isLocked()) { //is Location locked?
                        this.setNewLoc(p.currentLoc.getConnectedLoc(move)); //there is no problem, move to location
                        break;
                    } else { //location is locked
                        boolean found = false;
                        for (int j = 0; j < p.inventory.size(); j++) { //check for key
                            if (p.inventory.get(j).getItemName().equalsIgnoreCase(allLocs.get(i).getKeyItemUnlock())) { //had Key?
                                System.out.println("found"); //DEBUG
                                p.inventory.remove(p.inventory.get(j)); //remove the key item
                                allLocs.get(i).unlock(); //unlock the location.
                                text.appendText("\nThey key item to unlock this area has been removed. You have unlocked this location. \n");
                                found = true;
                                this.setNewLoc(p.currentLoc.getConnectedLoc(move)); //user has key to unlock area.
                                break;
                            }
                        }


                        if (!found) //valid move but does not have key.
                            text.appendText("\nThat direction, " + moveName + ", is locked. Try again when you have the key. \n");

                    }
        } else //not valid move (nothing is there in that direction
            text.appendText("\n" + "Cannot go in that direction. \n");

    }


    /**
     * Center Mob Image Function
     */
    private void centerMobImage() {

        Image img = mobImagePane.getImage();
        if (img != null) {
            double width;
            double height;

            double ratioX = mobImagePane.getFitWidth() / img.getWidth();
            double ratioY = mobImagePane.getFitHeight() / img.getHeight();

            double reducCoeff;
            if(ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            width = img.getWidth() * reducCoeff;
            height = img.getHeight() * reducCoeff;

            mobImagePane.setX((mobImagePane.getFitWidth() - width) / 2);
            mobImagePane.setY((mobImagePane.getFitHeight() - height) / 2);

        }

    }


    /**
     * Get array AllLocs
     * @return AllLocs
     */
    public ArrayList<Location> getAllLocs() {
        return allLocs;
    }

    /**
     * @FXML
     * Buttons
     */

    @FXML protected void handleNorthButtonPressed(ActionEvent event)
    {
        this.makeMove("N");
    }

    @FXML protected void handleEastButtonPressed(ActionEvent event)
    {
        this.makeMove("E");
    }

    @FXML protected void handleSouthButtonPressed(ActionEvent event)
    {
        this.makeMove("S");
    }

    @FXML protected void handleWestButtonPressed(ActionEvent event)
    {
        this.makeMove("W");
    }

    @FXML protected void handleInvButtonPressed(ActionEvent event)
    {

        if (invBtnActive) {
            invBtnActive = false;
            inventoryPane.setVisible(invBtnActive);

        } else {

            invBtnActive = true;

            inventoryPane.setVisible(invBtnActive);
            invText.setText(p.printInventory());

            invInputText.setOnAction(event2 ->
            {
                String choice = invInputText.getText();
                for (int i = 0; i < p.inventory.size(); i++) {
                    if (choice.equalsIgnoreCase(p.inventory.get(i).getItemName())) {
                        if (p.inventory.get(i) instanceof Weapon) {
                            invInputText.deleteText(0, invInputText.getLength());
                            p.equipWeapon(p.inventory.get(i));
                            inputText.deleteText(0, inputText.getLength());
                            playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n" + "Weapon: " + p.getWeapon().getItemName() + "\n");
                        } else if (p.inventory.get(i) instanceof Armor) {
                            invInputText.deleteText(0, invInputText.getLength());
                            p.equipArmor(p.inventory.get(i));
                        }
                        else if (p.inventory.get(i) instanceof KeyItem && p.inventory.get(i).getItemName().equalsIgnoreCase("Eye Rune"))
                        {
                            invInputText.deleteText(0, invInputText.getLength());
                            invText.appendText("\nYour insight level: " + p.getInsight() + "\n");
                        }
                    } else {
                        invInputText.deleteText(0, invInputText.getLength());
                        invText.appendText("\nItem not recognized" + "\n");
                    }
                }



            });

        }

    }

}
