package edu.Andrew.APCS.Other;

/**
 * Created by andrewbrook on 3/17/16.
 */
import java.util.*;
import javax.swing.*;

public class HelloWorld
{
    private static int fucks;

    public static void main(String args[])
    {
        List skrubList = new ArrayList<String>();
        JOptionPane.showMessageDialog(null, "Hello world!");
        String name = JOptionPane.showInputDialog(null, "What is your name?");
        fucks = 0;
        JOptionPane.showMessageDialog(null, "Hello Officer " +  name + "! This is how many fucks I give: " + fucks);
    }

    public int getFucks(int fucks)
    {
        return fucks;
    }

    public void setFucks()
    {
        this.fucks = fucks;
    }

} //end class