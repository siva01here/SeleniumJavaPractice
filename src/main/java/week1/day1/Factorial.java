package week1.day1;

public class Factorial {
	public static void main(String[] args) {
		int factorialToFind=4;
		double fact=1;
		
		for(int i=factorialToFind;i>0;i--)
		{
			fact=fact*i;
		}
		
		System.out.println(fact);
	}

}
