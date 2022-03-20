package week1.day2;

public class SumOfDigitsOfANumber {
	public static void main(String[] args) {
		int input=1235, origNum=input;
		int sumOfDigits=0;
		
		while(input!=0)
		{
			sumOfDigits+=(input%10);
			input=input/10;
		}
		System.out.println("Sum of digits of "+origNum+" is "+sumOfDigits);
	}
	

}
