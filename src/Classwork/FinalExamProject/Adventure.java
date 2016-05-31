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
    public String choice;
    public boolean fled;
    public Player p;
    public Location l;
    public Shop s;
    public ArrayList<Location> allLocs;

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



    public Image homeImg;
    public Image townImg;
    public Image forestImg;
    public Image caveImg;
    public Image shopImg;
    public Image mountainImg;
    public Image hellImg;
    public Image endImg;
    public Image tundraImg;
    public Image swampImg;
    public Image gameOverImg;
    public Image skeletonImg;
    public Image skeletonImg2;
    public Image spritieImg;
    public Image lizardImg;
    public Image landSharkImg;
    public Image llamaImg;
    public Image mingeImg;
    public Image godImg;

    //public AudioClip laugh;


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
                playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n" + "Weapon: " + p.getWeapon() + "\n");
                this.setNewLoc("START");
                inputText.deleteText(0, inputText.getLength());
            }


        else {
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
        if (p.currentLoc.getID().equals("START") && p.health < 100) {
            p.health = 100.0;
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
        p.playerName = inputText.getText();
        text.appendText("Really? Welcome, " + p.playerName + "\n");

        //choose jobSkill

        //print health and wallet
        //System.out.println("You have $" + p.wallet + "\nYour health is " + p.getHealth());


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
            if (p.currentLoc.getID().equals("START") && p.health < 100)
            {
                p.health = 100.0;
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
    public void doBattle(Monster enemy)
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
                playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");
                if (p.health < 20.0) {
                    text.appendText("Your health is low, you should return home and restore health!" + "\n");
                }

                //checks if the player or monster is dead
                p.checkLife(); //calculate if dead
                enemy.checkLife(); //calculate if dead


                //when someone dies
                if (p.alive && !enemy.isAlive()) // if you are still standing
                {
                    //print results (money earned, health remaining)
                    mobImagePane.setImage(null);
                    p.wallet += enemy.getLoot();
                    playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");
                    text.setText("You shrekt the " + enemy.getName() + "\n" + "You got $" + enemy.getLoot() + " for winning!" + "\n");
                    playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");


                } else if (!p.alive) { //if you died

                    mobImagePane.setImage(null);
                    text.setText("You have been shrekt by the " + enemy.getName());

                    setNewLoc(null);


                    /**
                     *
                     * create game over location
                     *
                     *
                     * remember: append text and ask if play again.

                    String answer = inputText.getText();
                    answer.toUpperCase();
                    //String answer = this.choice;

                    if (answer.equals("Y")) //if they want to play again
                    {
                        text.appendText("Alright! Let's go!" + "\n");
                        this.reset();
                    } else //if they want to quit
                    {
                        text.appendText("Wow. What a skrub, okay bye." + "\n");
                        System.out.close();
                    }
                     */

                } else {
                    text.appendText("Attack again? (Y/N) \n");
                }

            } else if (theInputText.equalsIgnoreCase("n")) { // if they don't want to fight
                    mobImagePane.setImage(null);
                    text.appendText("You fled from the fight!" + "\n");
                    setNewLoc("TOWN"); // brings you back to town
                    //System.out.print("Will i run?"); //DEBUG

            } else // they don't make any sense
                text.appendText("Unrecognized command" + "\n");

        });


    } //end doBattle


    //Resets adventure to default
    public void reset()
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

		/*
		for (i = 0; i < allMobs.length; i++)
		{
			this.doBattle(allMobs[i]);
		}
		*/
    }

    //set/get currentLoc
    public String checkLocID()
    {
        return p.currentLoc.getID();
    }

    public Location getSingleLoc(String ID)
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
    public void doShop()
    {
        s.initializeShopInventory();

        text.appendText(s.printShopInventory() + "\n");
        text.appendText("Type the item name to buy a weapon here. Go back west to leave shop." + "\n");



        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event -> {
            String answer = inputText.getText();
            inputText.deleteText(0, answer.length());


            //System.out.print("\n\n" + answer); //debug

            boolean item_found = false;

            for (Item i : s.shopInventory) {

                if (i.getItemName().equalsIgnoreCase(answer)) {
                    item_found = true;

                    if (p.wallet >= i.getCost()) {
                        text.appendText("You bought the " + i.getItemName() + " for " + i.getCost() + "\n");
                        p.inventory.add(i);
                        p.wallet -= i.getCost();
                        playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");
                        break;
                    } else {
                        text.appendText("You don't have enough money to buy that." + "\n");
                    }
                }
            }


            if (item_found)
                item_found = false;

            else
                text.appendText("Sorry we didn't find that item, try again. ");




        });


    } //end doShop

    public void setNewLoc(String ID)
    {

        /**
         * reset all things that need to be, yeah
         */
        mobImagePane.setImage(null); //always remove mob when location chances
        inputText.setOnAction(event ->
                {text.appendText("\nNo input at this time. "); inputText.deleteText(0, inputText.getText().length());});



        p.currentLoc = this.getSingleLoc(ID);
        if(p.currentLoc == null)
        {
            text.appendText("You have been killed!" + "\n");
            imagePane.setImage(gameOverImg);
            p.alive = false;

        }

        else if (p.getCurrentLoc().getMonsters().size() > 0)
        {
            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            ArrayList<Monster> monsters = p.getCurrentLoc().getMonsters();
            Monster randomMob = monsters.get(random_int(0, monsters.size()));
            doBattle(randomMob); //does multibattle if there are monsters

        }

        else if (p.currentLoc.getID().equals("START") && p.health < 100)
        {
            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            p.health = 100.0;
            playerInfo.setText(p.getPlayerName() + "\n" + "Health: " + p.getHealth() + "\n" + "Wallet: " + p.getWallet() + "\n");
            text.appendText("You have rested! Your health is now " + p.getHealth() + "\n");
        }



        else if(p.currentLoc.getID().equals("STORE"))
        {
            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
            doShop();
        }

        else
        {
            text.setText("You are now in " + p.currentLoc.getName() + "\n" + p.currentLoc.getDescription() + "\n");
            imagePane.setImage(p.getCurrentLoc().getImage());
        }
    }
    //creates all locations for the game and puts them in allLocs
    public void initLocs()
    {
        Location start = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", false, homeImg);
        start.addExit("N", "TOWN");

        Location town = new Location("town", "TOWN", "You are in a small town. There is a massive menacing mountain over the northern horizon, a store to the west, and a spooky forest to the east.", false, townImg);
        town.addExit("N", "MOUNTAIN");
        town.addExit("E", "FOREST");
        town.addExit("S", "START");
        town.addExit("W", "STORE");

        Location forest = new Location("forest", "FOREST", "You are in a spooky forest. Many spooky monsters can be found here. There is a cave to the east", false, forestImg);
        forest.addExit("N", "TUNDRA");
        forest.addExit("W", "TOWN");
        forest.addExit("E", "CAVE");
        forest.addExit("S", "SWAMP");
        Monster noob = new Monster("Noob", 40, 8, 10, true, null);
        forest.addMonster(noob);
        forest.setAllMonsters(this.makeMonsterArray());

        Location tundra = new Location("tundra", "TUNDRA", "You are in a freezing tundra, not much is happening here...", false, tundraImg);
        tundra.addExit("S", "FOREST");

        Location cave = new Location("cave", "CAVE", "You are in a spooky cave", false, caveImg);
        cave.addExit("W", "FOREST");

        Location swamp = new Location("swamp", "SWAMP", "You are in a spooky swamp", false,  swampImg);
        swamp.addExit("N", "FOREST");

        Location store = new Location("store", "STORE", "You are in a store. A wide variety of weapons and items can be bought here", false, shopImg);
        store.addExit("E", "TOWN");

        Location mountain = new Location("mountain", "MOUNTAIN", "You are at Mount Valve, where all wallets are stored, guarded by our omnipotent Lord Gaben. You can choose to fight him or wait until you are ready", true, mountainImg);
        mountain.addExit("N", "HELL");
        mountain.addExit("S", "TOWN");


        Location hell = new Location("hell", "HELL", "Welcome to hell, you must have screwed something up to end here", false, hellImg);
        hell.addExit("N", "END");
        hell.addExit("S","TOWN");

        Location end = new Location("end", "END", "awkfnawlfnalwkfnalkwf", true, endImg);
        end.addExit("S", "HELL");
        Monster god = new Monster("GOD", 300, 35, 9000, true, godImg);
        end.addMonster(god);



        //add Locations to allLocs
        this.allLocs.add(start);
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
        String newLoc = p.currentLoc.getConnectedLoc(move);
        ArrayList<String> locExits = p.currentLoc.getExits();
        if (locExits.contains(move) )
        {
            this.setNewLoc(newLoc);
        }

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
    }

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
        inventoryPane.setVisible(true);
        invText.appendText(p.printInventory());
        invInputText.setOnAction(event2 ->
        {
            String choice = invInputText.getText();
            for(int i = 0; i < p.inventory.size(); i++)
            {
            if (choice.equalsIgnoreCase(p.inventory.get(i).getItemName()))
            {
                if (p.inventory.get(i) instanceof Weapon)
                {
                    p.equipWeapon(p.inventory.get(i));
                }
                else if (p.inventory.get(i) instanceof Armor)
                {
                    p.equipArmor(p.inventory.get(i));
                }
            }
            else
            {
                invText.appendText("Item not recognized");
            }
            }


        });
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
