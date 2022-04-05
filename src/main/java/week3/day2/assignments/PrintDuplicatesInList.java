package week3.day2.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintDuplicatesInList {
	public static void main(String[] args) {
		List<Integer> numberList= new ArrayList<Integer>();
		
		for(int i=0;i<=10;i++)
		{
			if(i==4)
				numberList.add(3);
			else if(i==6)
				numberList.add(5);
			numberList.add(i);
		}
		printDuplicates(numberList);
	}
	
	//method to print duplicates in the list
	public static void printDuplicates(List<Integer> list)
	{
		//Declare a set to add the numbers from list
		Set<Integer> numberSet= new HashSet<Integer>();
		
		System.out.println("Duplicate element in the list is : ");
		//Iterate thru the list, add them into the set, if it returns false when adding then those are duplicates
		for(int i: list)
		{
			if(!numberSet.add(i))
			{
				System.out.println(i+" ");
			}
		}
	}

}
