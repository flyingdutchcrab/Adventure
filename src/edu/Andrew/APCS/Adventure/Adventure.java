package edu.Andrew.APCS.Adventure;

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
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;

import javafx.animation.Animation;

/**
 * Adventure
 *
 * Adventure
 *
 * The Adventure class, there's a lot of methods here.
 */
public class Adventure
{

        //region Varables

    /**
     * Buttons and other things
     */
    @FXML
    private Button north;
    private Button east;
    private Button south;
    private Button west;
    private ToggleButton inventory;


    private boolean gameWon;
    private Player player;
    private Shop shop;
    private ArrayList<Location> allLocations;
    private boolean invBtnActive;
    private boolean mapActive;
    public static final int INDEFINITE = -1;
    private MediaPlayer mPlayer;
    private MediaPlayer sPlayer;


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
    @FXML
    //private GridPane mapPane;


    /**
     * Images
     */
    private Image homeImg;
    private Image townImg;
    private Image forestImg;
    private Image grottoImg;
    private Image caveImg;
    private Image tombImg;
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
    private Image dungeonImg;
    private Image armoryImg;
    private Image hallImg;
    private Image wTowerImg;
    private Image eTowerImg;
    private Image throneImg;
    private Image chamberImg;
    private Image gameOverImg;

    private Image skeletonImg;
    private Image skeletonImg2;
    private Image zombieImg;
    private Image mummyImg;
    private Image curupiraImg;
    private Image wolfImg;
    private Image spritieImg;
    private Image lizardImg;
    private Image landSharkImg;
    private Image squidImg;
    private Image slugImg;
    private Image crabImg;
    private Image shroomImg;
    private Image godImg;
    private Image wyvernImg;
    private Image dagonImg;
    private Image ghostGirlImg;
    private Image princessImg;
    private Image kingImg;
    private Image alrothiaImg;
    private Image argothImg;
    private Image forestSpiritImg;


        //endregion


        //region Constructor

    public Adventure() {

        this.gameWon = false;
        this.player = new Player();
        this.shop = new Shop();
        invBtnActive = false;
        mapActive = false;

        /** init. locations **/
        initLocations();

        /** images **/



    }

        //endregion


        //region Initialize


    /**
     * Init. Things. This should be only called once.
     */
    public void initialize()
    {
        imagePane.setImage(new Image("locations/welcomeimage.gif"));  //need to force this.
        imagePane.setVisible(true);
        //musicIsPlaying = true;
        playMedia("/hello.mp3");

        inventoryPane.setVisible(false);
        text.appendText("Welcome to the land of euphoria!\n");
        text.appendText("What's your name?\n");


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event ->
        {
            if (player.getPlayerName().equals("NotSet")) {

                player.setPlayerName(inputText.getText());
                text.appendText("Welcome, " + player.getPlayerName() + "\n");
                playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName() + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");
                this.setNewLocation("START");
                inputText.deleteText(0, inputText.getLength());


            } else {

                inputText.deleteText(0, inputText.getLength());
                text.appendText("\nThere is nothing to input at this time. ");

            }

        });

        //rest to restore health at home
        if (player.getCurrentLoc().getID().equals("START") && player.getHealth() < 100) {

            player.setHealth(100.0);
            text.appendText("You have rested! Your health is now " + player.getHealth() + "\n");
        }


    }


    /**
     * Creates all locations for the game and puts them in allLocations. Should only be called once
     */
    private void initLocations()
    {
        this.homeImg = new Image("locations/bedroom.gif");
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
        this.reefImg = new Image("locations/reef.gif");
        this.caveImg = new Image("locations/crystalcave.gif");
        this.tombImg = new Image("locations/anotheraltar.gif");
        this.altarImg = new Image("locations/corruptedaltar.gif");
        this.shopImg = new Image("locations/shop3.gif");
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
        this.dungeonImg = new Image("locations/dungeon.gif");
        this.armoryImg = new Image("locations/castleinside.jpg");
        this.hallImg = new Image("locations/interiorcastle.gif");
        this.wTowerImg = new Image("locations/westtower.gif");
        this.eTowerImg = new Image("locations/bigheadroom.gif");
        this.throneImg = new Image("locations/throneroom.gif");
        this.chamberImg = new Image("locations/kingschamber.gif");
        this.gameOverImg = new Image("locations/gameover.jpg");

        this.skeletonImg = new Image("monsters/skeletonwarrior.gif");
        this.skeletonImg2 = new Image("monsters/skeletonwarrior2.gif");
        this.zombieImg = new Image("monsters/zombiechaingirl.gif");
        this.mummyImg = new Image("monsters/mummy.gif");
        this.spritieImg = new Image("monsters/spritie.gif");
        this.curupiraImg = new Image("monsters/curupira.gif");
        this.wolfImg = new Image("monsters/cutewolf.gif");
        this.lizardImg = new Image("monsters/lizardman.gif");
        this.landSharkImg = new Image("monsters/landshark.gif");
        this.crabImg = new Image("monsters/crabmonster.gif");
        this.squidImg = new Image("monsters/squid.gif");
        this.slugImg = new Image("monsters/seaslug.gif");
        this.shroomImg = new Image("monsters/mushroom.gif");
        this.godImg = new Image("monsters/specimen9.gif");
        this.dagonImg = new Image("monsters/dagon.gif");
        this.ghostGirlImg = new Image("monsters/spookyghost.gif");
        this.wyvernImg = new Image("monsters/rathian.gif");
        this.princessImg = new Image("monsters/crystalmage.gif");
        this.kingImg = new Image("monsters/mage.gif");
        this.alrothiaImg = new Image("monsters/alrothia.gif");
        this.argothImg = new Image("monsters/daitya.gif");
        this.forestSpiritImg = new Image("monsters/forestspirit.gif");


        allLocations = new ArrayList<>();


        Location start = new Location("home", "START", "You are in your home. You can rest here to restore health. You can see a town to the North", false, homeImg);
        start.addExit("N", "TOWN");
        start.addExit("S", "MEADOW");

        Location meadow = new Location("meadow", "MEADOW", "You are in a meadow, there are lots of flowers, it'shop nice.", false, meadowImg);
        meadow.addExit("N", "START");
        meadow.addExit("E", "LAKE");
        meadow.addExit("S", "CAVE");
        meadow.addExit("W", "FOREST");

        Location forest = new Location("forest", "FOREST", "You are in a spooky forest. Many spooky monsters can be found here. There is a cave to the east", false, forestImg);
        forest.addExit("E", "MEADOW");
        forest.addExit("W", "GROTTO");
        forest.addMonster(new Monster("wolf", 20, 5, 1, 15, 10, 30, 20,  true, wolfImg));
        forest.addMonster(new Monster("skrub", 25, 5, 1, 15, 10, 15, 50, true, spritieImg));
        forest.addMonster(new Monster("curupira", 25, 10, 1, 20, 10, 15, 50, true, curupiraImg));

        forest.addMonster(new Monster("lizardman", 25, 15, 8, 35, 20,  15, 100, true, lizardImg));

        Location grotto = new Location("grotto", "GROTTO", "You are now in a grotto, the feeling of nature is excellent", true, grottoImg, "Forest Key");
        grotto.addExit("E", "FOREST");
        grotto.addMonster(new Boss("Forest Spirit", 300, 1, 50, 50, 1000, 35, 500, true, forestSpiritImg, 300, 1000, null));


        Location town = new Location("town", "TOWN", "You are in a small town. There is a massive menacing mountain over the northern horizon, a store to the west, and a forgotten path to the east.", false, townImg);
        town.addExit("N", "MOUNTAIN");
        town.addExit("E", "PATH");
        town.addExit("S", "START");
        town.addExit("W", "STORE");
        town.addStrayItem(new KeyItem("Region Map", 50.0, "Displays the map of the region"));

        Location cave = new Location("cave", "CAVE", "You are in a crystal cave, a lot of crystals here", false, caveImg);
        cave.addExit("N", "MEADOW");
        cave.addExit("S", "TOMB");

        Location tomb = new Location("tomb", "TOMB", "You are in an ancient tomb, the King often visits here", false, tombImg);
        tomb.addExit("N", "CAVE");
        tomb.addExit("S", "ALTAR");


        Location altar = new Location("altar", "ALTAR", "You are at an altar, there is an ominous feeling in the air here, almost like you really shouldn't be here", true, altarImg, "King's Key");
        altar.addExit("N", "TOMB");

        Location lake = new Location("lake", "LAKE", "You are at a lake, go do some fishin", false, lakeImg);
        lake.addExit("N", "SWAMP");
        lake.addExit("E", "COVE");
        lake.addExit("W", "MEADOW");


        Location cove = new Location("cove", "COVE", "You are in a cove, it's got a cool ancient vibe to it", false, coveImg);
        cove.addExit("E", "REEF");
        cove.addExit("W", "LAKE");
        cove.addMonster(new Monster("sea slug", 20, 10, 1, 10, 25, 5, 25, true, slugImg));
        cove.addMonster(new Monster("squid", 25, 5, 1, 15, 10, 15, 50, true, squidImg));
        cove.addMonster(new Monster("land shark", 20, 15, 8, 35, 20, 20, 60, true, landSharkImg));
        cove.addMonster(new Monster("crab monster", 15, 12, 8, 30, 15, 10, 60, true, crabImg));

        Location reef = new Location("reef", "REEF", "You are in a reef, there is a lot of ruins down here", true, reefImg, "Reef Key");
        reef.addExit("W", "COVE");
        reef.addMonster(new Boss("Dagon", 300, 90, 200, 900, 3000, 35, 600, true, dagonImg, 400, 2000, null));


        Location swamp = new Location("swamp", "SWAMP", "You are in a spooky swamp", false,  swampImg);
        swamp.addExit("N", "PATH");
        swamp.addExit("E", "HUT");
        swamp.addExit("S", "LAKE");

        Location hut = new Location("abandoned hut", "HUT", "You are in an abandoned hut, the walls are rotting and the floor is overgrown", false, cabinImg);
        hut.addExit("W", "SWAMP");
        hut.addExit("E", "END");
        hut.addStrayItem(new KeyItem("Eye Rune", 1000, "Reveals secrets, if you are smart enough to find them"));

        Location path = new Location("forgotten path", "PATH", "You are in a forgotten path, few of the living have tread upon it recently", false, pathImg);
        path.addExit("N", "TUNDRA");
        path.addExit("E", "GRAVEYARD");
        path.addExit("S", "SWAMP");
        path.addExit("W", "TOWN");

        Location graveyard = new Location("graveyard", "GRAVEYARD", "You are in a graveyard, where the dead come to life, and the living come to die", false, graveyardImg);
        graveyard.addExit("E", "TREE");
        graveyard.addExit("W", "PATH");
        graveyard.addMonster(new Monster("zombie", 20, 10, 1, 10, 25, 5, 25, true, zombieImg));
        graveyard.addMonster(new Monster("mummy", 20, 15, 8, 35, 20, 20, 60, true, mummyImg));
        graveyard.addMonster(new Monster("skeleton", 20, 10, 1, 10, 25, 5, 25, true, skeletonImg));
        graveyard.addMonster(new Monster("skeleton warrior", 25, 20, 10, 50, 35, 10, 45, true, skeletonImg2));

        Location tree = new Location("hanging tree", "TREE", "You are at a hanging tree, creepy whispers can be heard all around you", true, treeImg, "Grave Key");
        tree.addExit("W", "GRAVEYARD");
        tree.addMonster(new Boss("Vengeful Spirit", 300, 0, 100, 100, 2000, 35, 400, true, ghostGirlImg, 250, 1500, new KeyItem("Forest Key", 600, "Opens the grotto")));


        Location tundra = new Location("tundra", "TUNDRA", "You are in a freezing tundra, not much is happening here...", false, tundraImg);
        tundra.addExit("S", "PATH");
        tundra.addExit("W", "MOUNTAIN");

        Location mountain = new Location("mountain", "MOUNTAIN", "You are at a mountain, there'shop a great view up here", false, mountainImg);
        mountain.addExit("N", "GATE");
        mountain.addExit("E", "TUNDRA");
        mountain.addExit("S", "TOWN");
        mountain.addExit("W", "PASS");

        Location store = new Location("store", "STORE", "You are in a store. A wide variety of weapons and items can be bought here", false, shopImg);
        store.addExit("E", "TOWN");

        Location pass = new Location("icy pass", "PASS", "You are in an icy pass, it's very high up, and there'shop not much visibility", false, icyPassImg);
        pass.addExit("E", "MOUNTAIN");
        pass.addExit("W", "TWINPEAK");

        Location twinpeak = new Location("twin peak", "TWINPEAK", "You are at the Twin Peak, a dragon can be found here", true, twinPeakImg, "Twin Peak Key");
        twinpeak.addExit("E", "PASS");
        twinpeak.addMonster(new Boss("Wyvern", 400, 1, 75, 90, 1000, 45, 700, true, wyvernImg, 500, 5000, null));


        Location gate = new Location("castle gate", "GATE", "You are at the castle gate, you have to do a lot of stuff till you can open it", false, gateImg);
        gate.addExit("N", "CASTLE");
        gate.addExit("S", "MOUNTAIN");


        Location castle = new Location("castle", "CASTLE", "You are the castle, you will face some very challenging foes here", true, castleImg, "Gate Key");
        castle.addExit("N", "HALL");
        castle.addExit("E", "DUNGEON");
        castle.addExit("S", "GATE");
        castle.addExit("W", "ARMORY");

        Location dungeon = new Location("dungeon", "DUNGEON", "You are at the dungeon, a lot of people were imprisoned here", false, dungeonImg);
        dungeon.addExit("W", "CASTLE");

        Location armory = new Location("armory", "ARMORY", "You are at the armory, I'm sure you could find something useful here", false, armoryImg);
        armory.addExit("E", "CASTLE");

        Location hall = new Location("Hall of Chosen", "HALL", "You are at the Hall of the Chosen, nearly every direction here will challenge your destiny", false, hallImg);
        hall.addExit("N", "SANCTUM");
        hall.addExit("E", "EASTTOWER");
        hall.addExit("S", "CASTLE");
        hall.addExit("W", "WESTTOWER");

        Location etower = new Location("east tower", "EASTTOWER", "You are at the East Tower, prepare for a fight", false, eTowerImg);
        etower.addExit("W", "HALL");
        Monster argoth = new Boss("Argoth", 400, 150, 300, 400, 1000, 45, 800, true, argothImg, 450, 6000, null);
        etower.addMonster(argoth);

        Location wtower = new Location("west tower", "WESTTOWER", "You are at the West Tower, prepare for a fight", false, wTowerImg);
        wtower.addExit("E", "HALL");
        wtower.addMonster(new Boss("Alrothia", 400, 150, 300, 400, 1000, 45, 800, true, alrothiaImg, 450, 6000, null));

        Location sanctum = new Location("Inner Sanctum", "SANCTUM", "You are in the Inner Sanctum, home of the prince", true, null, "Twin Knight Key");
        sanctum.addExit("N", "THRONE");
        sanctum.addExit("S", "HALL");
        sanctum.addMonster(new Boss("Princess Amelia", 400, 1, 75, 800, 1500, 45, 1000, true, princessImg, 500, 8000, null));

        Location throne = new Location("Throne", "THRONE", "You are at the throne, where you will face your destiny and fight the king", true, throneImg, "Throne Key");
        throne.addExit("N", "CHAMBER");
        throne.addExit("S", "SANCTUM");
        throne.addMonster(new Boss("King Arthur", 400, 1, 75, 800, 1500, 45, 1000, true, kingImg, 500, 8000, null));

        Location chamber = new Location("king's chamber", "CHAMBER", "You are at the king's chamber, there is a weird feeling coming from an object in this room", true, chamberImg, "King's Key");
        chamber.addExit("S", "THRONE");

        Location hell = new Location("hell", "HELL", "Welcome to hell, you must have screwed something up to end here", false, hellImg);

        Location end = new Location("end", "END", "awkfnawlfnalwkfnalkwf", false, endImg);
        end.addMonster(new Boss("GOD", 300, 9998, 9999, 4999, 5000, 35, 1000000, true, godImg, 1000, 100000000, null));


        //add Locations to allLocations
        this.allLocations.add(start);
        this.allLocations.add(meadow);
        this.allLocations.add(grotto);
        this.allLocations.add(lake);
        this.allLocations.add(tomb);
        this.allLocations.add(altar);
        this.allLocations.add(path);
        this.allLocations.add(cove);
        this.allLocations.add(reef);
        this.allLocations.add(graveyard);
        this.allLocations.add(tree);
        this.allLocations.add(hut);
        this.allLocations.add(pass);
        this.allLocations.add(twinpeak);
        this.allLocations.add(gate);
        this.allLocations.add(castle);
        this.allLocations.add(dungeon);
        this.allLocations.add(armory);
        this.allLocations.add(hall);
        this.allLocations.add(etower);
        this.allLocations.add(wtower);
        this.allLocations.add(sanctum);
        this.allLocations.add(throne);
        this.allLocations.add(chamber);
        this.allLocations.add(town);
        this.allLocations.add(forest);
        this.allLocations.add(cave);
        this.allLocations.add(tundra);
        this.allLocations.add(swamp);
        this.allLocations.add(store);
        this.allLocations.add(mountain);
        this.allLocations.add(hell);
        this.allLocations.add(end);

    }


        //endregion


        //region Start


    /**
     * Start the Adventure
     */
    public void startAdventure()
    {
        //welcome user
        text.appendText("Welcome to the land of euphoria!" + "\n");

        //gets users name
        text.appendText("What'shop your name?" + "\n");
        player.setPlayerName(inputText.getText());
        text.appendText("Really? Welcome, " + player.getPlayerName() + "\n");


        //sets start location
        this.setNewLocation("START");

        while(player.isAlive()) {

            if(player.getCurrentLoc().getMonsters().size() > 0) {

                ArrayList<Monster> monsters = player.getCurrentLoc().getMonsters();
                Monster randomMob = monsters.get(random_int(0, monsters.size()));
                doBattle(randomMob); //does multibattle if there are monsters

                if(player.isAlive() && randomMob.getName().equals("GOD")) {

                    this.win();
                    text.setText("You have beaten the steam sales, you have won life!" + "\n");
                    text.appendText("Play again? (Y/N)" + "\n");
                    String answer = inputText.getText();
                    answer = answer.toUpperCase();
                    if (answer.equals("Y")) //if they want to play again{
                        text.setText("Alright! Let'shop go!" + "\n");
                        this.reset();
                    } else {
                        text.appendText("Wow. What a skrub, okay bye." + "\n");
                        System.out.close();
                    }

                }

            } //end while


            //rest to restore health at home
            if (player.getCurrentLoc().getID().equals("START") && player.getHealth() < 100) {

                player.setHealth(100.0);
                text.appendText("You have rested! Your health is now " + player.getHealth() + "\n");

            }

    }


        //endregion


        //region Location Functions


    /**
     * Takes a monster and simulates a battle until the monster or player dies
     */
    private void doBattle(Monster enemy) {

        System.out.print("doBattle\n");
        //first time run
        text.appendText("\n" + "A wild Lvl. " + enemy.getLevel() + " " + enemy.getName() + " has appeared!" + "\n" );
        mobImagePane.setImage(enemy.getImage());
        centerMobImage();

        enemy.setAlive(true);


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
                enemy.setHealth(enemy.getHealth() - player.getDamage()); //Sets the monsters health as their current health minus the players damage
                text.appendText("You attack " + enemy.getName() + " for " + player.getDamage() + " damage!" + "\n" + "Enemy health is " + enemy.getHealth() + "\n");

                //Monster turn
                enemy.setDamage(enemy.getDamage() / player.getPlayerArmorValue());
                player.setHealth(player.getHealth() - enemy.getDamage()); //Sets the players health as their current health minus the monsters damage
                text.appendText("The " + enemy.getName() + " hit you for " + enemy.getDamage() + " damage!" + "\n" + "Your health is " + player.getHealth() + "\n"); //prints how much damage the monster does to the player
                playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName() + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");

                if (player.getHealth() < 20.0)
                    text.appendText("Your health is low, you should return home and restore health!" + "\n");


                //checks if the player or monster is dead
                player.checkLife(); //calculate if dead
                enemy.checkLife(); //calculate if dead


                //when someone dies
                if (player.isAlive() && !enemy.isAlive()) // if you are still standing
                {
                    //print results (money earned, health remaining)
                    mobImagePane.setImage(null);
                    player.addWallet(enemy.getLoot());
                    player.setXp(player.getXp() + enemy.getXp());
                    playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName() + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");
                    text.setText("You shrekt the " + enemy.getName() + "\n" + "You got $" + enemy.getLoot() + " for winning!" + "\n");



                } else if (!player.isAlive()) { //if you died

                    mobImagePane.setImage(null);
                    text.setText("You have been shrekt by the " + enemy.getName());
                    setNewLocation(null);


                } else {
                    text.appendText("Attack again? (Y/N) \n");
                }

            } else if (theInputText.equalsIgnoreCase("n")) { // if they don't want to fight
                    mobImagePane.setImage(null);
                    text.appendText("You fled from the fight!" + "\n");
                    setNewLocation("MEADOW"); // brings you back to town
                    //System.out.print("Will i run?"); //DEBUG

            } else // they don't make any sense
                text.appendText("Unrecognized command_" + theInputText + "_" +enemy.isAlive() +"\n");

        });


    } //end doBattle

    private void doBossBattle(Boss boss)
    {
        mPlayer.stop();

        System.out.print("doBossBattle\n");
        //first time run
        text.appendText("\n" + boss.getName() + " has appeared!" + "\n" );
        mobImagePane.setImage(boss.getImage());
        centerMobImage();


        //Prompts user to attack or run
        text.appendText("Attack " + boss.getName() + "? (Y/N) " + "\n");


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event ->
        {
            String theInputText = inputText.getText();
            inputText.deleteText(0, theInputText.length());


            if (theInputText.equalsIgnoreCase("y") && boss.isAlive()) //if they want to fight
            {


                //Player turn
                boss.setHealth(boss.getHealth() - player.getDamage()); //Sets the monsters health as their current health minus the players damage
                text.appendText("You attack " + boss.getName() + " for " + player.getDamage() + " damage!" + "\n" + "boss health is " + boss.getHealth() + "\n");

                //Monster turn
                //boss.setDamage(boss.getDamage() / player.getArmor().getArmorValue());
                player.setHealth(player.getHealth() - boss.getDamage()); //Sets the players health as their current health minus the monsters damage
                text.appendText(boss.getName() + " hit you for " + boss.getDamage() + " damage!" + "\n" + "Your health is " + player.getHealth() + "\n"); //prints how much damage the monster does to the player
                playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName() + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");

                if (player.getHealth() < 20.0)
                    text.appendText("Your health is low, you should return home and restore health!" + "\n");


                //checks if the player or monster is dead
                player.checkLife(); //calculate if dead
                boss.checkLife(); //calculate if dead


                //when someone dies
                if (player.isAlive() && !boss.isAlive()) // if you are still standing
                {
                    //print results (money earned, health remaining)
                    mobImagePane.setImage(null);
                    player.addWallet(boss.getLoot());
                    player.setXp(player.getXp() + boss.getXp());
                    playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName() + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");
                    text.setText("You shrekt the " + boss.getName() + "\n" + "You got $" + boss.getLoot() + " for winning!" + "\n");
                    if (boss.getBossLoot() != null)
                    {
                        text.appendText("\n" + "Picked up an item!" + "\n");
                        player.getInventory().add(boss.getBossLoot());
                    }



                } else if (!player.isAlive()) { //if you died

                    mobImagePane.setImage(null);
                    text.setText("You have been shrekt by the " + boss.getName());
                    setNewLocation(null);


                } else {
                    text.appendText("Attack again? (Y/N) \n");
                }

            } else if (theInputText.equalsIgnoreCase("n")) { // if they don't want to fight
                mobImagePane.setImage(null);
                text.appendText("You fled from the fight!" + "\n");
                setNewLocation("MEADOW"); // brings you back to town
                //System.out.print("Will i run?"); //DEBUG

            } else // they don't make any sense
                text.appendText("Unrecognized command" + theInputText + "\n");

        });



          this.playBossMusic(boss);



    } //end boss battle


    /**
     * Multibattle takes in an array of monsters and does battle with each of them if the player is in the forest
     */
    public void domultiBattle(ArrayList<Monster> arrayOfMonsters)
    {
        for(Monster mob : arrayOfMonsters)
            this.doBattle(mob);
    }


    /**
     * doShop function to run the shop
     */
    private void doShop()
    {
        playMedia("/shop.mp3");

        text.appendText(shop.printShopInventory() + "\n");
        text.appendText("Type the item name to buy a weapon here. Go back west to leave shop." + "\n");


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event -> {
            String answer = inputText.getText();
            inputText.deleteText(0, answer.length());


            boolean item_found = false;
            for (Item i : shop.getShopInventory()) {
                if (i.getItemName().equalsIgnoreCase(answer)) {
                    item_found = true;
                    if (player.getWallet() >= i.getCost()) {

                        text.appendText("You bought the " + i.getItemName() + " for $" + i.getCost() + "\n");
                        player.getInventory().add(i);
                        player.addWallet(-i.getCost());
                        playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName() + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");
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


        //endregion


        //region Location Changes

    /**
     * Sets a new location - makes the move and other things.
     * @param ID new Location
     */
    private void setNewLocation(String ID)
    {

        /**
         * reset all things that need to be, yeah
         */
        mobImagePane.setImage(null); //always remove mob when location chances
        inputText.setOnAction(event -> {
            text.appendText("\nNo input at this time. ");
            inputText.deleteText(0, inputText.getText().length());
        });


        player.setCurrentLoc(this.getSingleLocation(ID));

        if(player.getCurrentLoc() == null) {  //killed/lost
            playMedia("/sadviolin.mp3");
            text.appendText("\n\nYou have been killed!\n");
            imagePane.setImage(gameOverImg);
            player.setAlive(false);

        } else if (player.getCurrentLoc().getMonsters().size() > 0) { //doBattle

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            ArrayList<Monster> monsters = player.getCurrentLoc().getMonsters();
            Monster randomMob = monsters.get(random_int(0, monsters.size()));
            if (randomMob instanceof Boss)
                doBossBattle((Boss) randomMob); //does multibattle if there are monsters

            else
                doBattle(randomMob);


        } else if (player.getCurrentLoc().getStrayItems().size() > 0) {
            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            text.appendText("There is an item here! Pick it up? (Y/N)" + "\n" );
            Item strayItemFound = player.getCurrentLoc().getStrayItems().get(random_int(0, player.getCurrentLoc().getStrayItems().size())); //Item
            inputText.setOnAction(event ->
            {
                String theInputText = inputText.getText();
                inputText.deleteText(0, theInputText.length());
                if (theInputText.equalsIgnoreCase("y"))
                {
                    player.getInventory().add(strayItemFound);
                    player.getCurrentLoc().removeStrayItem(strayItemFound);
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

        } else if (player.getCurrentLoc().getID().equals("START") && player.getHealth() < 100) { //home

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            text.appendText("\n" + "Would you like to rest? (Y/N)" + "\n");
            inputText.setOnAction(e ->
            {
                String choice = inputText.getText();
                inputText.deleteText(0, inputText.getLength());
                if (choice.equalsIgnoreCase("y") && player.getHealth() < 100) {
                    player.setHealth(100.0);
                    playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName()  + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");
                    text.appendText("You have rested! Your health is now " + player.getHealth() + "\n");
                }
                else if(choice.equalsIgnoreCase("n"))
                {
                    text.appendText("You chose not to rest" + "\n");
                }
                else
                {
                    text.appendText("Unrecognized command" + "\n");
                }

            });


        } else if( player.getCurrentLoc().getID().equals("STORE") ) { //doStore

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            doShop();

        }
        else if(player.getCurrentLoc().getID().equals("END"))
        {

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            ArrayList<Monster> monsters = player.getCurrentLoc().getMonsters();

            Monster randomMob = monsters.get(random_int(0, monsters.size()));

            doBossBattle((Boss) randomMob);


        } else if(player.getCurrentLoc().getID().equals("ALTAR"))
        {
            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            if (player.containsItem("Mysterious Rune"))
            {
                text.appendText("The Mysterious Rune is resonating, something is drawing it toward the altar!" + "\n");
                text.appendText("\nPlace the Mysterious Rune on the altar? (Y/N)" + "\n");
                inputText.setOnAction(e ->
                {
                    String choice = inputText.getText();
                    inputText.deleteText(0, inputText.getLength());
                    if (choice.equalsIgnoreCase("y")) {
                        this.setNewLocation("END");
                    }
                    else if(choice.equalsIgnoreCase("n"))
                    {
                        text.appendText("You chose not to place the Mysterious Rune on the altar" + "\n");
                    }
                    else
                    {
                        text.appendText("Unrecognized command" + "\n");
                    }

                });
            }

        } else { //spacer location

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());

        }

    }



    /**
     * Makes a move based on user input - checks locks
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


        if (player.getCurrentLoc().getExits().contains(move)) { //valid move
            for (int i = 0; i < allLocations.size(); i++)
                try {
                    if (allLocations.get(i).getID().equalsIgnoreCase(player.getCurrentLoc().getConnectedLoc(move))) //find move Location
                        if (!allLocations.get(i).isLocked()) { //is Location locked?

                            this.setNewLocation(player.getCurrentLoc().getConnectedLoc(move)); //there is no problem, move to location}


                            break;
                        } else { //location is locked
                            boolean found = false;
                            for (int j = 0; j < player.getInventory().size(); j++) { //check for key
                                if (player.getInventory().get(j).getItemName().equalsIgnoreCase(allLocations.get(i).getKeyItemUnlock())) { //had Key?
                                    System.out.println("found"); //DEBUG
                                    if (!player.getInventory().get(j).getItemName().equals("King's Key"))
                                    {
                                        player.getInventory().remove(player.getInventory().get(j)); //remove the key item

                                        text.appendText("\nThe key item to unlock this area has been removed. You have unlocked this location. \n");
                                    }
                                    allLocations.get(i).unlock(); //unlock the location.
                                    found = true;
                                    this.setNewLocation(player.getCurrentLoc().getConnectedLoc(move)); //user has key to unlock area.
                                    break;
                                }
                            }


                            if (!found) //valid move but does not have key.
                                text.appendText("\nThat direction, " + moveName + ", is locked. Try again when you have the key. \n");

                        }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("\n" + "ArrayIndexOutOfBoundsException!\n" + e);
                    break;
                }
        } else //not valid move (nothing is there in that direction
            text.appendText("\n" + "Cannot go in that direction. \n");

    }


        //endregion


        //region Other Functions

    /**
     * Get the current LocID
     * @return String of current location ID
     */
    public String checkLocationID() { return player.getCurrentLoc().getID(); }


    /**
     * Gets a sinle locaion baised off a location String ID
     * @param ID Location'shop ID
     * @return the Location
     */
    private Location getSingleLocation(String ID)
    {
        Location singleLoc = null;
        for(Location aLoc : allLocations)
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
     * Resets adventure to default
     */
    private void reset() {
        this.gameWon = false;
        player.setAlive(true);
        this.setNewLocation("START");

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
    public boolean isGameWon() { return this.gameWon; }


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

    private void playMedia(String url)
    {
        String path = getClass().getResource(url).toString();
        Media music = new Media(path);
        this.mPlayer = new MediaPlayer(music);
        mPlayer.isAutoPlay();
        mPlayer.play();
        mPlayer.setCycleCount(INDEFINITE);
    }

    private void stopMedia()
    {
        mPlayer.stop();
    }

    private void playBossMusic(Boss boss)
    {
        //musicIsPlaying = true;
        if (boss.getName().equalsIgnoreCase("GOD")) {
            if(player.getCurrentLoc().getID().equalsIgnoreCase("END"))
            {
                playSound("/laugh.mp3");
                playMedia("/god.mp3");
            }

        } else if (boss.getName().equalsIgnoreCase("Argoth")) {
            if (player.getCurrentLoc().getID().equalsIgnoreCase("EASTTOWER"))
            {
                playMedia("/xgongiveittoya.mp3");
            }


        }else if (boss.getName().equalsIgnoreCase("Vengeful Spirit")) {
            if (player.getCurrentLoc().getID().equalsIgnoreCase("TREE"))
            {
                playMedia("/ghostgirlfight.mp3");
            }


        }else if (boss.getName().equalsIgnoreCase("Dagon")) {
            if(player.getCurrentLoc().getID().equalsIgnoreCase("REEF")) {
                playMedia("/riseofthelord.mp3");
            }
        }else if (boss.getName().equalsIgnoreCase("Forest Spirit"))
        {
            if (player.getCurrentLoc().getID().equalsIgnoreCase("GROTTO"))
            {
                playMedia("/greenforest.mp3");
            }
        }
    }

    private void playSound(String url)
    {
        String path = getClass().getResource(url).toString();
        Media music = new Media(path);
        this.sPlayer = new MediaPlayer(music);
        sPlayer.isAutoPlay();
        sPlayer.play();
        sPlayer.setCycleCount(1);
    }

    private void stopSound()
    {
        sPlayer.stop();
    }


    /**
     * Get array AllLocs
     * @return AllLocs
     */
    public ArrayList<Location> getAllLocations() {
        return allLocations;
    }


        //endregion


        //region FXML Buttons


    /**
     * @FXML
     * Buttons
     */

    @FXML protected void handleNorthButtonPressed(ActionEvent event)
    {
        stopMedia();
        this.makeMove("N");
    }

    @FXML protected void handleEastButtonPressed(ActionEvent event)
    {
        stopMedia();
        this.makeMove("E");
    }

    @FXML protected void handleSouthButtonPressed(ActionEvent event)
    {
        stopMedia();
        this.makeMove("S");
    }

    @FXML protected void handleWestButtonPressed(ActionEvent event)
    {
        stopMedia();
        System.out.print(event.toString() + "\n");
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
            invText.setText(player.printInventory());

            invInputText.setOnAction(event2 ->
            {
                String choice = invInputText.getText();
                for (int i = 0; i < player.getInventory().size(); i++) {
                    if (choice.equalsIgnoreCase(player.getInventory().get(i).getItemName())) {
                        if (player.getInventory().get(i) instanceof Weapon) {
                            invInputText.deleteText(0, invInputText.getLength());
                            player.equipWeapon((Weapon) player.getInventory().get(i));
                            inputText.deleteText(0, inputText.getLength());
                            playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName() + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");
                        } else if (player.getInventory().get(i) instanceof Armor) {
                            invInputText.deleteText(0, invInputText.getLength());
                            player.equipArmor((Armor) player.getInventory().get(i));
                        }
                        else if (player.getInventory().get(i) instanceof KeyItem && player.getInventory().get(i).getItemName().equalsIgnoreCase("Eye Rune"))
                        {
                            invInputText.deleteText(0, invInputText.getLength());
                            invText.appendText("\nYour insight level: " + player.getInsight() + "\n");
                        }
                        else if(player.getInventory().get(i).getItemName().equalsIgnoreCase("Region Map"))
                        {
                            /*
                            if (mapActive) {
                                mapActive = true;
                                mapPane.setVisible(true);

                            } else {

                                mapActive = false;
                                mapPane.setVisible(false);
                            }
                            */
                        }
                    } else {
                        invInputText.deleteText(0, invInputText.getLength());
                        invText.appendText("\nItem not recognized" + "\n");
                    }

                }



            });

        }

    }


        //endregion


}
