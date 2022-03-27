package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
	
	public static void main(String[] args) {
		//Assign the URL to a string variable
				String URL= "http://leaftaps.com/opentaps/control/main";
				
				//Setting up the chrome driver with bonigracia api;
				WebDriverManager.chromedriver().setup();
				
				//Launch chrome browser
				ChromeDriver objChDriver= new ChromeDriver();
				
				//Setting up firefox driver with bonigracia api
				//WebDriverManager.firefoxdriver().setup();
				
				//Launch firefox browser
				//FirefoxDriver objFfDriver = new FirefoxDriver();
				
				//Maximize the window
				objChDriver.manage().window().maximize();
				
				//Open the URL
				objChDriver.get(URL);
				
				String userName="DemoCSR";
				String pwd= "crmsfa";
				
				//enter the user name
				objChDriver.findElement(By.id("username")).sendKeys(userName);
				
				//enter the password
				objChDriver.findElement(By.id("password")).sendKeys(pwd);
				
				//click on submit
				objChDriver.findElement(By.className("decorativeSubmit")).click();
				
				//click on CRM/SFA link
				objChDriver.findElement(By.linkText("CRM/SFA")).click();
				
				//Click on Leads link
				objChDriver.findElement(By.linkText("Leads")).click();
				
				//Click on Create Lead link from left menu
				objChDriver.findElement(By.linkText("Create Lead")).click();
				
				//Identify the drop down element
				WebElement dropDownEle=objChDriver.findElement(By.id("createLeadForm_dataSourceId"));
				
				//Assign that to a select class which is the Selenium class for drop down
				Select objSelect= new Select(dropDownEle);
				
				//Select class has 3 methods to select a value from drop down
				
				//1. selectByVisibleText() it is preferred when the values and index are dynamic
				objSelect.selectByVisibleText("Employee");
				String selectedOptionText1=objSelect.getFirstSelectedOption().getText();
				System.out.println("Drop down option selected thru visible text is : " +selectedOptionText1);
				
				//2. selectByIndex() it is preferred to select any random value from drop down
				objSelect.selectByIndex(1);
				String selectedOptionText2=objSelect.getFirstSelectedOption().getText();
				System.out.println("Drop down option selected thru index is : " +selectedOptionText2);
				
				//3. selectByValue it is preferred to select the value like a multilingual dropdown options would be a best fit for this
				objSelect.selectByValue("LEAD_DIRECTMAIL");
				String selectedOptionText3=objSelect.getFirstSelectedOption().getText();
				System.out.println("Drop down option selected thru value is : " +selectedOptionText3);
	}

}
