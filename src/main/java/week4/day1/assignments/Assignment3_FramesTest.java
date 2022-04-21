package week4.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_FramesTest {
	
	
	public static void main(String[] args) {
		
		String pageURL="https://chercher.tech/practice/frames-example-selenium-webdriver";
		
		//Set up chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
		
		//1. Access the URL
		chDriver.get(pageURL);
		
		//Maximize the browser
		chDriver.manage().window().maximize();
		
		//Switch to frame 1
		chDriver.switchTo().frame("frame1");
		
		//Set text in frame 1
		chDriver.findElement(By.xpath("//b[@id='topic']//following-sibling::input")).sendKeys("Frames Test");
		
		//Switch to frame 3
		chDriver.switchTo().frame("frame3");
		
		//click on the check box in frame 3
		WebElement frame3CheckboxEle=chDriver.findElement(By.id("a"));
		boolean checkBoxSelectionStateBefore=frame3CheckboxEle.isSelected();
		System.out.println("Is check box selected : "+checkBoxSelectionStateBefore);
		frame3CheckboxEle.click();
		boolean checkBoxSelectionStateAfter=frame3CheckboxEle.isSelected();
		System.out.println("Is check box selected : "+checkBoxSelectionStateAfter);
		
		//switch to frame 1
		chDriver.switchTo().parentFrame();
		
		//switch to default content
		chDriver.switchTo().defaultContent();
		
		//switch to frame 2
		chDriver.switchTo().frame("frame2");
		
		//Select the value from drop down
		Select objSelect= new Select(chDriver.findElement(By.id("animals")));
		System.out.println("Option selected by default in the drop down is : "+objSelect.getFirstSelectedOption().getText());
		
		objSelect.selectByValue("avatar");
		System.out.println("Option selected by script in the drop down is : "+objSelect.getFirstSelectedOption().getText());
		
		//switch to default content
		chDriver.switchTo().defaultContent();
		
		//Print the page title
		System.out.println("Main page title is : "+chDriver.getTitle());
		
		//close the browser
		chDriver.close();
	}

}
