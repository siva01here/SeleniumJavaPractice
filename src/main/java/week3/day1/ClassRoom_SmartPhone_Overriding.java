package week3.day1;

public class ClassRoom_SmartPhone_Overriding extends ClassRoom_AndroidPhone{
	

	//method to capture video from smart phone class
	@Override
	public void takeVideo()
	{
		System.out.println("Overridden Take Video method from SmartPhone class");
	}
	
	//method to connect whatsapp app
	public void connectWhatsApp()
	{
		System.out.println("Connect whatsapp method from smart phone class");
	}
	
	public static void main(String[] args) {
		ClassRoom_SmartPhone_Overriding objOverriding = new ClassRoom_SmartPhone_Overriding();
		
		//Same class method
		objOverriding.connectWhatsApp();
		
		//Call Overriding method
		objOverriding.takeVideo();
		
		ClassRoom_AndroidPhone objOverriding1 = new ClassRoom_AndroidPhone();
		
		//Call Overridden method
		objOverriding1.takeVideo();
		
	}

}
