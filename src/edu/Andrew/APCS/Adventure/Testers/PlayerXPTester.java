package edu.Andrew.APCS.Adventure.Testers;

import edu.Andrew.APCS.Adventure.Player;

/**
 * Adventure
 *
 * PlayerXPTester
 *
 * Tests the Player's XP system
 */
public class PlayerXPTester {

    public static void main(String[] args) {
        Player player = new Player();

        player.setXp(100);
        System.out.println("100 XP: " + player.getLevel() + " lv");

        player.setXp(98);
        System.out.println("98 XP: " + player.getLevel() + " lv");

        player.setXp(150);
        System.out.println("150 XP: " + player.getLevel() + " lv");


        player.setXp(200);
        System.out.println("200 XP: " + player.getLevel() + " lv");

        player.setXp(300);
        System.out.println("300 XP: " + player.getLevel() + " lv");

        player.setXp(400);
        System.out.println("400 XP: " + player.getLevel() + " lv");

        player.setXp(500);
        System.out.println("500 XP: " + player.getLevel() + " lv");

        player.setXp(600);
        System.out.println("600 XP: " + player.getLevel() + " lv");








    }
}
