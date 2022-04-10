package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7_Buttons {
	public static void main(String[] args) {
		
		String pageURL="http://leafground.com/pages/Button.html";
		
		//Set up the chorme browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
		
		//Load the URL
		chDriver.get(pageURL);
		
		//Get position of a webelement
		Point objPoint=chDriver.findElement(By.id("position")).getLocation();
		System.out.println("X coordinates of the element is : "+objPoint.getX());
		System.out.println("Y coordinates of the element is : "+objPoint.getY());
		
		
		//Get color of the webelement
		WebElement colorEle=chDriver.findElement(By.id("color"));
		String colorRGBAStr[]=colorEle.getCssValue("background-color").replaceAll("[^0-9\\,]", "").split("\\,");
		String hexColorStr=String.format("#%02X%02X%02X", Integer.parseInt(colorRGBAStr[0]),Integer.parseInt(colorRGBAStr[1]),Integer.parseInt(colorRGBAStr[2]));
		System.out.println(hexColorStr);
		System.out.println(colorEle.getAttribute("style").substring(18));
		
		//Get size of the webelement
		WebElement sizeEle=chDriver.findElement(By.id("size"));
		Dimension objSize= sizeEle.getSize();
		System.out.println("Width of the element is : "+objSize.getWidth());
		System.out.println("Height of the element is : "+objSize.getHeight());
		
		//Go to Home page button
		WebElement homePageButton=chDriver.findElement(By.id("home"));
		homePageButton.click();
				
		String actualhomePageTitle=chDriver.getTitle();
		String expectedHomePageTitle="TestLeaf - Selenium Playground";
				
		if(expectedHomePageTitle.equals(actualhomePageTitle))
		{
			System.out.println("Navigated to home page successfully");
		}
		else
		{
			System.out.println("Problem in home page navigation");
		}
		
		//close the browser
		chDriver.close();
		
	}

}
