package week1.day1;

public class PrimeNumberCheck {
	public static void main(String[] args) {
		int number=37;
		boolean flag=false;
		
		if(number==0 || number==1)
		{
			flag=true;
		}
		else
		{
			for(int i=2;i<number/2;i++)
			{
				if(number%i==0)
				{
					flag=true;
					break;
				}
			}
		}
		
		
		if(!flag)
		{
			System.out.println("Given Number is a Prime Number");
		}
		else
		{
			System.out.println("Given Number is not a Prime Number");
		}
	}

}
