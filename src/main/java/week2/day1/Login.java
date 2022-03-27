package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
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
		
		//Print the page title
		System.out.println(objChDriver.getTitle());
		
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
		
		//Enter the mandatory values for company name, first name and last name
		String companyName="XYZ Org Pvt Ltd";
		String firstName="UserFirstName";
		String lastName="UserLastName";
		
		objChDriver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		objChDriver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		objChDriver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		
		//Click on Create lead button at the bottom
		objChDriver.findElement(By.name("submitButton")).click();
		
		String createLeadTitle=objChDriver.getTitle();
		System.out.println(createLeadTitle);
		
		//Get the create lead status
		String actCreateLeadStatus=objChDriver.findElement(By.id("viewLead_statusId_sp")).getText();
		System.out.println(actCreateLeadStatus);
		String expCreateLeadStatus="Assigned";
		if(actCreateLeadStatus.equalsIgnoreCase(expCreateLeadStatus))
		{
			System.out.println("Lead created successfully");
		}
		else
		{
			System.out.println("Some Error has occured...");
		}
		
		//Get the created lead details
		String actualCompanyName=objChDriver.findElement(By.id("viewLead_companyName_sp")).getText();
		String actualFirstName=objChDriver.findElement(By.id("viewLead_firstName_sp")).getText();
		String actualLastName=objChDriver.findElement(By.id("viewLead_lastName_sp")).getText();
		
		System.out.println("Print actual lead info....");
		System.out.println(actualCompanyName+"---->"+actualFirstName+"--->"+actualLastName);
		
		//Close the web page
		objChDriver.close();
		
	}

}
