package week1.day2;

import java.util.Arrays;

public class FindSecondLargestNumber {
	
	public static void main(String[] args) {
		FindSecondLargestNumber objFindNum= new FindSecondLargestNumber();
		int[] arr= {1,3,2,11,4,6,7,9};
		
		Arrays.sort(arr);
		int largestNum=arr[arr.length-1];
		int len=arr.length-1;
		while(arr[len]==largestNum)
		{
			len--;
		}
		
		System.out.println("Second largest element in the array is : "+arr[len]);
		objFindNum.findSecondLargestNumber(arr);
	}
	
	//Method 2
	public void findSecondLargestNumber(int[] arr1)
	{
		int firstMax=Integer.MIN_VALUE, secondMax=Integer.MIN_VALUE;
		for(int i=0;i<arr1.length;i++)
		{
			if(arr1[i]>firstMax)
			{
				firstMax=arr1[i];
			}
		}
		
		for(int j=0;j<arr1.length;j++)
		{
			if(arr1[j]!=firstMax)
			{
				secondMax=Math.min(firstMax, arr1[j]);
			}
		}
		
		System.out.println("Second largest element in the array is : "+secondMax);
	}

}
