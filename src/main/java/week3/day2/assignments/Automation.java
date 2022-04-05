package week3.day2.assignments;

public class Automation extends MultipleLanguage {

	@Override
	public void selenium() {
		System.out.println("Selenium method from Test tool interface");
	}

	@Override
	public void java() {
		System.out.println("Java method from Language interface");
	}

	@Override
	void ruby() {
		System.out.println("Ruby implementation");
	}
	
	public static void main(String[] args) {
		MultipleLanguage objAutomation = new Automation();
		
		//call the methods from interface
		objAutomation.java();
		objAutomation.selenium();
		
		//call the methods from abstract class
		objAutomation.python();
		objAutomation.ruby();
	}
	
	

	

}
