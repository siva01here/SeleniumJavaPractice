package week3.day2.assignments;

public class FindCharTypes {
	
	public static void main(String[] args) {
		findCharTypesInStr("Test performed on 03/04/2022");
	}
	
	public static void findCharTypesInStr(String str)
	{
		//Initialize increment variables for each char types to zero
		int alphabetCount=0, numericCount=0, specialCharactersCount=0, spacesCount=0;
		
		//Iterate thru the chars in string and check type of each char in string
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(Character.isAlphabetic(ch))
			{
				alphabetCount++;
			}
			else if(Character.isDigit(ch))
			{
				numericCount++;
			}
			else if(Character.isSpaceChar(ch))
			{
				spacesCount++;
			}
			else
			{
				specialCharactersCount++;
			}
		}
		
		//Print the each types count in string
		System.out.println("Given string has : ");
		System.out.println("Alphabets : "+alphabetCount);
		System.out.println("Numbers : "+numericCount);
		System.out.println("Spaces : "+spacesCount);
		System.out.println("Special Characters : "+specialCharactersCount);
	}

}
