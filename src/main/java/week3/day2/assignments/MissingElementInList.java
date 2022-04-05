package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInList {
	
	public static void main(String[] args) {
		List<Integer> numberList1= new ArrayList<Integer>();
		
		for(int i=1;i<=10;i++)
		{
			if(i==8)
				continue;
			numberList1.add(i);
		}
		findMissingNumber(numberList1);
	}
	
	//method to find missing element in list
	public static void findMissingNumber(List<Integer> list)
	{
		//Sort the list of numbers
		Collections.sort(list);
		
		//Store the smallest and range to iterate 
		int min=list.get(0), max=min+(list.size()-1), itr=0;
		
		//iterate thru the list and break if there is not any match
		while(min<=max)
		{
			if(list.get(itr)!=min)
			{
				break;
			}
			itr++;
			min++;
		}
		
		System.out.println("Missing element in the list is : "+min);
	}

}
