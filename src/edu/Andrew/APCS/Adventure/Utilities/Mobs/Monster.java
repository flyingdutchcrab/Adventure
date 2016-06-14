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
    private double startHealth;
    private double damage;
    private boolean alive;
    private double loot;
    private Image image;


    public Monster()
    {
        this.mobName = "";
        this.health = this.startHealth = -1.0;
        this.level = -1; //was never generated
        this.xp = -1;    //was never generated
        this.damage = -1.0;
        this.alive = false;
        this.loot = -1.0;
        this.image = null;

    }


    public Monster(String mobName, double health, int maxLvl, int minLvl, int maxXp, int minXp, double damage, double loot, boolean isAlive, Image img) {

        this.mobName = mobName;
        this.health = this.startHealth = health;
        this.damage = damage;
        this.loot = loot;
        this.alive = isAlive;
        this.image = img;
        this.level = random_int(minLvl, maxLvl);
        this.xp = random_int(minXp, maxXp);

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

    public boolean isAlive() { checkLife(); return this.alive; }

    public String getName() { return this.mobName; }

    public double getLoot() { return this.loot; }

    public Image getImage() { return this.image; }

    public int getLevel() { return this.level; }

    public int getXp() { return this.xp; }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getStartHealth() {
        return startHealth;
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
