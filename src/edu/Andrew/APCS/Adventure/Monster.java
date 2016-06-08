package edu.Andrew.APCS.Adventure;

/**
 * Created by andrewbrook on 4/6/16.
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
    public Image image;

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
    //getters and setters

    public double getHealth()
    {
        return this.health;
    }

    public void setHealth(double newHealth)
    {
        this.health = newHealth;
    }

    //gets damage
    public double getDamage()
    {
        return this.damage;
    }

    public double setDamage(double dmg)
    {
        this.damage = dmg;
        return this.damage;
    }

    //if the monster is alive it is alive
    public boolean isAlive()
    {
        return this.alive;
    }

    //if the monster is killed, it is not alive
    public void kill()
    {
        this.alive = false;
    }

    //checks if monster is alive
    public void checkLife()
    {
        if (this.health <= 0)
        {
            this.health = 0.0;
            this.alive = false;
        }
    }

    //access monster name
    public String getName()
    {
        return this.mobName;
    }

    //gets the money you receive from killing enemy
    public double getLoot()
    {
        return this.loot;
    }

    public Image getImage()
    {
        return this.image;
    }

    public int getLvl()
    {
        return random_int(this.minLvl, this.maxLvl);
    }

    public int getXp()
    {
        return random_int(this.minXp, this.maxXp);
    }

    public static int random_int(int min, int max) { return (int) (Math.random()*(max-min))+min; }


    public String toString()
    {
        return "Monster: " + mobName + " | " + "Lvl: " + getLvl() + " | " + "XP: " + getXp() + " | " + "HP: " + health + " | " + "Damage: " + damage + " | " + "Loot: " + loot + "\n";
    }


}
