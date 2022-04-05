package week3.day1;

public class ClassRoom_Calculator_Overloading {
	
	public void addition(int num1, int num2)
	{
		System.out.println("2 Params Addition result is : "+(num1+num2));
	}
	
	public void addition(int num1, int num2, int num3)
	{
		System.out.println("3 Params Addition result is : "+(num1+num2+num3));
	}
	
	
	public void multiply(int num1, int num2)
	{
		System.out.println("Integer only Multiplication result is : "+(num1*num2));
	}
	
	public void multiply(int num1, double num2)
	{
		System.out.println("Integer & Double Value Multiplication result is : "+(num1*num2));
	}
	
	public void subtract(int num1, int num2)
	{
		System.out.println("Integer Subtraction Result is : "+ (num1-num2));
	}
	
	public void subtract(double num1, double num2)
	{
		System.out.println("Double Subtraction Result is : "+ (num1-num2));
	}
	
	public void division(int num1, int num2)
	{
		if(num2!=0)
		{
			System.out.println("Integer Division Result is : "+(num1/num2));
		}
		else
		{
			System.out.println("Divisor is zero please check the input");
		}
	}
	
	public void division(double num1, double num2)
	{
		if(num2!=0)
		{
			System.out.println("Double Division Result is : "+(num1/num2));
		}
		else
		{
			System.out.println("Divisor is zero please check the input");
		}
	}
	
	public static void main(String[] args) {
		ClassRoom_Calculator_Overloading objOverloading= new ClassRoom_Calculator_Overloading();
		
		//2 Params addition
		objOverloading.addition(10, 20);
		
		//3 Params addition
		objOverloading.addition(100,200,55);
		
		//Integer Multiplication
		objOverloading.multiply(5,10);
		
		//Integer & Double Multiplication
		objOverloading.multiply(10, 10.9);
		
		//Integer Subtraction
		objOverloading.subtract(5, 10);
		
		//Double Subtraction
		objOverloading.subtract(10.9999, 0.0001);
		
		//Integer Division
		objOverloading.division(1000, 10);
		
		//Double datatype division
		objOverloading.division(4.9,0.7);
		
		
	}
	
	

}
