package week4.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_LeafGroundSelectable {

	public static void main(String[] args) {
		String url="http://www.leafground.com/pages/selectable.html";
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver();

		//Maximize the browser
		chDriver.manage().window().maximize();

		//Launch the page
		chDriver.get(url);

		//Get the selectable webelement
		List<WebElement> selectableList= chDriver.findElements(By.xpath("//ol//child::li"));

		//Create an instance of actions class
		Actions objAction= new Actions(chDriver);


		//Select all elements
		for(WebElement ele: selectableList)
		{
			objAction.moveToElement(ele).clickAndHold();
		}

		objAction.release().build().perform();
		
		//close the browser
		chDriver.close();
	}

}
