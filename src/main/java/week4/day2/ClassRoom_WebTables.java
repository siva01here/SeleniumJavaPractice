package week4.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom_WebTables {
	
	public static void main(String[] args) {
		String url="https://erail.in/";
		
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser 
		WebDriver chDriver= new ChromeDriver();
		
		//Maximize the browser
		chDriver.manage().window().maximize();
		
		//Load the URL
		chDriver.get(url);
		
		//Enter from station
		WebElement fromStationEle=chDriver.findElement(By.id("txtStationFrom"));
		String fromStationCode="MAS";
		fromStationEle.clear();
		fromStationEle.sendKeys(fromStationCode);
		
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}
		
		fromStationEle.sendKeys(Keys.TAB);
		fromStationEle.sendKeys(Keys.TAB);
		
		//Enter to station
		WebElement toStationEle=chDriver.findElement(By.id("txtStationTo"));
		toStationEle.clear();
		String toStationCode="MDU";
		toStationEle.sendKeys(toStationCode);
		
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}
		
		toStationEle.sendKeys(Keys.TAB);
		
		//Uncheck sort by date check box
		chDriver.findElement(By.id("chkSelectDateOnly")).click();
		
		try
		{
			Thread.sleep(6000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}
		
		
		//Get the table data
		List<WebElement> rowsList=chDriver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList TrainListHeader')]//tr"));
		int rowsCount=rowsList.size();
		String rowPath="//table[contains(@class,'DataTable TrainList TrainListHeader')]//tr[";
		String colPath="]//td[2]";
		List<String> trainNamesList= new ArrayList<String>();
		
		//Add the train names in the table to the list
		for(int i=1;i<=rowsCount;i++)
		{
			String temp=chDriver.findElement(By.xpath(rowPath+i+colPath)).getText();
			trainNamesList.add(temp);
		}
		
		//Create a new set and copy all the train names to it
		Set<String> uniqueTrainNamesSet= new HashSet<String>(trainNamesList);
		
		//verify the web table contains any repeated train names in it
		if(trainNamesList.size()==uniqueTrainNamesSet.size())
		{
			System.out.println("No repeated train names in the table");
		}
		else
		{
			System.out.println("Table contains repeated train names in it");
		}
		
		//close the browser
		chDriver.close();
		
	}

}
