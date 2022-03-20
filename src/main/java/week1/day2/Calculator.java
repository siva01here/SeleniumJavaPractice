package week1.day2;

public class Calculator {
	
	public int add(int num1, int num2)
	{
		return (num1+num2);
	}
	
	public double subtract(double num1, double num2)
	{
		return (num1-num2);
	}
	
	public double multiply(double num1, double num2)
	{
		return (num1*num2);
	}
	
	public int divide(int num1, int num2)
	{
		if(num2!=0)
		{
			return (num1/num2);
		}
		else
		{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Calculator objCalc= new Calculator();
		int sum = objCalc.add(10, 20);
		double difference= objCalc.subtract(10.99, 11.99);
		double product = objCalc.multiply(10,0.5);
		int divisionResult= objCalc.divide(100, 0);
		
		System.out.println("Results are :");
		System.out.println("Sum is : "+sum);
		System.out.println("Difference is : "+difference);
		System.out.println("Product is : "+product);
		System.out.println("Division Result is : "+divisionResult);
	}

}
