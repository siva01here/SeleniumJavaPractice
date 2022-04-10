package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_DuplicateLead {

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
		
		//8.Click on Email
		chDriver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//9.Enter Email
		String emailID="test123@gmail.com";
		chDriver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(emailID);
		
		//10. Click find leads button
		chDriver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		try
		{
			Thread.sleep(4000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}
		
		//11. Capture first lead id from the results
		WebElement resultLeadIdEle=chDriver.findElement(By.xpath("//div[contains(@class,'firstName')]//child::a[@class='linktext']"));
		String resultLeadName=resultLeadIdEle.getText();
		System.out.println("Lead first name from the result is : "+resultLeadName);
		
		//12. Click on the result lead ID link
		chDriver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a")).click();	
		
		//13. Click Duplicate Lead
		chDriver.findElement(By.linkText("Duplicate Lead")).click();
		
		//14. Verify the title as 'Duplicate Lead'
		String dupLeadPageTitle= chDriver.getTitle();
		System.out.println("Duplicate lead title is : "+dupLeadPageTitle);
		String dupLead_FName=chDriver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		System.out.println("Duplicate lead name in the page is : "+dupLead_FName);
		
		
		//15. Click Create Lead
		chDriver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		//16. Confirm the duplicated lead name is same as captured name
		if(resultLeadName.equals(dupLead_FName))
		{
			System.out.println("Lead first name in the result and in duplicate lead page is matching fine");
		}
		else
		{
			System.out.println("Lead name did not match");
		}
		
		//17. Close the browser (Do not log out)
		chDriver.close();

	}

}
