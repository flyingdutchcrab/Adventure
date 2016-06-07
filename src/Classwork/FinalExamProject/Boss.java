package Classwork.FinalExamProject;

import javafx.scene.image.Image;

/**
 * Created by andrewbrook on 6/7/16.
 */
public class Boss extends Monster
{
    private int bossLvl;
    private int bossXp;

    public Boss(String mobName, double health, double damage, double loot, boolean isAlive, Image img, int bLvl, int bXp)
    {
        super();
        this.bossLvl = bLvl;
        this.bossXp = bXp;
    }

    public int getBossLvl()
    {
        return this.bossLvl;
    }

    public int getBossXp()
    {
        return this.bossXp;
    }

    public String toString()
    {
        return "Boss: " + super.getName() + " | " + "Lvl: " + getBossLvl() + " | " + "HP: " + super.getHealth() + " | " + "Damage: " + super.getDamage() + " | " + "Loot: " + super.getLoot() + "\n";
    }
}
