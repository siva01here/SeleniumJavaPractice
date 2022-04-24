package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBaseClass {
	WebDriver chDriver;
	
	//Initialize the url to a variable
	String pageURL="http://leaftaps.com/opentaps/control/main";
	
	//Login to page using valid credentials
	String userName="DemoCSR";
	String pwd= "crmsfa"; 
			
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void crmAppPreCondition(@Optional("http://leaftaps.com/opentaps/control/main")String paramURL, @Optional("DemoCSR")String paramUName, @Optional("crmsfa") String paramPwd)
	{
		//Set up the chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Initialize driver variable
		chDriver= new ChromeDriver();
		
		
		
		//maximize the browser
		chDriver.manage().window().maximize();
		
		//1. Load the URL
		chDriver.get(paramURL);
		
		//2. Enter the credentials in the page
		chDriver.findElement(By.id("username")).sendKeys(paramUName);
		chDriver.findElement(By.id("password")).sendKeys(paramPwd);
		
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
