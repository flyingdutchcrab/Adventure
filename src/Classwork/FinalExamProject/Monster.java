package Classwork.FinalExamProject;

/**
 * Created by andrewbrook on 4/6/16.
 */
import java.util.*;
import javafx.scene.image.Image;
import javafx.fxml.FXML;

public class Monster
{

    private String mobName;
    private double health;
    private double damage;
    private boolean alive;
    private double loot;
    public Image image;



    public Monster(String mobName, double health, double damage, double loot, boolean isAlive, Image img) {

        this.mobName = mobName;
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
}
