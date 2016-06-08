package edu.Andrew.APCS.Adventure;

import javafx.scene.image.Image;

/**
 * Adventure
 *
 * Boss, extends Monster
 *
 * Boss is a Monster than has more XP and levels.
 */
public class Boss extends Monster
{
    private int bossLevel;
    private int bossXP;

    public Boss(String mobName, double health, int mxLvl, int mnLvl, int mxXp, int mnXp, double damage, double loot, boolean isAlive, Image img, int bossLevel, int bossXP)
    {
        super(mobName, health, mxLvl, mnLvl, mxXp, mnXp, damage, loot, isAlive, img);
        this.bossLevel = bossLevel;
        this.bossXP = bossXP;
    }


    /**
     * Getters
     */

    private int getBossLevel() { return this.bossLevel; }

    public int getBossXP() { return this.bossXP; }


    /**
     * toString
     * @return toString
     */
    public String toString()
    {
        return "Boss: " + super.getName() + " | " + "Lvl: " + getBossLevel() + " | " + "HP: " + super.getHealth() + " | " + "Damage: " + super.getDamage() + " | " + "Loot: " + super.getLoot() + "\n";
    }
}
