package week3.day2.assignments;

public class PalindromeCheck {
	
	public static void main(String[] args) {
		String[] inputs= {"madam","Madam","radar","Radar"};
		
		for(String str: inputs)
		{
			if(palindromeCheck(str))
			{
				System.out.println("Given string is a palindrome");
			}
			else
			{
				System.out.println("Given string is not a palindrome");
			}
		}
		
	}
	
	public static boolean palindromeCheck(String str)
	{
		//Initialize an empty string to hold the result
		String revStr="";
		
		//Iterate from last char to first char in string and add it to result string
		for(int i=str.length()-1;i>=0;i--)
		{
			revStr+=str.charAt(i);
		}
		
		return (str.equals(revStr));
	}

}
