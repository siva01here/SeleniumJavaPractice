package week3.day2;

public class DesktopModels implements Hardware, Software{

	@Override
	public void softwareResources() {
		System.out.println("Software resources method from Software interface");
	}

	@Override
	public void hardwareResources() {
		System.out.println("Hardware resources method from Hardware interface");
	}
	
	public static void main(String[] args) {
		DesktopModels objDeskModels= new DesktopModels();
		//Call hardware resources method
		objDeskModels.hardwareResources();
		
		//Call software resources method
		objDeskModels.softwareResources();
	}

}
