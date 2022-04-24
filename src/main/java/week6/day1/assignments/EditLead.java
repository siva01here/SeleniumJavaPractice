package week6.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class EditLead extends BaseClass{
	
	@Test
	public void editLeadTest() {
			//6. Click on Leads link from top menu
			chDriver.findElement(By.linkText("Leads")).click();
					
			//7. Click on find leads link
			chDriver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			
			//8.Click on FirstName
			chDriver.findElement(By.xpath("//div[contains(@class,'x-form-item x-tab-item')]//child::input[@name='firstName']")).click();
			
			//8.Enter firstName
			String firstName="TestFName";
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
	}
}
