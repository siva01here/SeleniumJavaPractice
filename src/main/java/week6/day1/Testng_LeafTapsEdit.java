package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng_LeafTapsEdit {
	
	@Test
	public void leafTaps_EditPageTest() {
		String URL="http://leafground.com/pages/Edit.html";
		
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
		
		//Load the URL
		chDriver.get(URL);
		
		//Enter the email address
		WebElement emailAddrEle= chDriver.findElement(By.id("email"));
		String emailAddrBfr=emailAddrEle.getAttribute("value");
		String inputEmail="Test123@gmail.com";
		
		emailAddrEle.sendKeys(inputEmail);
		String emailAddrAfr=emailAddrEle.getAttribute("value");
		
		if(emailAddrBfr.length()<emailAddrAfr.length())
		{
			System.out.println("Email address changed properly");
		}
		else
		{
			System.out.println("Email address is not changed");
		}
		
		//Append the text in the field
		WebElement appendEle=chDriver.findElement(By.xpath("//input[contains(@value,'Append')]"));
		String appendText="Text to be appended";
		appendEle.sendKeys(appendText);
		appendEle.sendKeys(Keys.TAB);
		
		String appendTextAfr=appendEle.getAttribute("value");
		System.out.println(appendTextAfr);
		
		if(appendTextAfr.startsWith("Append"))
		{
			System.out.println("Text appended properly");
		}
		else
		{
			System.out.println("Text is not append properly");
		}
		
		//Get the default text in the field
		WebElement defaultTextEle=chDriver.findElement(By.xpath("//label[contains(text(),'Get default')]//following-sibling::input"));
		String defTextInField=defaultTextEle.getAttribute("value");
		System.out.println("Default text in the field is : "+defTextInField);
		
		//Clear the text
		WebElement clearEle=chDriver.findElement(By.xpath("//label[contains(text(),'Clear')]//following-sibling::input"));
		String clearTextBfr=clearEle.getAttribute("value");
		System.out.println("Text before clearing the field is : "+clearTextBfr);
		
		clearEle.clear();
		String clearTextAfr=clearEle.getAttribute("value");
		
		if(clearTextAfr.length()==0)
		{
			System.out.println("Text is cleared fine");
		}
		
		//Verify disabled Element
		WebElement disabledEle=chDriver.findElement(By.xpath("//label[contains(text(),'Confirm')]//following-sibling::input"));
		
		if(!disabledEle.isEnabled())
		{
			System.out.println("Element is disabled for edit");
		}
		else
		{
			System.out.println("Element is not disabled");
		}
		
		//close the page
		chDriver.close();
	}

}
