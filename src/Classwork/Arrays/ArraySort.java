package Classwork.Arrays;

/**
 * Created by andrewbrook on 3/23/16.
 */
import java.io.*;
import java.util.*;
public class ArraySort
{
    private int[] array;

    public ArraySort(String filename)
    {
        fillArray(filename);
    }


    public void fillArray(String fileName)
    {

        array = new int[1];
        File file = new File(fileName);
        try
        {
            Scanner inputFile = new Scanner(file);
            System.out.print("File size: " + inputFile.nextInt());
            while (inputFile.hasNext())
            {

                //System.out.println(inputFile.nextInt());

                insert(inputFile.nextInt());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");

        }
    } //end fillArray


    public void insert(int element)
    {
        int[] temp = new int[array.length + 1];
        int insertIndex = 0;

        temp = array;

        if (binarySearch(element) >= 0)
            System.out.print("This item is already in the array.");
        else
        {
            for (int i = 0; i <= array.length; i++)
            {
                //System.out.print("loop"); //DEBUG
                if (i == array.length || element < array[i])
                {
                    //System.out.print("if"); //DEBUG

                    insertIndex = i;
                    break;
                }
            }

            for (int i = temp.length -1; i > insertIndex ; i--)
            {
                temp[i] = temp[i-1];
            }

            temp[insertIndex] = element;

        }

        array = temp;

    }



        public int binarySearch(int target )
        {
            int left = 0, right = array.length - 1, middle;
            int k = -1;

            while (left <= right)
            {
                middle = (left + right) / 2;
                if (target > array[middle])
                    left = middle + 1;
                else if (target < array[middle])
                    right = middle - 1;
                else
                {
                    k = middle;
                    break;
                }
            }
            return k;
        }


    public void printArray()
    {
        System.out.print("\n");
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(i + ": " + array[i]);
        }
    }


} //end class
