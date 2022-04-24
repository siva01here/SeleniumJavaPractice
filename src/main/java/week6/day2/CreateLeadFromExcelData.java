package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadFromExcelData extends TestngBaseClass{
	
	@Test(dataProviderClass=ReadDataFromExcel.class, dataProvider="excelTestData")
	public void createLeadTest(String empFname, String empLname,String compName) {
		//5. Click on Leads link from top menu
		chDriver.findElement(By.linkText("Leads")).click();
		
		//6. Click on Create lead from left menu
		chDriver.findElement(By.linkText("Create Lead")).click();
		
		//8. Enter the first name using ID locator
		//String fName="TestFName";
		chDriver.findElement(By.id("createLeadForm_firstName")).sendKeys(empFname);
		
		//9. Enter the last name using ID loctor
		//String lName="TestLName";
		chDriver.findElement(By.id("createLeadForm_lastName")).sendKeys(empLname);
		
		//7. Enter the company name using ID locator
		//String companyName="Test Organization Pvt Ltd";
		chDriver.findElement(By.id("createLeadForm_companyName")).sendKeys(compName);
		
		//10. Enter the first name local using id locator
		String fNameLocal="LocalTestFName";
		chDriver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fNameLocal);
		
		//11. Enter the department field using any locator
		String deptName="IT Consulting";
		chDriver.findElement(By.name("departmentName")).sendKeys(deptName);
		
		//12. Enter the description using any locator
		String descriptionText="Test Lead Description Text";
		chDriver.findElement(By.id("createLeadForm_description")).sendKeys(descriptionText);
		
		//13. Enter email ID using any locator
		String emailAddr="TestOrg@testmail.com";
		chDriver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(emailAddr);
		
		//14. Select state/province as New york using visible text
		WebElement stateDropDown= chDriver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//Initialize drop down with select class object
		Select objState= new Select(stateDropDown);
		
		//Select the drop down value using visible text
		objState.selectByVisibleText("New York");
		String actualSelectState= objState.getFirstSelectedOption().getText();
		System.out.println("State selected is : "+actualSelectState);
		
		//15. Click on create lead button to create the lead
		chDriver.findElement(By.className("smallSubmit")).click();
		
		//Print the page title after creating lead
		String pageTitle= chDriver.getTitle();
		System.out.println("Page title after creating lead is "+ pageTitle);
		
		
		
		
		
	}

}
