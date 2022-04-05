package week3.day1;

public class Desktop extends Computer {
	
	//Method to print the size of the desktop
	public void desktopSize()
	{
		System.out.println("This will print the size of the desktop from Desktop class");
	}
	
	
	public static void main(String[] args) {
		Desktop objDesktop= new Desktop();
		
		//Call the computer model method from parent class
		objDesktop.computerModel();
		
		//Call the desktop model method from same class
		objDesktop.desktopSize();
	}
	

}
