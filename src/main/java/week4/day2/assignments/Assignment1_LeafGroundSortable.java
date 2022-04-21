package week4.day2.assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_LeafGroundSortable {

	public static void main(String[] args) {
		String url="http://www.leafground.com/pages/sortable.html";
		
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver();

		//Maximize the browser
		chDriver.manage().window().maximize();

		//Launch the page
		chDriver.get(url);

		//Drag and the drop the web element by source and target
		WebElement sourceEle= chDriver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement targetEle= chDriver.findElement(By.xpath("//li[text()='Item 1']"));
		
		//Sorted order before drag and drop is
		System.out.println("Sorted order before drag and drop is : ");
		List<WebElement> selectableItemList= chDriver.findElements(By.xpath("//li[contains(@class,'ui-sortable-handle')]"));
		List<String> eleDescBfr= new ArrayList<String>();
		
		for(WebElement ele1: selectableItemList)
		{
			System.out.println(ele1.getText());
			eleDescBfr.add(ele1.getText());
		}

		//Create an instance of actions class
		Actions objAction= new Actions(chDriver);
		
		//Drag item 1 and drop at item 7
		objAction.click(sourceEle).dragAndDrop(sourceEle,targetEle).build().perform();

		//Sorted order before drag and drop is
		System.out.println("Sorted order after drag and drop is : ");
		List<WebElement> selectableItemListAfr= chDriver.findElements(By.xpath("//li[contains(@class,'ui-sortable-handle')]"));
		List<String> eleDescAfr= new ArrayList<String>();
		
		for(WebElement ele2: selectableItemListAfr)
		{
			System.out.println(ele2.getText());
			eleDescAfr.add(ele2.getText());
		}
		
		if(!eleDescBfr.equals(eleDescAfr))
		{
			System.out.println("Sorting order is changed");
		}
		else
		{
			System.out.println("Sorting order is not modified");
		}
		
		//close the browser
		//chDriver.close();

	}

}
