package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_JqueryResizable {
	
	public static void main(String[] args) {
		String url="https://jqueryui.com/resizable";
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver();

		//Maximize the browser
		chDriver.manage().window().maximize();

		//Launch the page
		chDriver.get(url);

		//Switch to frame
		WebElement frameEle=chDriver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		chDriver.switchTo().frame(frameEle);

		//Create an instance of Actions class to resize 
		WebElement resizeEle= chDriver.findElement(By.xpath("//div[contains(@class,'ui-icon-gripsmall-diagonal-se')]"));
		Actions objAction= new Actions(chDriver);
		objAction.moveToElement(resizeEle).clickAndHold().moveByOffset(100,76).release().build().perform();
		
		//close the browser
		chDriver.close();
	}

}
