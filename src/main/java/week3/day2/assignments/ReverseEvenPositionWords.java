package week3.day2.assignments;

public class ReverseEvenPositionWords {
	
	public static void main(String[] args) {
		String str="I am a Software Tester";
		reverseEvenPositionWords(str);
		
	}
	
	
	public static void reverseEvenPositionWords(String str)
	{
		//Split the words in the given string to array based on space in between them
		String[] strArr= str.split("\\s");
		
		//Iterate thru the words in string array and print the word in even position in reverse order  
		for(int i=0;i<strArr.length;i++)
		{
			//Temporary variable to hold the i value
			int temp=i+1;
			
			//Condition to check the position is even or odd
			if(temp%2==0)
			{
				for(int j=strArr[i].length()-1;j>=0;j--)
				{
					System.out.print(strArr[i].charAt(j));
				}
			}
			
			else
			{
				System.out.print(strArr[i]);
			}
			
			//Add a space in between the words
			if(i<strArr.length-1)
			{
				System.out.print(" ");;
			}
		}
	}

}
