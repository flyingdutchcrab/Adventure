package Classwork.Arrays;

/*
* Author: Andrew Brook
* Class: AP Computer Science P5
* Teacher: Mr. Drugan
* Date: March 11, 2015
*/
import java.io.*;
import java.util.*;

public class ArrayListSort
{
    private List<Integer> intList = new ArrayList<>();


    public ArrayListSort(String filename) {
        fillList(filename);
    }


    public void fillList(String fileName)
    {
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
    } //end fillList


    public void insert(int element) {
        if (!intList.contains(element)) {

            for (int i = 0; i <= intList.size(); i++) {

                if (i == intList.size() || element < intList.get(i)) {
                    //if i equals the size, add it to the end of the list
                    //if the element is less than the index, run again
                    intList.add(i, element);
                    break;
                }

            }
        }
    } //end insert

    static public int binarySearch(List<Integer> aList, int target )
    {
        int left = 0, right = aList.size() - 1, middle;
        int k = -1;

        while (left <= right)
        {
            middle = (left + right) / 2;
            if (target > aList.get(middle))
                left = middle + 1;
            else if (target < aList.get(middle))
                right = middle - 1;
            else
            {
                k = middle;
                break;
            }
        }
        return k;
    }


    public void printList()
    {
        int count = 0;
        for (Integer num: intList) {
            System.out.println(count + ": " + num);
            count++;
        }
    }

    public List<Integer> getIntList() {
        return intList;
    }
} //end class