package edu.Andrew.APCS.Adventure.Utilities.Mobs;

import javafx.scene.image.Image;

/**
 * Adventure
 *
 * Monster
 *
 * This is mob that the player can attack, has health among other things that the Player and Adventure classes might need.
 */
public class Monster
{

    private String mobName;
    private int level;
    private int xp;
    private double health;
    private double damage;
    private boolean alive;
    private double loot;
    private Image image;


    public Monster()
    {
        this.mobName = "";
        this.health = -1.0;
        this.level = -1; //was never generated
        this.xp = -1;    //was never generated
        this.damage = -1.0;
        this.alive = false;
        this.loot = -1.0;
        this.image = null;

    }


    public Monster(String mobName, double health, int mxLvl, int mnLvl, int mxXp, int mnXp, double damage, double loot, boolean isAlive, Image img) {

        this.mobName = mobName;
        this.health = health;
        this.damage = damage;
        this.loot = loot;
        this.alive = isAlive;
        this.image = img;
        this.level = generateLvl(mnLvl, mxLvl);
        this.xp = generateXp(mnXp, mxXp);

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
     * Randomly generate the level
     *
     * This should only be called once, in the constructor
     *
     * @param minLvl Minimum level
     * @param maxLvl Maximum level
     * @return the random level
     */
    private int generateLvl(int minLvl, int maxLvl) { return random_int(minLvl, maxLvl); } /** should only be called once **/


    /**
     * Randomly generate XP
     *
     * This should only be called once, in the constructor
     *
     * @param minXp Minimum XP
     * @param maxXp Maximum XP
     * @return the random XP
     */
    private int generateXp(int minXp, int maxXp) { return random_int(minXp, maxXp); } /** should only be called once **/


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

    public boolean isAlive() { checkLife(); return this.alive; }

    public String getName() { return this.mobName; }

    public double getLoot() { return this.loot; }

    public Image getImage() { return this.image; }

    public int getLevel() { return this.level; }

    public int getXp() { return this.xp; }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * toString
     * @return toString
     */
    public String toString()
    {
        return "Monster: " + mobName + " | " + "Lvl: " + getLevel() + " | " + "XP: " + getXp() + " | " + "HP: " + health + " | " + "Damage: " + damage + " | " + "Loot: " + loot + "\n";
    }


    /**
     * Generated a radom number
     * @param min smalled number
     * @param max largest number
     * @return a random number in between the range.
     */
    private static int random_int(int min, int max) { return (int) (Math.random()*(max-min))+min; }


}
