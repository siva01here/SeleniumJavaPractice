package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_LeafGroundDrag {

	public static void main(String[] args) {
		String url="http://www.leafground.com/pages/drag.html";
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver();

		//Maximize the browser
		chDriver.manage().window().maximize();

		//Launch the page
		chDriver.get(url);

		//Drag and the drop the web element by offset
		Dimension objDim= chDriver.findElement(By.id("draggable")).getSize();
		int height=objDim.getHeight();
		int width= objDim.getWidth();
		

		//Create an instance of actions class to drag and drop
		Actions objAction= new Actions(chDriver);
		objAction.moveToElement(chDriver.findElement(By.id("draggable"))).clickAndHold().moveByOffset((height+10),(width+10)).release().build().perform();
		
		//close the browser
		chDriver.close();

	}

}
