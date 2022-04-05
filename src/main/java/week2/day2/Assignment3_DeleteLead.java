package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_DeleteLead {
	public static void main(String[] args) {
		//Set up the chrome driver
		WebDriverManager.chromedriver().setup();
		
		//Initialize driver variable
		ChromeDriver chDriver= new ChromeDriver();
		
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
		
		//5. Click on Leads link from top menu
		chDriver.findElement(By.linkText("Leads")).click();
		
		//7. Click on find leads link
		chDriver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//8. Click on phone search field
		chDriver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//9. Enter phone number
		String phone="8579001000";
		chDriver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);
		
		//10. Click on find leads button
		chDriver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		try
		{
			Thread.sleep(4000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}
		
		//11. Capture first lead id from the results
		WebElement resultLeadIdEle=chDriver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a"));
		String resultLeadID=resultLeadIdEle.getText();
		System.out.println("Lead id from the result is : "+resultLeadID);
		
		//12. Click on the result lead ID link
		chDriver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();
		
		//13. Click on delete
		chDriver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		//14. Click on Find leads from left menu
		chDriver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		//15. Enter the result lead Id in the lead id field
		chDriver.findElement(By.xpath("//input[@name='id']")).sendKeys(resultLeadID);
		
		
		//16. Click on find leads button
		chDriver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		try
		{
			Thread.sleep(4000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}
		
		//17. Verify no records message
		String msgDisplayed=chDriver.findElement(By.className("x-paging-info")).getText();
		System.out.println(msgDisplayed);
		
		//18. Close the browser
		chDriver.close();
		
	}
	

}
