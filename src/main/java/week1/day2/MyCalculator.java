package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		Calculator objCalculator = new Calculator();
		
		System.out.println("Sum is : "+objCalculator.add(15,25));
		System.out.println("Difference is : "+objCalculator.subtract(11.99,1.25));
		System.out.println("Product is : "+objCalculator.multiply(12,0.2));
		System.out.println("Divided Result is : "+objCalculator.divide(15,0));

	}

}
