package week3.day2.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindIntersection {
	
	public static void main(String[] args) {
		int[] arr1= {1,2,3,4,5,7};
		int[] arr2= {7,5,3,4,1};
		findIntersection1(arr1,arr2);
		findIntersection2(arr1,arr2);
		findIntersection3(arr1,arr2);
	}
	
	//method 1 using list alone
	public static void findIntersection1(int[] arr1, int[] arr2)
	{
		//Declare two lists to hold the numbers
		List<Integer> numberList1= new ArrayList<Integer>();
		
		//Add the numbers in array1 in list1
		for(int i: arr1)
		{
			numberList1.add(i);
		}
		
		System.out.println("Intersecting numbers are : ");
		//Use contains method in list to verify whether that numbers in array2 exists in list or not
		for(int j: arr2)
		{
			if(numberList1.contains(j))
			{
				System.out.print(j+" ");
			}
		}
		System.out.println();
	}
	
	//method 2 using set
	public static void findIntersection2(int[] arr1, int[] arr2)
	{
		//Declare two sets to hold the numbers from arr1 & arr2
		Set<Integer> numbersSet1= new HashSet<Integer>();
		
		//add the numbers from array 1 to set
		for(int i: arr1)
		{
			numbersSet1.add(i);
		}
		System.out.println("Intersecting numbers are : ");
		//add the numbers from array 2 to set if it gives false when adding thats an intersecting number
		for(int j: arr2)
		{
			if(!numbersSet1.add(j))
			{
				System.out.print(j+" ");
			}
		}
		System.out.println();
	}
	
	//method 3 using two sets
	public static void findIntersection3(int[] arr1, int[] arr2)
	{
		//Declare two sets to hold the numbers from both arrays
		Set<Integer> numbersSet1= new HashSet<Integer>();
		Set<Integer> numbersSet2= new HashSet<Integer>();
		
		//add all numbers from array1 to set1
		for(int i: arr1)
		{
			numbersSet1.add(i);
		}
		
		//add all numbers from array2 to set2
		for(int j: arr2)
		{
			numbersSet2.add(j);
		}
		
		//Use retainAll method to get the common numbers between two sets
		numbersSet1.retainAll(numbersSet2);
		
		//print the intersecting numbers
		System.out.println(numbersSet1);
	}

}
