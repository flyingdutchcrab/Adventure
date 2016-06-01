package Classwork.FinalExamProject.Testers;

import Classwork.FinalExamProject.*;


/**
 * Created by andrewbrook on 5/13/16.
 */
import Classwork.FinalExamProject.Item;
import Classwork.FinalExamProject.KeyItem;
import Classwork.FinalExamProject.Weapon;

import java.util.*;
public class ItemTester {
    public static void main(String args[])
    {
        Item medkit = new Item("Med-Kit", 25.0);
        Item sword = new Weapon("Iron Sword", 100.0, 50.0);
        Item key = new KeyItem("Gate Key", 300.0, "Opens the gate to the castle");

        System.out.println(medkit.toString());
        System.out.println(sword.toString());
        System.out.println(key.toString());

    } //end main
} //end ItemTester
