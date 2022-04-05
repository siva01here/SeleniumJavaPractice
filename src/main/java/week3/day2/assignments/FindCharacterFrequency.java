package week3.day2.assignments;

public class FindCharacterFrequency {
	
	public static void main(String[] args) {
		System.out.println(findCharFrequency("hello world",'l'));
		System.out.println(findCharFrequency("hello world",'L'));
	}
	
	public static int findCharFrequency(String str, char ch)
	{
		int chrFrequency=0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==ch)
			{
				chrFrequency++;
			}
		}
		
		return chrFrequency;
	}

}
