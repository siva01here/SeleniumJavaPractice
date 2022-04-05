package week3.day1;

public class ClassRoom_SmartPhone extends ClassRoom_AndroidPhone {
	//method to connect whatsapp app
	public void connectWhatsApp()
	{
		System.out.println("Connect whatsapp method from smart phone class");
	}
	
	public static void main(String[] args) {
		ClassRoom_SmartPhone objSmartPhone= new ClassRoom_SmartPhone();
		//execute Mobile class (grandparent) methods multi level inheritance
		objSmartPhone.sendMessage();
		objSmartPhone.makeCall();
		objSmartPhone.saveContacts();
		
		//execute Android phone methods(parent class)
		objSmartPhone.takeVideo();
		
		//execute same class (SmartPhone class) methods
		objSmartPhone.connectWhatsApp();
		
	}

}
