package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_PageTitleTest {
	public static void main(String[] args) {
		//Set up chrome binaries using bonigracia api
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver driver= new ChromeDriver();
		
		//Load the URL
		String URL="https://acme-test.uipath.com/login";
		driver.get(URL);
		String loginPageTitle=driver.getTitle();
		System.out.println("Login page title is : "+loginPageTitle);
		
		//Enter the user email
		String userEmail="kumar.testleaf@gmail.com";
		driver.findElement(By.id("email")).sendKeys(userEmail);
		
		//Enter the pwd
		String pwd="leaf@12";
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		//Click on login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//Print the title of the page
		String pageTitle= driver.getTitle();
		System.out.println("Title of the page is : "+pageTitle);
		
		//Click on logout
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		String pageTitleAfterLogout=driver.getTitle();
		
		if(loginPageTitle.equals(pageTitleAfterLogout))
		{
			System.out.println("Logged out successfully");
		}
		else
		{
			System.out.println("Title differs");
		}
		
		//close the browser
		driver.close();
		
		
	}

}
