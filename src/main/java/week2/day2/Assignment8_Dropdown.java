package week2.day2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment8_Dropdown {
	static Select objSelect;
	
	public static void main(String[] args) {
		String pageURL="http://leafground.com/pages/Dropdown.html";
		
		//Set up chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
		
		//Load the URL
		chDriver.get(pageURL);
		
		
		//Select value in dropdown using index
		objSelect = new Select(chDriver.findElement(By.id("dropdown1")));
		int index=1;
		List<WebElement> dropdown1OptionsList= objSelect.getOptions();
		if(index<dropdown1OptionsList.size())
		{
			objSelect.selectByIndex(index);
		}
		else
		{
			System.out.println("Given index is out of dropdown index range");
		}
		
		
		//Select value in dropdown using text
		objSelect = new Select(chDriver.findElement(By.name("dropdown2")));
		String text="Appium";
		objSelect.selectByVisibleText(text);
		
		//Select value in dropdown using values
		objSelect= new Select(chDriver.findElement(By.id("dropdown3")));
		String value="3";
		objSelect.selectByValue(value);
		
		//Get no of options in dropdown
		objSelect= new Select(chDriver.findElement(By.className("dropdown")));
		System.out.println("Number of options in the drop down is : "+objSelect.getOptions().size());
		
		//Select dropdown option using sendkeys
		List<WebElement> allSelectOptions= chDriver.findElements(By.xpath("//div[@class='example']"));
		
		for(int i=0;i<allSelectOptions.size();i++)
		{
			if(i==4)
			{
				Actions objAction= new Actions(chDriver);
				objAction.sendKeys(allSelectOptions.get(i),Keys.DOWN).build().perform();
				objAction.sendKeys(allSelectOptions.get(i),Keys.DOWN).build().perform();
				objAction.sendKeys(allSelectOptions.get(i),Keys.ENTER).build().perform();				
				
			}
			
		}
		//Select multiple dropdown options
		List<WebElement> multipleDropdown=chDriver.findElements(By.xpath("//option[text()='Select your programs']//following-sibling::option"));
		for(WebElement ele: multipleDropdown)
		{
			ele.click();
		}
		
		WebElement multiSelectDropdown=chDriver.findElement(By.xpath("//option[text()='Select your programs']//parent::select"));
		objSelect = new Select(multiSelectDropdown);
		if(objSelect.isMultiple())
		{
			System.out.println("It is a multi select drop down");
		}
		else
		{
			System.out.println("It is not a multi select drop odwn");
		}
		
		//close the browser
		chDriver.close();		
	}

}
