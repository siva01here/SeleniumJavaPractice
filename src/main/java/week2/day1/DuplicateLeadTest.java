package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadTest {

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
		
		//6. Click on Create lead from left menu
		chDriver.findElement(By.linkText("Create Lead")).click();
		
		//7. Enter the company name using ID locator
		String companyName="Test Duplicate Organization Pvt Ltd";
		chDriver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		
		//8. Enter the first name using ID locator
		String fName="TestFNameDup";
		chDriver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		
		//9. Enter the last name using ID loctor
		String lName="TestLNameDup";
		chDriver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		
		//10. Enter the first name local using id locator
		String fNameLocal="LocalDupTestFName";
		chDriver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fNameLocal);
		
		//11. Enter the department field using any locator
		String deptName="IT Consulting Dup";
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
		
		//16. Print the page title after creating lead
		String pageTitle= chDriver.getTitle();
		System.out.println("Page title after creating lead is "+ pageTitle);
		
		//17. Click on the Duplicate lead button
		chDriver.findElement(By.linkText("Duplicate Lead")).click();
		
		//18. Clear the company name field
		//Get the value in company name field before clearing the text in it
		WebElement compNameElement=chDriver.findElement(By.id("createLeadForm_companyName"));
		String companyNameBefore=compNameElement.getAttribute("value");
		System.out.println("Company Name before clear is : "+companyNameBefore);
		
		//Perform clear
		compNameElement.clear();
		
		//Enter new company name
		String updCompanyName="Test Dup Organization Pvt Ltd";
		compNameElement.sendKeys(updCompanyName);
		
		//Get the value in company name after clear
		String companyNameAfter=compNameElement.getAttribute("value");
		
		if(companyNameAfter.length()>0)
		{
			System.out.println("Updated Company name is : "+companyNameAfter);
		}
		else
		{
			System.out.println("Company Name field is empty");
		}
		
		//19. Clear the first name field
		//Get the value in company name field before clearing the text in it
		WebElement firstNameElement=chDriver.findElement(By.id("createLeadForm_firstName"));
		String firstNameBefore=firstNameElement.getAttribute("value");
		System.out.println("First Name before clear is : "+firstNameBefore);
				
		//Perform clear
		firstNameElement.clear();
				
		//Enter new company name
		String updFirstName="TestFNameDupUpd";
		firstNameElement.sendKeys(updFirstName);
				
		//Get the value in company name after clear
		String firstNameAfter=firstNameElement.getAttribute("value");
				
		if(firstNameAfter.length()>0)
		{
			System.out.println("Updated first name is : "+firstNameAfter);
		}
		else
		{
			System.out.println("First Name field is empty");
		}
				
		//20. Click on create lead button 
		chDriver.findElement(By.className("smallSubmit")).click();
		
		//21. Get the page title after duplicate lead
		String pageTitleAfterDupLead= chDriver.getTitle();
		System.out.println("Page title after duplicate lead is : "+pageTitleAfterDupLead);

	}

}
