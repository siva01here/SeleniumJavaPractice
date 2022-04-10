package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom_MultiSelect {
	
public static void main(String[] args) {
		
		String pageURL="http://leafground.com/pages/Dropdown.html";
		
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver = new ChromeDriver();
		
		//Create an instance of Actions class
		Actions objAction = new Actions(chDriver);
		
		//Maximize the browser
		chDriver.manage().window().maximize();
		
		//Load the URL
		chDriver.get(pageURL);
		
		//Locate the multi select drop down
		List<WebElement> dropdownOptionsList=chDriver.findElements(By.xpath("//option[text()='Select your programs']//following-sibling::option"));
		
		//Multi select drop down options using actions class
		//Selenium and load runner
		
		for(WebElement ele: dropdownOptionsList)
		{
			if(ele.getText().equals("Selenium") || ele.getText().equals("Loadrunner"))
			{
				objAction
				.keyDown(Keys.CONTROL)
				.click(ele)
				.keyUp(Keys.CONTROL)
				.perform();
			}
		}
		
		//Display the selected elements
		System.out.println("Selected options are : ");
		for(WebElement ele: dropdownOptionsList)
		{
			if(ele.isSelected())
			{
				System.out.println(ele.getText());
			}
		}
		
		//close the browser
		chDriver.close();
		
	}

}
