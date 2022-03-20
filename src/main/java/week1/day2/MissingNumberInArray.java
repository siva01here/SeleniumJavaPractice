package week1.day2;

import java.util.Arrays;

public class MissingNumberInArray {
	public static void main(String[] args) {
		int[] arr= {11,12,10,14};
		Arrays.sort(arr);
		int lowestNum=arr[0], incr=0;

		while(incr<arr.length && lowestNum==arr[incr])
		{
			incr++;
			lowestNum++;
		}
		
		if(lowestNum<arr[arr.length-1])
		{
			System.out.println(lowestNum);
		}
	
	}
	

}
