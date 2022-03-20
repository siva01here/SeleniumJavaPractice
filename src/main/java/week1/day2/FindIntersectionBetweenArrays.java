package week1.day2;

import java.util.Arrays;

public class FindIntersectionBetweenArrays {
	
	public static void main(String[] args) {
		FindIntersectionBetweenArrays objIntersection = new FindIntersectionBetweenArrays();
		int[] arr1= {3,2,11,4,6,7};
		int[] arr2= {1,2,8,4,9,7};
		
		objIntersection.findIntersecionUsingTwoLoops(arr1, arr2);
		objIntersection.findIntersectionUsingOneLoop(arr1,arr2);
	}
	
	//Method 1
	public void findIntersecionUsingTwoLoops(int[] arr1, int[] arr2)
	{
		System.out.println("Common elements between arrays is : ");
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
				{
					System.out.print(arr1[j]+" ");
				}
			}
		}
		System.out.println();
	}
	
	//Method 2
	public void findIntersectionUsingOneLoop(int[] arr1, int[] arr2)
	{
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int incr1=0, incr2=0;
		
		while(incr1<arr1.length && incr2<arr2.length)
		{
			if(arr1[incr1]==arr2[incr2])
			{
				System.out.print(arr1[incr1]+" ");
				incr1++;
				incr2++;
			}
			
			else if(arr1[incr1]<arr2[incr2])
			{
				incr1++;
			}
			else
			{
				incr2++;
			}
		}
	}

}
