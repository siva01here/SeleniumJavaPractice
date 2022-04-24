package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testng_CreateContactTest extends TestngBaseClass{
	
	@Test(dataProviderClass=TestDataprovider.class, dataProvider="createLead")
	public void createContactTest(String fName, String lName, String locFname, String locLName, String dept, String desc, String email, String impNote) {				
				//5. Click on contacts link
				chDriver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//6. Click on create contact
				chDriver.findElement(By.xpath("//a[text()='Create Contact']")).click();
				
				//7. Enter first name using ID locator
				//String fName="TestFname";
				chDriver.findElement(By.id("firstNameField")).sendKeys(fName);
				
				//8. Enter last name using ID locator
				//String lName="TestLName";
				chDriver.findElement(By.id("lastNameField")).sendKeys(lName);
				
				//9. Enter first name local using id
				//String localFName="TestLocalFName";
				chDriver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(locFname);
				
				//10. Enter local name local using id
				//String localLName="TestLocalLName";
				chDriver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(locLName);
				
				//11. Enter dept using any locator
				//String deptName="Staffing Dept";
				chDriver.findElement(By.name("departmentName")).sendKeys(dept);
				
				//12. Enter desc using any locator
				//String descText="Test Description for contact";
				chDriver.findElement(By.id("createContactForm_description")).sendKeys(desc);
				
				//13. Enter email using any locator
				//String emailAddr="TestContact@gmail.com";
				chDriver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
				
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
				//String impNote="Notes for contact";
				chDriver.findElement(By.id("updateContactForm_importantNote")).sendKeys(impNote);
				
				//19. Click on update using xpath
				chDriver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
				
				//20. Get the page title
				String pageTitle= chDriver.getTitle();
				System.out.println("Page title after update is : "+pageTitle);
	}

}
