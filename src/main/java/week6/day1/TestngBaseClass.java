package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBaseClass {
	WebDriver chDriver;
	
	@BeforeMethod
	public void crmAppPreCondition()
	{
		//Set up the chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Initialize driver variable
		chDriver= new ChromeDriver();
		
		//Initialize the url to a variable
		String URL="http://leaftaps.com/opentaps/control/main";
		
		//maximize the browser
		chDriver.manage().window().maximize();
		
		//1. Load the URL
		chDriver.get(URL);
		
		//Login to page using valid credentials
		String userName="DemoCSR";
		String pwd= "crmsfa"; 
		
		//2. Enter the credentials in the page
		chDriver.findElement(By.id("username")).sendKeys(userName);
		chDriver.findElement(By.id("password")).sendKeys(pwd);
		
		//3. Click on login button
		chDriver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA link
		chDriver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@AfterMethod
	public void crmAppPostCondition()
	{
		chDriver.close();
	}

}
