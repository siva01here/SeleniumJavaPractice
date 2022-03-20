package week1.day1;

public class Mobile {
	String mobileModelName="Samsung";
	char mobileSeries='A';
	int launchYear=2022;
	float mobileWeight=200.99f;
	double mobilePrice =15999.95;
	boolean supportMemoryCard= true;
	boolean isFullyCharged=false;
	
	public void makeCall()
	{
		System.out.println("Make call method");
	}
	
	public void sendMessage()
	{
		System.out.println("Send Message method");
	}
	
	public static void main(String[] args)
	{
		System.out.println("In main method");
		Mobile objMobile= new Mobile();
		objMobile.makeCall();
		objMobile.sendMessage();
		
		//printing global variables
		System.out.println("Model Name : "+objMobile.mobileModelName);
		System.out.println("Model Series : "+objMobile.mobileSeries);
		System.out.println("Model Launched In : "+objMobile.launchYear);
		System.out.println("Weight In Grams : "+objMobile.mobileWeight);
		System.out.println("Mobile Price : "+objMobile.mobilePrice);
		System.out.println("Fully Charged : "+objMobile.isFullyCharged);
		System.out.println("Supports Extendable Memeory : "+objMobile.supportMemoryCard);
	}

}
