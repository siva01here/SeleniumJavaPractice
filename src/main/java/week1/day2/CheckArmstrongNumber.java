package week1.day2;

public class CheckArmstrongNumber {
	
	public static void main(String[] args) {
		int input=123, origNum=input, result=0;
		
		while(input>0)
		{
			int remainder=(input%10);
			result+=Math.pow(remainder, 3);
			input=input/10;
		}
		
		if(result==origNum)
		{
			System.out.println("Given number "+origNum+" is an armstrong number");
		}
		else
		{
			System.out.println("Given number "+origNum+" is not an armstrong number");
		}
	}

}
