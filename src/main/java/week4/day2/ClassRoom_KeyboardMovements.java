package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom_KeyboardMovements {
	
	public static void main(String[] args) {
		
		String pageURL="https://www.snapdeal.com/";
		
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Disable browser notifications
		ChromeOptions chOptions= new ChromeOptions();
		chOptions.addArguments("--disable-notifications");
		
		//Launch the browser
		WebDriver chDriver = new ChromeDriver(chOptions);
		
		//Create an instance of Actions class
		Actions objAction = new Actions(chDriver);
		
		//Maximize the browser
		chDriver.manage().window().maximize();
		
		//Load the URL
		chDriver.get(pageURL);
		
		//Mouse hover on Mens fashion
		WebElement mensFashionEle=chDriver.findElement(By.xpath("//a[contains(@class,'menuLinks leftCategoriesProduct')]//child::span[contains(text(),'Men')]"));
		objAction.moveToElement(mensFashionEle).perform();
		
		//Click on shirts
		WebElement shirtsEle= chDriver.findElement(By.xpath("//span[text()='Shirts']"));
		shirtsEle.click();
		
		try
		{
			Thread.sleep(4000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in sleep");
		}
		
		//Get all elements in the page
		List<WebElement> allShirtsList= chDriver.findElements(By.xpath("//p[@class='product-title']"));
		WebElement topMostShirt=null;
		if(allShirtsList.size()>0)
		{
			topMostShirt=allShirtsList.get(0);
		}

		objAction.moveToElement(topMostShirt).pause(2000)
		.click(chDriver.findElement(By.xpath("//div[contains(text(),'Quick View')]"))).perform();
	
		
		//Close all browsers
		chDriver.quit();
		
	}

}
