package edu.Andrew.APCS.Other;

/**
 * Created by andrewbrook on 3/31/16.
 */
import java.util.*;
public class SelectionSortTester
{

    public static void main (String args[])
    {

        double[] array = new double[100];

        System.out.println("\nUnsorted\n-----------------------------\n");

        for (int i = 0; i < array.length; i++)
        {
            array[i] = new Random().nextInt(1000);
            System.out.println(array[i]);
        }

        SelectionSort.sort(array);


    } //end main
} //end class
