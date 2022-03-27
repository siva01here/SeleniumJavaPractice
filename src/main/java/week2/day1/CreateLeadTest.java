package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadTest {
	
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
		String companyName="Test Organization Pvt Ltd";
		chDriver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		
		//8. Enter the first name using ID locator
		String fName="TestFName";
		chDriver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		
		//9. Enter the last name using ID loctor
		String lName="TestLName";
		chDriver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		
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
