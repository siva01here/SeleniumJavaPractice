package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom_AlertsAndFrames {
	
	public static void main(String[] args) {
		
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
		
		//Load the URL
		String pageURL="https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt";
		chDriver.get(pageURL);
		
		//Maximize the window
		chDriver.manage().window().maximize();
		
		//Switch to the Iframe
		chDriver.switchTo().frame("iframeResult");
		
		//Click the try it button
		chDriver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		//Pass the name in the prompt alert text field
		String inputName="TestName";
		chDriver.switchTo().alert().sendKeys(inputName);
		
		//Accept the alert
		chDriver.switchTo().alert().accept();
		
		//Get the text displayed on the page after accepting JS alert
		String promptText=chDriver.findElement(By.id("demo")).getText();
		String actualNameInPromptText=promptText.substring(6,(6+inputName.length()));
		System.out.println(actualNameInPromptText);
		
		if(promptText.contains(inputName) && inputName.equals(actualNameInPromptText))
		{
			System.out.println("Name properly displayed in the alert and in the web page");
		}
		else
		{
			System.out.println("Name is not displayed properly in the alert and web page");
		}
		
		
	}

}
