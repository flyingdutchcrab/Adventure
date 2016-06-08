package edu.Andrew.APCS.Other;

/**
 * Created by andrewbrook on 3/30/16.
 */
public class FindtheError
{
    public static void main(String args[])
    {
        myMethod(0);
    }

    public static void myMethod(int num)
    {
        if (num < 10)
        {
            System.out.println(num + " ");
            myMethod(num + 1);
        }
    }
}