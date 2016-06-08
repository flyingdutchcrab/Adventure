package edu.Andrew.APCS.Other;

/**
 * Created by andrewbrook on 3/31/16.
 */
public class SelectionSort
{
    public static void sort(double array[])
    {
        int iMax;
        double aTemp;

        for (int n = array.length; n >= 2; n--)
        {
            iMax = 0;
            for (int i = 1; i < n; i++)
            {
                if (array[i] > array[iMax])
                {
                    iMax = i;
                }
            }

            aTemp = array[iMax];
            array[iMax] = array[n-1];
            array[n-1] = aTemp;
        }

        System.out.println("\nSorted\n-----------------------------\n");


        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Index " + i + ": " + array[i]);
        }
    }

} //end class
