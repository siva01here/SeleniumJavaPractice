package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		MyCalculator objCalculator = new MyCalculator();
		
		System.out.println("Sum is : "+objCalculator.addition(15,25,30));
		System.out.println("Difference is : "+objCalculator.subtraction(11,12));
		System.out.println("Product is : "+objCalculator.multiply(12,0.2));
		System.out.println("Divided Result is : "+objCalculator.division(15,5));

	}
	
	//Addition method with three parameters
	public int addition(int num1, int num2, int num3)
	{
		return (num1+num2+num3);
	}
	
	//Subtraction method with two parameters
	public int subtraction(int num1, int num2)
	{
		return (num1-num2);
	}
	
	//Multiply method with two parameters
	public double multiply(double num1, double num2)
	{
		return (num1*num2);
	}
	
	//Division method with two float parameters
	public float division(float num1, float num2)
	{
		if(num2!=0)
		{
			return (num1/num2);
		}
		else
		{
			return 0.0f;
		}
	}
	
	

}
