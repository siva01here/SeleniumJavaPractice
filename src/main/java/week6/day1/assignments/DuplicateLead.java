package week6.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass {

	@Test
	public void duplicateLeadTest() {
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

	}

}
