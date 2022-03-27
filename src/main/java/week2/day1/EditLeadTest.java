package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadTest {

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
				String companyName="Test Update1 Organization Pvt Ltd";
				chDriver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
				
				//8. Enter the first name using ID locator
				String fName="TestFNameEdit1";
				chDriver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
				
				//9. Enter the last name using ID loctor
				String lName="TestLNameEdit1";
				chDriver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
				
				//10. Enter the first name local using id locator
				String fNameLocal="LocalUpd1TestFName";
				chDriver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(fNameLocal);
				
				//11. Enter the department field using any locator
				String deptName="IT Consulting Upd1";
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
				
				//16. Click on the Edit lead button
				chDriver.findElement(By.linkText("Edit")).click();
				
				//17. Clear the description field
				//Get the value in description field before clearing the text in it
				WebElement descElement=chDriver.findElement(By.id("updateLeadForm_description"));
				String descValueBefore=descElement.getText();
				System.out.println("Description before clear is : "+descValueBefore);
				
				//Perform clear
				descElement.clear();
				
				try
				{
					Thread.sleep(2000);
				}
				catch(InterruptedException e)
				{
					System.out.println("there is some problem in wait");
				}
				
				//Get the value in description after clear
				String descValueAfter=descElement.getText();
				
				if(descValueAfter.length()>0)
				{
					System.out.println(descValueAfter);
				}
				else
				{
					System.out.println("Description field is empty");
				}
				
				
				//18. Fill in important note with any locator
				String importantNotes="Important notes for organization";
				chDriver.findElement(By.name("importantNote")).sendKeys(importantNotes);
				
				//19. Click on update button
				chDriver.findElement(By.className("smallSubmit")).click();
				
				//20. Get the page title after updating the lead
				String pageTitleAfterUpdate= chDriver.getTitle();
				System.out.println("Page title after updating lead is : "+pageTitleAfterUpdate);
				

	}

}
