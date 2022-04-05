package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesInString {
	
	public static void main(String[] args) {
		String str="PayPal India";
		removeDuplicates(str);
		removeDuplicatesUsingSet(str);
	}
	
	//method 1 without using any collection
	public static void removeDuplicates(String str)
	{
		//create a new empty string
		String result="";
		
		//Iterate thru the string and add to new string only if it is a unique char in the new string
		for(int i=0;i<str.length();i++)
		{
			if(!result.contains((str.charAt(i)+"")))
			{
				result+=str.charAt(i);
			}
		}
		System.out.println("String after removing duplicates is : "+result);
	}
	
	
	//method 2 using collection
	public static void removeDuplicatesUsingSet(String str)
	{
		//Create a linked hash set to hold the insertion order
		Set<Character> uniqueCharsSet= new LinkedHashSet<Character>();
		//Convert the given to char array
		char[] chrArr= str.toCharArray();
		
		//Iterate thru the array and add to linkedHashSet
		for(char ch: chrArr)
		{
			uniqueCharsSet.add(ch);
		}
		
		//print the unique chars in set
		System.out.print("String after removing duplicates is : ");
		for(Character temp: uniqueCharsSet)
		{
			System.out.print(temp);
		}
		
		System.out.println();
		
		//Create a new Tree set to sort the unique chars 
		Set<Character> sortedUniqueCharsSet= new TreeSet<Character>();
		sortedUniqueCharsSet.addAll(uniqueCharsSet);
		
		System.out.print("String after removing duplicates and sorted is : ");
		for(Character sCh: sortedUniqueCharsSet)
		{
			System.out.print(sCh);
		}
		System.out.println();
	}

}
