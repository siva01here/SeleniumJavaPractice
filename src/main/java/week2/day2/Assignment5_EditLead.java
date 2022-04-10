package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5_EditLead {
	
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
					
			//2. Enter the username in the page
			chDriver.findElement(By.id("username")).sendKeys(userName);
			
			//3. Enter the password in the page
			chDriver.findElement(By.id("password")).sendKeys(pwd);
					
			//4. Click on login button
			chDriver.findElement(By.className("decorativeSubmit")).click();
					
			//5. Click on CRM/SFA link
			chDriver.findElement(By.linkText("CRM/SFA")).click();
			
			//6. Click on Leads link from top menu
			chDriver.findElement(By.linkText("Leads")).click();
					
			//7. Click on find leads link
			chDriver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			
			//8.Click on FirstName
			chDriver.findElement(By.xpath("//div[contains(@class,'x-form-item x-tab-item')]//child::input[@name='firstName']")).click();
			
			//8.Enter firstName
			String firstName="TestFName1";
			chDriver.findElement(By.xpath("//div[contains(@class,'x-form-item x-tab-item')]//child::input[@name='firstName']")).sendKeys(firstName);
			
			//9. Click find leads button
			chDriver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			try
			{
				Thread.sleep(4000);
			}catch(InterruptedException e)
			{
				System.out.println("Exception in thread.sleep");
			}
			
			//10. Click on the first result lead ID link
			chDriver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[3]")).click();
			
			//11. Verify title of the page
			String actualViewLeadPageTitle= chDriver.getTitle();
			System.out.println("Title of the edit page is : "+actualViewLeadPageTitle);
			String expectedViewageTitle="View Lead | opentaps CRM";
			if(expectedViewageTitle.equals(actualViewLeadPageTitle))
			{
				System.out.println("View Lead page title matched fine");
			}
			else
			{
				System.out.println("View Lead page title is not correct");
			}
			
			//12. Click Edit
			chDriver.findElement(By.linkText("Edit")).click();
			
			//13. Change the company name
			WebElement editCompanyNameEle=chDriver.findElement(By.id("updateLeadForm_companyName"));
			String companyNameBfr=editCompanyNameEle.getAttribute("value");
			System.out.println("Company name before edit is : "+companyNameBfr);
			
			//update company name field
			editCompanyNameEle.clear();
			String updCompanyName="TestUpdatedOrganizationName";
			editCompanyNameEle.sendKeys(updCompanyName);
			
			//14. Click on update
			chDriver.findElement(By.xpath("//input[@value='Update']")).click();
			
			//15. Confirm the changed name appears
			String actualUpdCompName=chDriver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("[^a-zA-Z]", "");
			System.out.println(actualUpdCompName);
			
			if(actualUpdCompName.equals(updCompanyName))
			{
				System.out.println("Updated Company Name displayed properly");
			}
			else
			{
				System.out.println("Company Name is not updated properly");
			}
			
			//16.Close the browser (Do not log out)
			chDriver.close();
			
			
			
			
			
			
	}
}
