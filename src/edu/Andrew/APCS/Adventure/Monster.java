package edu.Andrew.APCS.Adventure;

/**
 * Adventure
 *
 * Monster
 *
 * This is mob that the player can attack, has health among other things that the Player and Adventure classes might need.
 */
import javafx.scene.image.Image;

public class Monster
{

    private String mobName;
    private int minLvl;
    private int maxLvl;
    private int minXp;
    private int maxXp;
    private double health;
    private double damage;
    private boolean alive;
    private double loot;
    private Image image;

    public Monster()
    {
        this.mobName = "";
        this.health = -1.0;
        this.minLvl = -1;
        this.maxLvl = 0;
        this.minXp = -1;
        this.maxXp = 0;
        this.damage = -1.0;
        this.alive = false;
        this.loot = -1.0;
        this.image = null;

    }



    public Monster(String mobName, double health, int mxLvl, int mnLvl, int mxXp, int mnXp, double damage, double loot, boolean isAlive, Image img) {

        this.mobName = mobName;
        this.maxLvl = mxLvl;
        this.minLvl = mnLvl;
        this.maxXp = mxXp;
        this.minXp = mnXp;
        this.health = health;
        this.damage = damage;
        this.loot = loot;
        this.alive = isAlive;
        this.image = img;

    }


    /**
     * Kill the Monster
     */
    public void kill() {this.alive = false;}


    /**
     * Checks the life and makes sure that the monster is maked as killed
     *
     * Should be called after each damage is set.
     */
    public void checkLife()
    {
        if (this.health <= 0)
        {
            this.health = 0.0;
            this.alive = false;
        }
    }
    /**
     * getters
     */

    public double getHealth() { return this.health; }

    public void setHealth(double newHealth) { this.health = newHealth; }

    public double getDamage() { return this.damage; }

    public double setDamage(double dmg) {
        this.damage = dmg;
        checkLife();
        return this.damage;
    }

    public boolean isAlive() { return this.alive; }

    public String getName() { return this.mobName; }

    public double getLoot() { return this.loot; }

    public Image getImage() { return this.image; }

    public int getLvl() { return random_int(this.minLvl, this.maxLvl); } /** should only be called once **/

    private int getXp() { return random_int(this.minXp, this.maxXp); } /** should only be called once **/


    /**
     * toString
     * @return toString
     */
    public String toString()
    {
        return "Monster: " + mobName + " | " + "Lvl: " + getLvl() + " | " + "XP: " + getXp() + " | " + "HP: " + health + " | " + "Damage: " + damage + " | " + "Loot: " + loot + "\n";
    }


    /**
     * Generated a radom number
     * @param min smalled number
     * @param max largest number
     * @return a random number in between the range.
     */
    private static int random_int(int min, int max) { return (int) (Math.random()*(max-min))+min; }


}
