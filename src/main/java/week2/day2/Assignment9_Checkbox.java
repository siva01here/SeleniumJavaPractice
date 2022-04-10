package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment9_Checkbox {
	
	public static void main(String[] args) {
		String pageURL="http://leafground.com/pages/checkbox.html";
		
		//Set up chrome browser
		WebDriverManager.chromedriver().setup();
				
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
				
		//Load the URL
		chDriver.get(pageURL);
		
		//Select the language check box
		List<WebElement> languageCheckboxList=chDriver.findElements(By.xpath("//label[contains(text(),'Select the languages that')]//following-sibling::input"));
		
		for(int i=0;i<languageCheckboxList.size();i++)
		{
			if(i==0)
				languageCheckboxList.get(i).click();
			else
				break;
		}
		
		
		//Confirm selenium check box is checked
		boolean isSeleniumCheckboxSelected=chDriver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']//following-sibling::input")).isSelected();
		
		if(isSeleniumCheckboxSelected)
		{
			System.out.println("Selenuim check box is selected");
		}
		else
		{
			System.out.println("Selenium check box is not selected");
		}
		
		//DeSelect only checked
		List<WebElement> deSelectEleList=chDriver.findElements(By.xpath("//label[text()='DeSelect only checked']//following-sibling::input"));
		
		for(WebElement ele: deSelectEleList)
		{
			if(ele.isSelected())
			{
				ele.click();
			}
		}
		
		//Select all below checkboxes 
		List<WebElement> allCheckboxesList=chDriver.findElements(By.xpath("//label[text()='Select all below checkboxes ']//following-sibling::input"));
		
		for(WebElement ele: allCheckboxesList)
		{
			ele.click();
		}
		
		int selectedCheckboxCount=0;
		
		for(WebElement ele: allCheckboxesList)
		{
			if(ele.isSelected())
			{
				selectedCheckboxCount++;
			}
		}
		
		if(selectedCheckboxCount==allCheckboxesList.size())
		{
			System.out.println("All checkboxes are selected");
		}
		else
		{
			System.out.println("All checkboxes are not selected");
		}
		
		//close the browser
		chDriver.close();
	}

}
