package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_MergeContact {
	
	public static void main(String[] args) {
		
		String pageURL="http://leaftaps.com/opentaps/control/main";
		
		//Set up chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
		
		//1. Access the URL
		chDriver.get(pageURL);
		
		//Maximize the browser
		chDriver.manage().window().maximize();
		
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
		
		//5. Click on contacts
		chDriver.findElement(By.linkText("Contacts")).click();
		
		//6. Click on Merge Contacts
		chDriver.findElement(By.linkText("Merge Contacts")).click();
		
		//7. Click on from widget
		chDriver.findElement(By.xpath("//table[@name='ComboBox_partyIdFrom']//following-sibling::a//child::img")).click();
		
		//Get the window handles
		Set<String> openFromWindowsSet= chDriver.getWindowHandles();
		List<String> openFromWindowsList = new ArrayList<String>(openFromWindowsSet);
		String parentWindow="";
		
		if(openFromWindowsList.size()>0)
		{
			parentWindow=openFromWindowsList.get(0);
		}
		
		//Switch to new window
		chDriver.switchTo().window(openFromWindowsList.get(openFromWindowsList.size()-1));
		
		//8. Get the first contact from the result
		chDriver.findElement(By.xpath("//table[@class='x-grid3-row-table']//td[1]//child::a")).click();
		
		// Switch to parent window
		chDriver.switchTo().window(parentWindow);
		
		//9. Click on to contact widget
		chDriver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']//following-sibling::a//child::img")).click();
		
		
		//Get the To window handles
		Set<String> openToWindowsSet= chDriver.getWindowHandles();
		List<String> openToWindowsList = new ArrayList<String>(openToWindowsSet);
		
				
		//Switch to new window
		chDriver.switchTo().window(openToWindowsList.get(openToWindowsList.size()-1));
		
		//10. Select the second result from the result
		chDriver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[1]//child::a)[2]")).click();
		
		//Switch to parent window
		chDriver.switchTo().window(parentWindow);
		
		//11. Click on merge contact using xpath
		chDriver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Switch to alert
		Alert objMergeAlert= chDriver.switchTo().alert();
		
		//11. Accept the alert
		objMergeAlert.accept();
		
		//13. Get the title of the page after merge
		String pageTitleAfterMerge= chDriver.getTitle();
		
		System.out.println("Title after the merge is : "+pageTitleAfterMerge);
		
		//Verify the title
		if(pageTitleAfterMerge.contains("View Contact"))
		{
			System.out.println("Title is proper after merge contact");
		}
		else
		{
			System.out.println("Title is not proper after merge contact");
		}
		
	}

}
