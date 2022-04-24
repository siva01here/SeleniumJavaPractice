package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng_CreateContact {
	
	@Test
	public void createContactTest() {
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
				
				//5. Click on contacts link
				chDriver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//6. Click on create contact
				chDriver.findElement(By.xpath("//a[text()='Create Contact']")).click();
				
				//7. Enter first name using ID locator
				String fName="TestFname";
				chDriver.findElement(By.id("firstNameField")).sendKeys(fName);
				
				//8. Enter last name using ID locator
				String lName="TestLName";
				chDriver.findElement(By.id("lastNameField")).sendKeys(lName);
				
				//9. Enter first name local using id
				String localFName="TestLocalFName";
				chDriver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(localFName);
				
				//10. Enter local name local using id
				String localLName="TestLocalLName";
				chDriver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(localLName);
				
				//11. Enter dept using any locator
				String deptName="Staffing Dept";
				chDriver.findElement(By.name("departmentName")).sendKeys(deptName);
				
				//12. Enter desc using any locator
				String descText="Test Description for contact";
				chDriver.findElement(By.id("createContactForm_description")).sendKeys(descText);
				
				//13. Enter email using any locator
				String emailAddr="TestContact@gmail.com";
				chDriver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(emailAddr);
				
				//14. Select New york state/province
				Select objState= new Select(chDriver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
				objState.selectByValue("NY");
				
				//15. Click on create contact button
				chDriver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
				
				//16. Click on edit button
				chDriver.findElement(By.xpath("//a[text()='Edit']")).click();
				
				//17. Clear the desc
				chDriver.findElement(By.id("updateContactForm_description")).clear();
				
				//18. Update the important note
				String impNote="Notes for contact";
				chDriver.findElement(By.id("updateContactForm_importantNote")).sendKeys(impNote);
				
				//19. Click on update using xpath
				chDriver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
				
				//20. Get the page title
				String pageTitle= chDriver.getTitle();
				System.out.println("Page title after update is : "+pageTitle);
	}

}
