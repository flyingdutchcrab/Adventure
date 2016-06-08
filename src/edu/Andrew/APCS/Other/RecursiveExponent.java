package edu.Andrew.APCS.Other;

/**
 * Created by andrewbrook on 3/30/16.
 */
public class RecursiveExponent
{
    public static void main(String args[])
    {
        System.out.println(myExponent(10, 3));
        System.out.println(myExponent(2, 4));
        System.out.println(myExponent(3, 1));
        System.out.println(myExponent(5, 0));


    }

    public static int myExponent(int num, int power)
    {
        /* Preconditions:
         * Postconditions:
         */
        if (power == 1)
            return num;
        else if (power == 0)
        {
            return 1;
        }

        else if (power > -1)
            power--;

        return num * (myExponent(num, power));



    }


}
