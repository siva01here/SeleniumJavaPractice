package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumber {
	
	public static void main(String[] args) {
		List<Integer> numberList= new ArrayList<Integer>();
		
		for(int i=1;i<=2;i++)
		{
			numberList.add(i);
		}
		
		findSecondLargestNumber(numberList);
	}
	
	//sort the elements and get the second largest
	public static void findSecondLargestNumber(List<Integer> list1)
	{
		if(list1.size()<2)
		{
			System.out.println("Not enough elements in list");
		}
		else
		{
			Collections.sort(list1);
			int max=list1.get(list1.size()-1), itr=list1.size()-1;
			
			while(itr>=0 && list1.get(itr)==max)
			{
				itr--;
			}
			
			if(itr<0)
			{
				System.out.println("There is no second largest element");
			}
			else
			{
				System.out.println("Second largest element in the list is : "+list1.get(itr));
			}
		}
		
		
	}

}
