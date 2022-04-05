package week3.day2.assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords {
	
	public static void main(String[] args) {
		String text="We learn java basics as part of java session in java week1";
		removeDuplicateWordsUsingSet(text);
	}
	
	//using set
	public static void removeDuplicateWordsUsingSet(String str)
	{
		//split the given string based on the space in it
		String[] strArr= str.split("\\s");
		
		//Create a linkedhashset to hold the words in string in its order and without duplicates
		Set<String> wordsSet= new LinkedHashSet<String>();
		
		for(String tempStr1: strArr)
		{
			wordsSet.add(tempStr1);
		}
		
		System.out.println("Given string after removing duplicates is : ");
		//Iterate thru the unique words in set and print them
		for(String tempStr2: wordsSet)
		{
			System.out.print(tempStr2+" ");
		}
	}
	

}
