package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_LeafGroundDrop {

	public static void main(String[] args) {
		String url="http://www.leafground.com/pages/drop.html";
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver();

		//Maximize the browser
		chDriver.manage().window().maximize();

		//Launch the page
		chDriver.get(url);

		//Drag and the drop the web element by source and target
		WebElement sourceEle= chDriver.findElement(By.id("draggable"));
		WebElement targetEle= chDriver.findElement(By.id("droppable"));
		

		//Create an instance of actions class to drag and drop
		Actions objAction= new Actions(chDriver);
		objAction.moveToElement(sourceEle).clickAndHold().dragAndDrop(sourceEle,targetEle).build().perform();
		
		//Drop confirmation text
		System.out.println(chDriver.findElement(By.xpath("//div[@id='droppable']//child::p")).getText());
		
		//close the browser
		chDriver.close();
	}

}
