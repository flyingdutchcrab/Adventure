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
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;

/**
 * Adventure
 *
 * Adventure
 *
 * The Adventure class, there's a lot of methods here.
 */
public class Adventure
{

        //region Variables

    /**
     * Buttons and other things
     */
    @FXML
    private Button north;
    @FXML
    private Button east;
    @FXML
    private Button south;
    @FXML
    private Button west;
    @FXML
    private ToggleButton inventory;


    private boolean gameWon;
    private Player player;
    private Shop shop;
    private ArrayList<Location> allLocations;
    private boolean invBtnActive;
    private static final int INDEFINITE = -1;
    private MediaPlayer mPlayer;
    private MediaPlayer sPlayer;
    private boolean isChoosingWepon;


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
    //@FXML
    //private GridPane mapPane;


    /**
     * Images
     */
    private Image gameOverImg;


        //endregion


        //region Constructor

    public Adventure() {

        this.gameWon = false;
        this.player = new Player();
        this.shop = new Shop();
        invBtnActive = false;

        /** images **/

        //Locations
        Image homeImg = new Image("locations/bedroom.gif");
        Image townImg = new Image("locations/rsz_nighttown.jpg");
        Image pathImg = new Image("locations/forgottenpath.gif");
        Image graveyardImg = new Image("locations/graveyard.gif");
        Image catacombsImg = new Image("locations/catacombs.gif");
        Image treeImg = new Image("locations/hangingtree.gif");
        Image forestImg = new Image("locations/bestforest.gif");
        Image meadowImg = new Image("locations/bettermeadow.gif");
        Image grottoImg = new Image("locations/bettergrotto.png");
        Image lakeImg = new Image("locations/finallake.gif");
        Image coveImg = new Image("locations/covefinal.gif");
        Image reefImg = new Image("locations/reef.gif");
        Image caveImg = new Image("locations/crystalcave.gif");
        Image tombImg = new Image("locations/anotheraltar.gif");
        Image altarImg = new Image("locations/corruptedaltar.gif");
        Image shopImg = new Image("locations/shop3.gif");
        Image mountainImg = new Image("locations/mountain.gif");
        Image icyPassImg = new Image("locations/icypass.gif");
        Image twinPeakImg = new Image("locations/mountainanim.gif");
        Image hellImg = new Image("locations/hellsurface2.gif");
        Image endImg = new Image("locations/scarybackground.gif");
        Image tundraImg = new Image("locations/rsz_anothertundra.jpg");
        Image gateImg = new Image("locations/castlegate2.gif");
        Image castleImg = new Image("locations/wintercastle.jpg");
        Image swampImg = new Image("locations/8bitswamp.gif");
        Image cabinImg = new Image("locations/cabin.gif");
        Image dungeonImg = new Image("locations/dungeon.gif");
        Image armoryImg = new Image("locations/castleinside.jpg");
        Image hallImg = new Image("locations/interiorcastle.gif");
        Image wTowerImg = new Image("locations/westtower.gif");
        Image eTowerImg = new Image("locations/bigheadroom.gif");
        Image sanctumImg = new Image("locations/innersanctum.png");
        Image throneImg = new Image("locations/throneroom.gif");
        Image chamberImg = new Image("locations/kingschamber.gif");
        this.gameOverImg = new Image("locations/gameover.jpg");

        //Monsters
        Image skeletonImg = new Image("monsters/skeletonwarrior.gif");
        Image skeletonImg2 = new Image("monsters/skeletonwarrior2.gif");
        Image zombieImg = new Image("monsters/zombiechaingirl.gif");
        Image mummyImg = new Image("monsters/mummy.gif");
        Image spritieImg = new Image("monsters/spritie.gif");
        Image curupiraImg = new Image("monsters/curupira.gif");
        Image wolfImg = new Image("monsters/cutewolf.gif");
        Image lizardImg = new Image("monsters/lizardman.gif");
        Image landSharkImg = new Image("monsters/landshark.gif");
        Image crabImg = new Image("monsters/crabmonster.gif");
        Image squidImg = new Image("monsters/squid.gif");
        Image slugImg = new Image("monsters/seaslug.gif");
        Image shroomImg = new Image("monsters/mushroom.gif");
        Image godImg = new Image("monsters/specimen9.gif");
        Image dagonImg = new Image("monsters/dagon.gif");
        Image ghostGirlImg = new Image("monsters/spookyghost.gif");
        Image wyvernImg = new Image("monsters/rathian.gif");
        Image princessImg = new Image("monsters/crystalmage.gif");
        Image kingImg = new Image("monsters/mage.gif");
        Image alrothiaImg = new Image("monsters/alrothia.gif");
        Image argothImg = new Image("monsters/daitya.gif");
        Image forestSpiritImg = new Image("monsters/forestspirit.gif");


        /** init. locations **/

        this.allLocations = new ArrayList<>();


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
        grotto.addMonster(new Boss("Forest Spirit", 300, 1, 50, 50, 1000, 35, 500, true, forestSpiritImg, 300, 1000, new KeyItem("Reef Key", 250, "Opens the reef")));


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
        reef.addMonster(new Boss("Dagon", 300, 90, 200, 900, 3000, 35, 600, true, dagonImg, 400, 2000, new KeyItem("Twin Peak Key", 300, "Opens the Twin Peak")));

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
        tree.addMonster(new Boss("Vengeful Spirit", 300, 0, 100, 100, 2000, 35, 400, true, ghostGirlImg, 250, 1500, new KeyItem("Forest Key", 200, "Opens the grotto")));

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
        twinpeak.addMonster(new Boss("Wyvern", 400, 1, 75, 90, 1000, 45, 700, true, wyvernImg, 500, 5000, new KeyItem("Gate Key", 400, "Opens the castle gate")));

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

        etower.addMonster(new Boss("Argoth", 400, 150, 300, 400, 1000, 45, 800, true, argothImg, 450, 6000, new KeyItem("Argoth's Key Shard", 500, "Combines with Alrothia's Key to form the Twin Knight Key")));

        Location wtower = new Location("west tower", "WESTTOWER", "You are at the West Tower, prepare for a fight", false, wTowerImg);
        wtower.addExit("E", "HALL");

        wtower.addMonster(new Boss("Alrothia", 400, 150, 300, 400, 1000, 45, 800, true, alrothiaImg, 450, 6000, new KeyItem("Alrothia's Key Shard", 500, "Combines with Argoth's Key to form the Twin Knight Key")));



        Location sanctum = new Location("Inner Sanctum", "SANCTUM", "You are in the Inner Sanctum, home of the prince", true, sanctumImg, "Twin Knight Key");
        sanctum.addExit("N", "THRONE");
        sanctum.addExit("S", "HALL");
        sanctum.addMonster(new Boss("Princess Amelia", 400, 1, 75, 800, 1500, 45, 1000, true, princessImg, 500, 8000, new KeyItem("Throne Key", 1500, "Opens the throne room")));

        Location throne = new Location("Throne", "THRONE", "You are at the throne, where you will face your destiny and fight the king", true, throneImg, "Throne Key");
        throne.addExit("N", "CHAMBER");
        throne.addExit("S", "SANCTUM");
        throne.addMonster(new Boss("King Arthur", 400, 1, 75, 800, 1500, 45, 1000, true, kingImg, 500, 8000, new KeyItem("King's Key", 2000, "Opens the king's chamber and somewhere else")));

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


        //region Initialize


    /**
     * Init. Things. This should be only called once.
     */
    public void initialize()
    {
        imagePane.setImage(new Image("locations/welcomeimage.gif"));  //need to force this.
        imagePane.setVisible(true);
        //musicIsPlaying = true;
        playMedia("/music/hello.mp3");

        inventoryPane.setVisible(false);
        text.appendText("Welcome to the land of euphoria!\n");
        text.appendText("What's your name?\n");


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event ->
        {
            if (player.getPlayerName().equals("NotSet")) {

                player.setPlayerName(inputText.getText());
                text.appendText("Welcome, " + player.getPlayerName() + "\n");
                updatePlayerInfo();
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
                        text.setText("Alright! Let's go!" + "\n");
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
     * @param enemy the Monster
     */
    private void doBattle(Monster enemy) {

        //System.out.print("doBattle\n"); //DEBUG
        //first time run
        text.appendText("\n" + "A wild Lvl. " + enemy.getLevel() + " " + enemy.getName() + " has appeared!" + "\n" );
        mobImagePane.setImage(enemy.getImage());
        centerMobImage();

        /** have to make sure the enemy is alive **/
        enemy.setAlive(true);
        enemy.setHealth(enemy.getStartHealth());


        //Prompts user to attack or run
        text.appendText("Do you want to fight " + enemy.getName() + " or run away? (fight/run) " + "\n");
        isChoosingWepon = false;


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event ->
        {
            boolean isHandled = true; //this just makes it so that "unrecognised command" does not show all the time.



            String theInputText = inputText.getText();
            inputText.deleteText(0, theInputText.length());

            /** easter eggs
             * attack: die bitch
             * run: fuck this, fuck this shit
             */

            if(isChoosingWepon) {
                double damageToDeal = 0;
                Weapon weaponToUse = null;

                for(int i = 0; i < player.getInventory().size(); i++) {
                    if (player.getInventory().get(i).getItemName().equalsIgnoreCase(theInputText) && player.getInventory().get(i) instanceof Weapon ) {
                        weaponToUse = (Weapon) player.getInventory().get(i);
                        damageToDeal = weaponToUse.getDamage();
                        break;
                    }

                }

                if (weaponToUse == null) {
                    text.appendText("Sorry, didn't find that item. Try again?\n(Type in the weapon you would like to use. Not everything will deal damage)\n");
                    isHandled = false;

                } else {
                    isChoosingWepon = false;
                    isHandled = false;

                    //Player turn
                    enemy.setHealth(enemy.getHealth() - (damageToDeal * (1+ (player.getLevel() / 100)))); //Sets the monsters health as their current health minus the players damage
                    playSound("/sound/slash.mp3");
                    text.appendText("You attack " + enemy.getName() + " for " + (damageToDeal * (1 + (player.getLevel() / 100))) + " damage!" + "\n" + "Enemy health is " + enemy.getHealth() + "\n");


                    /**still need to check if you and your enemy are alive**/

                    player.checkLife(); //calculate if dead
                    enemy.checkLife(); //calculate if dead

                    //when someone dies
                    if (player.isAlive() && !enemy.isAlive()) // if you are still standing
                    {
                        //print the results

                        mobImagePane.setImage(null);
                        player.addWallet(enemy.getLoot());
                        player.addXP(enemy.getLevel() * 1.7);

                        updatePlayerInfo();
                        stopMedia();
                        playSound("/sound/win.mp3");
                        text.appendText("You shrekt the " + enemy.getName() + "\n" + "You got $" + enemy.getLoot() + " for winning!" + "\n");


                    } else if (!player.isAlive()) { //if you died

                        mobImagePane.setImage(null);
                        text.appendText("You have been shrekt by the " + enemy.getName());
                        setNewLocation(null);

                    } else
                        text.appendText("Would you like to continue fighting or run? (attack/run)\n");

                }
            } //end picking weapon



            if ((theInputText.equalsIgnoreCase("fight") || theInputText.equalsIgnoreCase("attack") || theInputText.equalsIgnoreCase("die bitch")) && enemy.isAlive()) //if they want to fight
            {
                //Monster turn
                enemy.setDamage(enemy.getDamage() / player.getPlayerArmorValue());
                player.setHealth(player.getHealth() - enemy.getDamage()); //Sets the players health as their current health minus the monsters damage
                playSound("/sound/smallexplosion.mp3");
                text.appendText("The " + enemy.getName() + " hit you for " + enemy.getDamage() + " damage!" + "\n" + "Your health is " + player.getHealth() + "\n"); //prints how much damage the monster does to the player

                updatePlayerInfo();

                isChoosingWepon = true; //your turn

                if (player.getHealth() < 20.0) //warning
                    text.appendText("Your health is low, you should return home and restore health!" + "\n");


                player.checkLife(); //calculate if dead
                enemy.checkLife(); //calculate if dead


                //when someone dies
                if (player.isAlive() && !enemy.isAlive()) // if you are still standing
                {
                    //print results (money earned, health remaining)
                    mobImagePane.setImage(null);
                    player.addWallet(enemy.getLoot());
                    player.addXP(enemy.getLevel() * 1.7);
                    updatePlayerInfo();
                    text.appendText("You shrekt the " + enemy.getName() + "\n" + "You got $" + enemy.getLoot() + " for winning!" + "\n");


                } else if (!player.isAlive()) { //if you died

                    mobImagePane.setImage(null);
                    text.appendText("You have been shrekt by the " + enemy.getName());
                    setNewLocation(null);


                } else
                    text.appendText("What weapon would you like to use? (check your inventory) \n");


            } else if (theInputText.equalsIgnoreCase("run") || theInputText.equalsIgnoreCase("run away") || theInputText.equalsIgnoreCase("flee") || theInputText.equalsIgnoreCase("FUCK THIS") || theInputText.equalsIgnoreCase("FUCK THIS SHIT")) { // if they don't want to fight
                mobImagePane.setImage(null);
                text.setText("You fled from the fight!" + "\n");
                player.addXP(-10); //pussy
                setNewLocation("MEADOW"); // brings you back to town
                //System.out.print("Will i run?"); //DEBUG

            } else if (isHandled) // they don't make any sense
                text.appendText("Unrecognized command. ");
                //text.appendText("Unrecognized command_" + theInputText + "_" +enemy.isAlive() +"\n");

        });

        playBattleMusic();


    } //end doBattle


    /**
     * Do Boss Battle
     * @param enemy the BOSS!
     */
    private void doBossBattle(Boss enemy)
    {
        mPlayer.stop();
        playBossMusic(enemy);

        //System.out.print("doBossBattle\n"); //DEBUG

        //first time run
        text.appendText("\n" + enemy.getName() + " has appeared!" + "\n" );
        mobImagePane.setImage(enemy.getImage());
        centerMobImage();


        /** have to make sure the enemy is alive **/
        enemy.setAlive(true);
        enemy.setHealth(enemy.getStartHealth());


        //Prompts user to attack or run
        text.appendText("Do you want to fight " + enemy.getName() + " or run away? (fight/run) " + "\n");
        isChoosingWepon = false;


        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event ->
        {
            boolean isHandled = true; //this just makes it so that "unrecognised command" does not show all the time.


            String theInputText = inputText.getText();
            inputText.deleteText(0, theInputText.length());


            /** easter eggs
             * attack: die bitch
             * run: fuck this, fuck this shit
             */

            if(isChoosingWepon) {
                double damageToDeal = 0;
                Weapon weaponToUse = null;

                for(int i = 0; i < player.getInventory().size(); i++) {
                    if (player.getInventory().get(i).getItemName().equalsIgnoreCase(theInputText) && player.getInventory().get(i) instanceof Weapon ) {
                        weaponToUse = (Weapon) player.getInventory().get(i);
                        damageToDeal = weaponToUse.getDamage();
                        break;
                    }

                }

                if (weaponToUse == null) {
                    text.appendText("Sorry, didn't find that item. Try again?\n(Type in the weapon you would like to use. Not everything will deal damage)\n");
                    isHandled = false;

                } else {
                    isChoosingWepon = false;
                    isHandled = false;

                    //Player turn
                    enemy.setHealth(enemy.getHealth() - (damageToDeal * (1+ (player.getLevel() / 100)))); //Sets the monsters health as their current health minus the players damage
                    text.appendText("You attack " + enemy.getName() + " for " + (damageToDeal * (1 + (player.getLevel() / 100))) + " damage!" + "\n" + "Enemy health is " + enemy.getHealth() + "\n");
                    playSound("/sound/slash.mp3");


                    /**still need to check if you and your enemy are alive**/

                    player.checkLife(); //calculate if dead
                    enemy.checkLife(); //calculate if dead

                    //when someone dies
                    if (player.isAlive() && !enemy.isAlive()) // if you are still standing
                    {
                        //print the results
                        stopMedia();

                        mobImagePane.setImage(null);
                        player.addWallet(enemy.getLoot());
                        player.addXP(enemy.getLevel() * 1.7);

                        updatePlayerInfo();
                        text.appendText("You shrekt the " + enemy.getName() + "\n" + "You got $" + enemy.getLoot() + " for winning!" + "\n");
                        playSound("/sound/win.mp3");


                    } else if (!player.isAlive()) { //if you died

                        mobImagePane.setImage(null);
                        text.appendText("You have been shrekt by the " + enemy.getName());
                        setNewLocation(null);

                    } else
                        text.appendText("Would you like to continue fighting or run? (attack/run)\n");

                }
            } //end picking weapon



            if ((theInputText.equalsIgnoreCase("fight") || theInputText.equalsIgnoreCase("attack") || theInputText.equalsIgnoreCase("die bitch")) && enemy.isAlive()) //if they want to fight
            {
                //Monster turn
                enemy.setDamage(enemy.getDamage() / player.getPlayerArmorValue());
                player.setHealth(player.getHealth() - enemy.getDamage()); //Sets the players health as their current health minus the monsters damage
                playSound("/sound/mediumexplosion.mp3");
                text.appendText(enemy.getName() + " hit you for " + enemy.getDamage() + " damage!" + "\n" + "Your health is " + player.getHealth() + "\n"); //prints how much damage the monster does to the player
                updatePlayerInfo();

                isChoosingWepon = true; //your turn

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
                    player.addXP(enemy.getXp());
                    updatePlayerInfo();
                    text.setText("You shrekt the " + enemy.getName() + "\n" + "You got $" + enemy.getLoot() + " for winning!" + "\n");
                    playSound("/sound/win.mp3");

                    if (enemy.getBossLoot() != null) {
                        text.appendText("\n" + "Obtained the " + enemy.getBossLoot().getItemName() + "!" + "\n");
                        player.getInventory().add(enemy.getBossLoot());
                    }

                    if (player.containsItem("Argoth's Key Shard") && player.containsItem("Alrothia's Key Shard")) {

                        player.getInventory().add(new KeyItem("Twin Knight Key", 1000, "Opens the inner sanctum"));
                        player.getInventory().remove(new KeyItem("Argoth's Key Shard", 500, "Combines with Alrothia's Key to form the Twin Knight Key"));
                        player.getInventory().remove(new KeyItem("Alrothia's Key Shard", 500, "Combines with Argoth's Key to form the Twin Knight Key"));

                    }

                } else if (!player.isAlive()) { //if you died
                        mobImagePane.setImage(null);
                        text.setText("You have been shrekt by the " + enemy.getName());
                        setNewLocation(null);

                } else
                    text.appendText("What weapon would you like to use? (check your inventory) \n");



            } else if (theInputText.equalsIgnoreCase("run") || theInputText.equalsIgnoreCase("run away") || theInputText.equalsIgnoreCase("flee") || theInputText.equalsIgnoreCase("FUCK THIS") || theInputText.equalsIgnoreCase("FUCK THIS SHIT")) { // if they don't want to fight
                text.appendText("\nThere's nowhere to run!" + "\n");

            } else if (isHandled) // they don't make any sense
                text.appendText("Unrecognized command. ");
                //text.appendText("Unrecognized command_" + theInputText + "_" +enemy.isAlive() +"\n");


        });

    } //end boss battle


    /**
     * Multibattle takes in an array of monsters and does battle with each of them if the player is in the forest
     * @param arrayOfMonsters The Monsters to battle
     */
    public void domultiBattle(ArrayList<Monster> arrayOfMonsters) {
        for(Monster mob : arrayOfMonsters)
            this.doBattle(mob);
    }


    /**
     * doShop function to run the shop
     */
    private void doShop()
    {
        playMedia("/music/shop.mp3");

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
                        playSound("/sound/powerup.mp3");
                        player.getInventory().add(i);
                        player.addWallet(-i.getCost());
                        updatePlayerInfo();
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
        Platform.runLater(() -> inputText.requestFocus());
        inputText.setOnAction(event -> {
            text.appendText("\nNo input at this time. ");
            inputText.deleteText(0, inputText.getText().length());
        });


        player.setCurrentLoc(this.getSingleLocation(ID));
        player.addXP(.5); //add XP for move change.
        updatePlayerInfo();



        /**
         * Heres what to do based off location.
         */



        if(player.getCurrentLoc() == null) {  //killed/lost
            playMedia("/music/sadviolin.mp3");
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


        } else if (player.getCurrentLoc().getStrayItems().size() > 0) { //there's a stray item

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            text.appendText("There is an item here! Pick it up? (Y/N)" + "\n" );
            Item strayItemFound = player.getCurrentLoc().getStrayItems().get(random_int(0, player.getCurrentLoc().getStrayItems().size())); //Item

            Platform.runLater(() -> inputText.requestFocus());
            inputText.setOnAction(event ->
            {
                String theInputText = inputText.getText();
                inputText.deleteText(0, theInputText.length());
                if (theInputText.equalsIgnoreCase("y")) {
                    player.getInventory().add(strayItemFound);
                    player.getCurrentLoc().removeStrayItem(strayItemFound);
                    player.addXP(10); //pick up XP
                    text.appendText("You picked up the " + strayItemFound.getItemName() + "\n");

                }
                else if(theInputText.equalsIgnoreCase("n"))
                    text.appendText("You chose to leave the " + strayItemFound.getItemName() + "\n");

                else
                    text.appendText("Unrecognized command" + "\n");


            });

        } else if (player.getCurrentLoc().getID().equals("START") && player.getHealth() < 100) { //home

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            text.appendText("\n" + "Would you like to rest? (Y/N)" + "\n");

            Platform.runLater(() -> inputText.requestFocus());
            inputText.setOnAction(e ->
            {
                String choice = inputText.getText();
                inputText.deleteText(0, inputText.getLength());
                if (choice.equalsIgnoreCase("y") && player.getHealth() < 100) {
                    player.setHealth(100.0);
                    playSound("/sound/heal.mp3");
                    updatePlayerInfo();
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


        } else if (player.getCurrentLoc().getID().equals("STORE") ) { //doStore

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            doShop();

        } else if (player.getCurrentLoc().getID().equals("END")) { //end

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            ArrayList<Monster> monsters = player.getCurrentLoc().getMonsters();

            Monster randomMob = monsters.get(random_int(0, monsters.size()));


            //doEndBossBattle((Boss) randomMob);


        } else if (player.getCurrentLoc().getID().equals("FINALE"))
        {
            player.setHealth(100);
            //player.setLevel(999);
            imagePane.setImage(player.getCurrentLoc().getImage());
            ArrayList<Monster> monsters = player.getCurrentLoc().getMonsters();

            Monster randomMob = monsters.get(random_int(0, monsters.size()));


            doBossBattle((Boss) randomMob);


        } else if (player.getCurrentLoc().getID().equals("ALTAR")) { //SPECIAL Alter

            player.addXP(100);

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());
            if (player.containsItem("Mysterious Rune")) {

                text.appendText("The Mysterious Rune is resonating, something is drawing it toward the altar!" + "\n");
                text.appendText("\nPlace the Mysterious Rune on the altar? (Y/N)" + "\n");

                Platform.runLater(() -> inputText.requestFocus());
                inputText.setOnAction(e ->
                {
                    String choice = inputText.getText();
                    inputText.deleteText(0, inputText.getLength());
                    if (choice.equalsIgnoreCase("y"))
                        this.setNewLocation("END");

                    else if(choice.equalsIgnoreCase("n"))
                        text.appendText("You chose not to place the Mysterious Rune on the altar" + "\n");

                    else
                        text.appendText("Unrecognized command" + "\n");


                });
            }

        } else { //spacer location

            text.setText("You are now in " + player.getCurrentLoc().getName() + "\n" + player.getCurrentLoc().getDescription() + "\n");
            imagePane.setImage(player.getCurrentLoc().getImage());

        }

    }



    /**
     * Makes a move based on user input - checks locations
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
                            setNewLocation(player.getCurrentLoc().getConnectedLoc(move)); //there is no problem, move to location}
                            break;

                        } else { //location is locked
                            boolean found = false;
                            for (int j = 0; j < player.getInventory().size(); j++) { //check for key
                                if (player.getInventory().get(j).getItemName().equalsIgnoreCase(allLocations.get(i).getKeyItemUnlock())) { //has Key?
                                    //System.out.println("found"); //DEBUG

                                    if (player.getInventory().get(j).getItemName().equalsIgnoreCase("King's Key")) {
                                        player.getInventory().remove(player.getInventory().get(j)); //remove the key item
                                        text.appendText("\nThe key item to unlock this area has been removed. You have unlocked new locations. \n");

                                        for (int k = 0; k < allLocations.size();  i++) {
                                            found = true;

                                            if (allLocations.get(k).getID().equalsIgnoreCase("CHAMBER"))
                                                allLocations.get(k).unlock();

                                            if (allLocations.get(k).getID().equalsIgnoreCase("ALTAR"))
                                                allLocations.get(k).unlock();

                                        }

                                        break;

                                    } else {
                                        allLocations.get(i).unlock(); //unlock the location.
                                        found = true;
                                        this.setNewLocation(allLocations.get(i).getID()); //user has key to unlock area.
                                        break;

                                    }
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



    public void updatePlayerInfo() {
        playerInfo.setText("Lv. " + player.getLevel() + " " + player.getPlayerName()  + "\n" + "Health: " + player.getHealth() + "\n" + "Wallet: $" + player.getWallet() + "\n" + "Weapon: " + player.getWeapon().getItemName() + "\n" + "XP: " + player.getXp() + "\n");

    }


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


    /**
     * Starts playing the url media
     * @param url the media to be played
     */
    private void playMedia(String url) {
        mPlayer = new MediaPlayer(new Media(getClass().getResource(url).toString()));

        mPlayer.isAutoPlay();
        mPlayer.play();
        if(player.getCurrentLoc().getID().equals("GRAVEYARD"))
        {
            mPlayer.setVolume(0.5);
        }
        mPlayer.setCycleCount(INDEFINITE);

    }


    /**
     * Stops the current media
     */
    private void stopMedia() { mPlayer.stop(); }

    private void playBattleMusic()
    {
        if(player.getCurrentLoc().getID().equalsIgnoreCase("FOREST"))
        {
            playMedia("/music/forestbattle.mp3");

        }
        else if(player.getCurrentLoc().getID().equalsIgnoreCase("GRAVEYARD"))
        {
            playMedia("/music/graveyard.mp3");
        }

    }


    /**
     * Plays the boss's music choice
     * @param boss Boss's music to be played
     */
    private void playBossMusic(Boss boss) {

        if (boss.getName().equalsIgnoreCase("GOD") && player.getCurrentLoc().getID().equalsIgnoreCase("END")) {
            playSound("/sound/laugh.mp3");
            playMedia("/music/god.mp3");

        } else if (boss.getName().equalsIgnoreCase("Argoth") && player.getCurrentLoc().getID().equalsIgnoreCase("EASTTOWER"))
                playMedia("/music/xgongiveittoya.mp3");

        else if (boss.getName().equalsIgnoreCase("Vengeful Spirit") && player.getCurrentLoc().getID().equalsIgnoreCase("TREE"))
                playMedia("/music/ghostgirlfight.mp3");

        else if (boss.getName().equalsIgnoreCase("Dagon") && player.getCurrentLoc().getID().equalsIgnoreCase("REEF"))
                playMedia("/music/riseofthelord.mp3");

        else if (boss.getName().equalsIgnoreCase("Wyvern") && player.getCurrentLoc().getID().equalsIgnoreCase("TWINPEAK"))
            playMedia("/music/goldensun.mp3");

        else if (boss.getName().equalsIgnoreCase("Forest Spirit") && player.getCurrentLoc().getID().equalsIgnoreCase("GROTTO"))
                playMedia("/music/greenforest.mp3");

        else if (boss.getName().equalsIgnoreCase("Alrothia") && player.getCurrentLoc().getID().equalsIgnoreCase("WESTTOWER"))
            playMedia("/music/alrothiabattle.mp3");

        else if (boss.getName().equalsIgnoreCase("Princess Amelia") && player.getCurrentLoc().getID().equalsIgnoreCase("SANCTUM"))
            playMedia("/music/bossbattle4.mp3");

        else if (boss.getName().equalsIgnoreCase("King Arthur") && player.getCurrentLoc().getID().equalsIgnoreCase("THRONE"))
            playMedia("/music/epicdrama.mp3");

    }


    /**
     * Plays the sound at the url
     * @param url sound to be played
     */
    private void playSound(String url) {
        sPlayer = new MediaPlayer(new Media(getClass().getResource(url).toString()));

        sPlayer.isAutoPlay();
        sPlayer.setVolume(2.0);
        sPlayer.play();
        sPlayer.setCycleCount(1);

    }


    /**
     * Stops all playing sounds
     */
    private void stopSound() { sPlayer.stop(); }


    /**
     * Get array AllLocs
     * @return AllLocs
     */
    public ArrayList<Location> getAllLocations() { return allLocations; }


        //endregion


        //region FXML Buttons


    /**
     * FXML
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

            Platform.runLater(() -> inputText.requestFocus());
            invInputText.setOnAction(event2 ->
            {
                String command = invInputText.getText();
                invInputText.deleteText(0, invInputText.getLength());
                boolean found = false;

                for (int i = 0; i < player.getInventory().size(); i++) {
                    //System.out.println(player.getInventory().get(i).getItemName()); //DEBUG
                    if (command.equalsIgnoreCase(player.getInventory().get(i).getItemName())) {
                        found = true;
                        //System.out.print("here"); //DEBUG
                        if (player.getInventory().get(i) instanceof Weapon) {
                            player.equipWeapon((Weapon) player.getInventory().get(i));
                            updatePlayerInfo();
                            playSound("/sound/equip.mp3");
                            invText.appendText("\n" + player.getInventory().get(i).getItemName() + " has been equipped.");
                            break;

                        } else if (player.getInventory().get(i) instanceof Armor) {
                            player.equipArmor((Armor) player.getInventory().get(i));
                            playSound("/sound/equip.mp3");
                            invText.appendText("\n" + player.getInventory().get(i).getItemName() + " has been equipped.");
                            break;

                        } else if (player.getInventory().get(i) instanceof KeyItem && player.getInventory().get(i).getItemName().equalsIgnoreCase("Eye Rune")) { //Eye Rune special case
                            invText.appendText("\nYour insight level: " + player.getInsight() + "\n");
                            break;

                        } else if(player.getInventory().get(i).getItemName().equalsIgnoreCase("Region Map")) { //Region Map special case
                            /*
                            if (mapActive) {
                                mapActive = true;
                                mapPane.setVisible(true);

                            } else {

                                mapActive = false;
                                mapPane.setVisible(false);
                            }
                            */
                            break;

                        } else {
                            invText.appendText("\n" + player.getInventory().get(i).toString());
                            break;

                        }
                    } //end large if

                } //end for
                if (!found)
                    invText.appendText("\nItem not recognized" + "\n");


            }); //end inputText loop

        }

    }


        //endregion


}
