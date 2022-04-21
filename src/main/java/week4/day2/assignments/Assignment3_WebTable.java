package week4.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_WebTable {
	
	public static void main(String[] args) {
		String url="http://www.leafground.com/pages/table.html";
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver();

		//Maximize the browser
		chDriver.manage().window().maximize();

		//Launch the page
		chDriver.get(url);

		//Get the count of number of columns
		System.out.println("Number of columns are : "+ chDriver.findElements(By.xpath("//table//tr[2]//td")).size());

		//Get the count of number of rows
		int noOfRows=chDriver.findElements(By.xpath("//table//tr")).size();
		System.out.println("Number of rows are : "+noOfRows);

		//Get the progress value of 'Learn to interact with Elements'
		String progressValuePath1="//table//child::tr[";
		String progressValuePath2="]//child::td[2]";
		int startingRow=2;
		List<Integer> percentageList= new ArrayList<Integer>();
		
		System.out.println("Progress value of Learn to interact with Elements ");
		for(int i=startingRow;i<=noOfRows;i++)
		{
			WebElement tempEle=chDriver.findElement(By.xpath(progressValuePath1+i+progressValuePath2));
			percentageList.add(Integer.parseInt(tempEle.getText().replaceAll("[^0-9]","")));
			System.out.println(tempEle.getText());
		}

		//Check the vital task for the least completed progress
		Collections.sort(percentageList);
		String lowestPercentage="";
		if(percentageList.size()>0)
		{
			lowestPercentage=percentageList.get(0)+"";
		}
		
		WebElement checkbox=null;		
		for(int i=startingRow;i<=noOfRows;i++)
		{
			WebElement temp=chDriver.findElement(By.xpath(progressValuePath1+i+progressValuePath2));
			if(temp.getText().replaceAll("[^0-9]","").equals(lowestPercentage))
			{
				checkbox=chDriver.findElement(By.xpath(progressValuePath1+i+progressValuePath2+"//following-sibling::td"));
				checkbox.click();
				break;
			}
		}
		checkbox=chDriver.findElement(By.xpath("//table//tr[6]//td[3]//child::input"));
		if(checkbox.isSelected())
		{
			System.out.println("Lowest completed progress checkbox is selected ");
		}
		else
		{
			System.out.println("Lowest completed progress checkbox is not selected ");

		}
		
		//close the browser
		//chDriver.close();

	}

}
