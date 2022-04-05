package week3.day1;

public class AxisBank extends BankInfo {
	
	
	//method to get deposit details
	public void deposit()
	{
		System.out.println("Deposit can be done by online banking and thru bank in person");
	}
	
	public static void main(String[] args) {
		BankInfo objBankInfo= new BankInfo();
		AxisBank objAxisBank= new AxisBank();		
		
		//Call the overriden deposit method from parent class
		objBankInfo.deposit();
		
		//Call the overriding deposit method from child class
		objAxisBank.deposit();
		
		
	}

}
