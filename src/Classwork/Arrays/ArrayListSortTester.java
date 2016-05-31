package Classwork.Arrays;

/**
 * Created by andrewbrook on 3/17/16.
 */
import java.util.*;

public class ArrayListSortTester
{
    public static void main(String[] args)
    {

        ArrayListSort numbers = new ArrayListSort("Numbers.txt");
        Scanner keyboard = new Scanner(System.in);
        //numbers.fillList("Numbers.txt");
        numbers.printList();
        String again;
        do
        {
            System.out.println("Please enter a target number");
            int target = keyboard.nextInt();
            int loc = numbers.binarySearch(numbers.getIntList(), target);
            if ( loc == -1 )
                System.out.println("Target " + target + " not found in List");
            else
                System.out.println("Target: " + target + " is at location " + loc);
            System.out.println("Would you like to enter another target number?");
            again = keyboard.next();


        } while (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("yes"));


        //Scanner read = new Scanner(numbers);
        //List arrayList = new ArrayList<Integer>();


    }

}
