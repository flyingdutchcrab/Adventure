package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 4/6/16.
 */

import java.util.*;
import java.lang.*;


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
    //declare variables
    /*private double health;
    private double damage;
    private String playerName;
    private String jobSkill;
    private String weapon;
    private double wallet;

    private boolean alive;
    private Location currentLoc;
    private ArrayList<Location> allLocs;
    */
    @FXML
    private Button north;
    private Button east;
    private Button south;
    private Button west;
    //private Button yes;
    //private Button no;

    private ToggleButton inventory;
    private Button map;

    private boolean gameWon;
    private Scanner scan;
    private String choice;
    private boolean fled;
    private Player p;
    private Location l;
    private Shop s;
    public ArrayList<Location> allLocs;

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



    private Image homeImg;
    private Image townImg;
    private Image forestImg;
    private Image caveImg;
    private Image shopImg;
    private Image mountainImg;
    private Image hellImg;
    private Image endImg;
    private Image tundraImg;
    private Image swampImg;
    private Image gameOverImg;
    private Image skeletonImg;
    private Image skeletonImg2;
    private Image spritieImg;
    private Image lizardImg;
    private Image landSharkImg;
    private Image llamaImg;
    private Image mingeImg;
    private Image godImg;


    //default constructor
    public Adventure() {
        /*
        this.health = 150.0; //sets players default health to 100
        this.playerName = "NotSet"; //sets players default name as not set
        this.damage = 10.0; //sets players default damage as 10
        this.wallet = 100.0; //sets players default wallet as $0
        this.jobSkill = "NotSet"; //sets players default skill as not set
        this.weapon = "wooden stick"; //sets players default weapon as no weapon
        this.alive = true; //sets players default status to alive
        */

        this.scan = new Scanner(System.in); //enables system to scan for players response
        this.gameWon = false;
        this.p = new Player();
        this.l = new Location();
        this.s = new Shop();
        this.allLocs = new ArrayList<Location>();
        this.choice = "";
        this.fled = false;

        this.homeImg = new Image("locations/rsz_bedroom2.jpg");
        this.townImg = new Image("locations/rsz_nighttown.jpg");
        this.forestImg = new Image("locations/betterforest.gif");
        this.caveImg = new Image("locations/bettercave.jpg");
        this.shopImg = new Image("locations/shopanim3.gif");
        this.mountainImg = new Image("locations/mountainanim.gif");
        this.hellImg = new Image("locations/hellsurface2.gif");
        this.endImg = new Image("locations/scarybackground.gif");
        this.tundraImg = new Image("locations/rsz_anothertundra.jpg");
        this.swampImg = new Image("locations/8bitswamp.gif");
        this.gameOverImg = new Image("locations/gameover.jpg");

        this.skeletonImg = new Image("monsters/skeletonwarrior.gif");
        this.skeletonImg2 = new Image("monsters/skeletonwarrior2.gif");
        this.spritieImg = new Image("monsters/spritie.gif");
        this.lizardImg = new Image("monsters/lizardman.gif");
        this.landSharkImg = new Image("monsters/landshark.gif");
        this.llamaImg = new Image("monsters/llama.gif");
        this.mingeImg = new Image("monsters/minge.gif");
        this.godImg = new Image("monsters/specimen9.gif");


        allLocs = new ArrayList<Location>();
        initLocs();


    }


    public void initialize()
    {
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


        /*if (p.getCurrentLoc().getMonsters().size() > 0)
        {
            ArrayList<Monster> monsters = p.getCurrentLoc().getMonsters();
            Monster randomMob = monsters.get(random_int(0, monsters.size()));

            doBattle(randomMob); //does multibattle if there are monsters
        }
        */



        //rest to restore health at home
        if (p.currentLoc.getID().equals("START") && p.getHealth() < 100) {

            p.setHealth(100.0);
            text.appendText("You have rested! Your health is now " + p.getHealth() + "\n");
        }


    } //end initialize



    //methods
    //starts a new method by setting the playerName
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

        while(p.alive)
        {
            if(p.getCurrentLoc().getMonsters().size() > 0)
            {
                ArrayList<Monster> monsters = p.getCurrentLoc().getMonsters();
                Monster randomMob = monsters.get(random_int(0, monsters.size()));

                doBattle(randomMob); //does multibattle if there are monsters
                if(p.alive && randomMob.getName().equals("GOD"))
                {
                    this.win();
                    text.setText("You have beaten the steam sales, you have won life!" + "\n");
                    text.appendText("Play again? (Y/N)" + "\n");
                    String answer = inputText.getText();
                    answer = answer.toUpperCase();
                    if (answer.equals("Y")) //if they want to play again
                    {
                        text.setText("Alright! Let's go!" + "\n");
                        this.reset();
                    }
                    else //if they want to quit
                    {
                        text.appendText("Wow. What a skrub, okay bye." + "\n");
                        System.out.close();
                    }

                }

            }

            //move system
            /*
            System.out.println("Which way do you want to go? (N, E, S, W)");
            String move = scan.nextLine();
            p.makeMove(move);
            */

            //monster
            //Monster dragon = new Monster("Adolescent Dragon", 45, 7, true); //sets the name, health, damage, and life status
            //this.doBattle(dragon); //initiates battle with dragon

            //makes a monsterArray and has player fight the monsters in the array

            //Monster[] mobMonsters = this.makeMonsterArray();
            //this.multiBattle(mobMonsters);

            //rest to restore health at home
            if (p.currentLoc.getID().equals("START") && p.getHealth() < 100)
            {
                p.setHealth(100.0);
                text.appendText("You have rested! Your health is now " + p.getHealth() + "\n");
            }
            /*
            if (p.currentLoc.getID().equals("STORE"))
            {
               this.doShop();
            }
            */


        }

    }


    //takes a monster and simulates a battle until the monster or player dies
    private void doBattle(Monster enemy)
    {
        //first time run
        text.appendText("\n" + "A wild " + enemy.getName() + " has appeared!" + "\n" );
        mobImagePane.setImage(enemy.getImage());
        centerMobImage();


        /*
        if (enemy.getName().equals("GOD"))
        {
            this.laugh = new AudioClip(this.getClass().getResource("laugh.mp3").toExternalForm());
            laugh.play();
        }
        */


        //System.out.println("Player Health: " + p.alive + " Enemy health: " +  enemy.isAlive() );
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
                text.appendText("Unrecognized command" + "\n");

        });


    } //end doBattle


    //Resets adventure to default
    private void reset()
    {
        this.gameWon = false;
        p.alive = true;
        this.setNewLoc("START");
    }



    //setters and getters
    /*public double getHealth() //gets health
    {
        return this.health;
    }

    public void setHealth(double newhealth) //sets health
    {
        this.health = newhealth;
    }

    public double getDamage() //gets damage
    {
        return this.damage;
    }
    */

    //check if player/monster is alive
    /*
    public void checkLife()
    {
        if (p.health <= 0)
        {
            if (p.health < 0 )
            {
                p.health = 0.0;
                p.alive = false;
            }
            else
            {
                p.alive = false;
            }
        }
    }
    */

    public static int random_int(int Min, int Max)
    {
        return (int) (Math.random()*(Max-Min))+Min;
    }


    //set and get gameWon
    public void win()
    {
        this.gameWon = true;
    }


    public boolean won()
    {
        return this.gameWon;
    }


    public ArrayList<Monster> makeMonsterArray()
    {
        //make 3 monsters
        Monster mob1 = new Monster("skrub", 20, 5, 25, true, skeletonImg);
        Monster mob2= new Monster("skrublord", 25, 10, 45, true, skeletonImg2);
        Monster mob3 = new Monster("land shark", 20, 20, 60, true, landSharkImg);
        Monster mob4 = new Monster("mingebag", 15, 5, 20, true, mingeImg);
        Monster mob5 = new Monster("llama", 20, 15, 30, true, llamaImg);
        Monster mob6 = new Monster("smurf", 25, 15, 50, true, spritieImg);
        Monster mob7 = new Monster("Lizardman", 25, 15, 100, true, lizardImg);

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


    //multibattle takes in an array of monsters and does battle with each of them if the player is in the forest
    public void multiBattle(ArrayList<Monster> allMobs)
    {
        for(Monster aMob : allMobs)
        {
            this.doBattle(aMob);
        }

    }


    //set/get currentLoc
    public String checkLocID()
    {
        return p.currentLoc.getID();
    }


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

/*
    public Location getCurrentLoc()
    {
        return this.currentLoc;
    }
*/


    private void doShop()
    {
        s.initializeShopInventory();

        text.appendText(s.printShopInventory() + "\n");
        text.appendText("Type the item name to buy a weapon here. Go back west to leave shop." + "\n");


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event -> {
            String answer = inputText.getText();
            inputText.deleteText(0, answer.length());


            boolean item_found = false;
            for (Item i : s.shopInventory) {
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
        if(p.currentLoc == null)
        {

            text.appendText("You have been killed!" + "\n");
            imagePane.setImage(gameOverImg);
            p.alive = false;

        } else if (p.getCurrentLoc().getMonsters().size() > 0) {

            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            ArrayList<Monster> monsters = p.getCurrentLoc().getMonsters();
            Monster randomMob = monsters.get(random_int(0, monsters.size()));
            doBattle(randomMob); //does multibattle if there are monsters

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
    } //end setNewLoc


    //creates all locations for the game and puts them in allLocs
    public void initLocs()
    {
        Location start = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", false, homeImg);
        start.addExit("N", "TOWN");
        start.addExit("S", "MEADOW");

        Location meadow = new Location("meadow", "MEADOW", "You are in a meadow, there are lots of flowers, it's nice.", false, null);
        meadow.addExit("N", "START");
        meadow.addExit("E", "LAKE");
        meadow.addExit("S", "CAVE");
        meadow.addExit("W", "FOREST");

        Location forest = new Location("forest", "FOREST", "You are in a spooky forest. Many spooky monsters can be found here. There is a cave to the east", false, forestImg);
        forest.addExit("E", "MEADOW");
        forest.addExit("W", "GROTTO");
        Monster noob = new Monster("Noob", 40, 8, 10, true, null);
        forest.addMonster(noob);
        forest.setAllMonsters(this.makeMonsterArray());

        Location grotto = new Location("grotto", "GROTTO", "You are now in a grotto, the feeling of nature is excellent", true, null);
        grotto.addExit("E", "FOREST");

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

        Location lake = new Location("lake", "LAKE", "You are at a lake, go do some fishin", false, null);
        lake.addExit("N", "SWAMP");
        lake.addExit("E", "COVE");
        lake.addExit("W", "MEADOW");

        Location cove = new Location("cove", "COVE", "You are in a cove, it's got a cool ancient vibe to it", false, null);
        cove.addExit("W", "LAKE");

        Location swamp = new Location("swamp", "SWAMP", "You are in a spooky swamp", false,  swampImg);
        swamp.addExit("N", "PATH");
        swamp.addExit("E", "CABIN");
        swamp.addExit("S", "LAKE");

        Location cabin = new Location("abandoned cabin", "CABIN", "You are in an abandoned cabin, the walls are rotting and the floor is overgrown", false, null);
        cabin.addExit("W", "CABIN");

        Location path = new Location("forgotten path", "PATH", "You are in a forgotten path, few of the living have tread upon it recently", false, null);
        path.addExit("N", "TUNDRA");
        path.addExit("E", "GRAVEYARD");
        path.addExit("S", "SWAMP");
        path.addExit("W", "TOWN");

        Location graveyard = new Location("graveyard", "GRAVEYARD", "You are in a graveyard, where the dead come to life, and the living come to die", false, null);
        graveyard.addExit("N", "CATACOMBS");
        graveyard.addExit("E", "TREE");
        graveyard.addExit("W", "PATH");

        Location tree = new Location("hanging tree", "TREE", "You are at a hanging tree, creepy whispers can be heard all around you", true, null);
        tree.addExit("W", "GRAVEYARD");

        Location catacombs = new Location("catacombs", "CATACOMBS", "You are in the catacombs, there are bones literally everywhere", true, null);
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

        Location pass = new Location("icy pass", "PASS", "You are in an icy pass, it's very high up, and there's not much visibility", false, null);
        pass.addExit("E", "MOUNTAIN");
        pass.addExit("W", "TWINPEAK");

        Location twinpeak = new Location("twin peak", "TWINPEAK", "You are at the Twin Peak, a dragon can be found here", true, null);
        twinpeak.addExit("W", "PASS");

        Location gate = new Location("castle gate", "GATE", "You are at the castle gate, you have to do a lot of stuff till you can open it", false, null);
        gate.addExit("N", "CASTLE");
        gate.addExit("S", "MOUNTAIN");

        Location castle = new Location("castle", "CASTLE", "You are the castle, you will face some very challenging foes here", true, null);
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

        Location wtower = new Location("west tower", "WESTTOWER", "You are at the West Tower, prepare for a fight", false, null);
        wtower.addExit("E", "HALL");

        Location sanctum = new Location("Inner Sanctum", "SANCTUM", "You are in the Inner Sanctum, home of the prince", true, null);
        sanctum.addExit("N", "THRONE");
        sanctum.addExit("S", "HALL");

        Location throne = new Location("Throne", "THRONE", "You are at the throne, where you will face your destiny and fight the king", true, null);
        throne.addExit("N", "CHAMBER");
        throne.addExit("S", "SANCTUM");

        Location chamber = new Location("ling's chamber", "CHAMBER", "You are at the king's chamber, there's a weird feeling coming from an object in this room", true, null);
        chamber.addExit("S", "THRONE");


        Location hell = new Location("hell", "HELL", "Welcome to hell, you must have screwed something up to end here", false, hellImg);


        Location end = new Location("end", "END", "awkfnawlfnalwkfnalkwf", true, endImg);
        Monster god = new Monster("GOD", 300, 35, 9000, true, godImg);
        end.addMonster(god);



        //add Locations to allLocs
        this.allLocs.add(start);
        this.allLocs.add(meadow);
        this.allLocs.add(grotto);
        this.allLocs.add(lake);
        this.allLocs.add(altar);
        this.allLocs.add(path);
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


    //makes a move based on user input
    public void makeMove(String move)
    {
        ArrayList<String> locExits = p.currentLoc.getExits();
        if (locExits.contains(move))
            this.setNewLoc(p.currentLoc.getConnectedLoc(move));

        else
            text.appendText("\n" + "Cannot go in that direction");



        /*
        else
        {
            imagePane.setImage(gameOverImg);
            text.appendText("You have been destroyed by the world!" + "\nGAME OVER" + "\n");
            p.alive = false;
            text.appendText("\nPlay again? (Y/N)" + "\n");
            inputText.setOnAction(event ->
            {

            String answer = inputText.getText();
            answer = answer.toUpperCase();
            //String answer = this.choice;
            if (answer.equalsIgnoreCase("y")) //if they want to play again
            {
                text.appendText("Alright! Let's go!" + "\n");
                this.reset();
            }
            else //if they want to quit
            {
                text.appendText("Wow. What a skrub, okay bye." + "\n");
                System.out.close();
            }
        });
        }
        */
    } //end makeMove


    public void centerMobImage()
    {
        Image img = mobImagePane.getImage();
        if (img != null) {
            double w = 0;
            double h = 0;

            double ratioX = mobImagePane.getFitWidth() / img.getWidth();
            double ratioY = mobImagePane.getFitHeight() / img.getHeight();

            double reducCoeff = 0;
            if(ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = img.getWidth() * reducCoeff;
            h = img.getHeight() * reducCoeff;

            mobImagePane.setX((mobImagePane.getFitWidth() - w) / 2);
            mobImagePane.setY((mobImagePane.getFitHeight() - h) / 2);

        }

    } //end centerMobImage


    /**
     * @FXML
     * Buttons
     */


    @FXML protected void handleNorthButtonPressed(ActionEvent event)
    {
        //text.appendText("Moved north!" + "\n");
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
                            p.equipWeapon(p.inventory.get(i));
                            playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n" + "Weapon: " + p.getWeapon().getItemName() + "\n");
                        } else if (p.inventory.get(i) instanceof Armor) {
                            p.equipArmor(p.inventory.get(i));
                        }
                    } else {
                        invText.appendText("Item not recognized");
                    }
                }


            });
        }
    }

/*
    @FXML protected boolean handleYesButtonPressed(ActionEvent event)
    {
        this.choice = "Y";
        //text.appendText("Yes was pressed!" + "\n");
        return true;
    }
    */
/*
    @FXML protected boolean handleNoButtonPressed(ActionEvent event)
    {
        this.choice = "N";
        //text.appendText("No was pressed!" + "\n");
        return true;
    }
*/



} //end class
