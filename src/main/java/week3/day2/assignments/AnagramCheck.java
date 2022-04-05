package week3.day2.assignments;

import java.util.Arrays;

public class AnagramCheck {
	
	public static void main(String[] args) {
		System.out.println("Are silent and listen anagarams : "+checkAnagram("silent","listen"));
		System.out.println("Are stops and listen posts : "+checkAnagram("stops","posts"));
		System.out.println("Are buy and listen by : "+checkAnagram("buy","by"));
		System.out.println("Are fast and listen star : "+checkAnagram("fast","star"));
		
	}
	
	public static boolean checkAnagram(String str1, String str2)
	{
		if(!(str1.length()==str2.length()))
		{
			return false;
		}
		
		else
		{
			char[] chrArr1=str1.toCharArray();
			char[] chrArr2=str2.toCharArray();
			
			Arrays.sort(chrArr1);
			Arrays.sort(chrArr2);
			
			boolean result=true;
			for(int i=0;i<chrArr1.length;i++)
			{
				if(chrArr1[i]!=chrArr2[i])
				{
					result=false;
					break;
				}
			}
			
			return result;
		}
	}
	
	

}
