package week3.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioTest {
	
	public static void main(String[] args) {
		//Set up the browser drivers
		WebDriverManager.chromedriver().setup();
		
		//launch the browser
		WebDriver driver= new ChromeDriver();

		//maximize the window
		driver.manage().window().maximize();

		//access the url
		String URL="https://www.ajio.com/";
		driver.get(URL);
		
		//Create an instance of explicit wait 
		WebDriverWait objExpWait= new WebDriverWait(driver,Duration.ofSeconds(10));

		//Type bags in the search box and press enter
		WebElement searchBox=driver.findElement(By.xpath("//div[@class='searchbar-view']//child::input"));
		searchBox.click();
		String textToSearch="bags";
		searchBox.sendKeys(textToSearch);
		searchBox.sendKeys(Keys.ENTER);

		//Click on Men Checkbox under men
		objExpWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='Men']//following-sibling::label"))));
		driver.findElement(By.xpath("//input[@id='Men']//following-sibling::label")).click();

		putOnSleep(2);
		//Click on Fashion bags check box under category
		driver.findElement(By.xpath("//div[@class='facet-linkhead']//child::input[@id='Men - Fashion Bags']//following-sibling::label")).click();

		putOnSleep(2);
		//Get the total items count
		String totalItems= driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println("Total Items found so far is : "+totalItems);
		
		
		//Get the brand names displayed on the page
		List<WebElement> brandsListDisplayedOnPage=driver.findElements(By.xpath("//div[@class='contentHolder']//child::div[@class='brand']"));
		System.out.println("Total brands displayed in the page is : "+brandsListDisplayedOnPage.size());
		System.out.println("Brands displayed on the page are as follows : ");
		for(WebElement brandNameEle: brandsListDisplayedOnPage)
		{
			System.out.println(brandNameEle.getText());
		}

		//Get the list of all product names in the page
		System.out.println("Bags name displayed in the page are : ");
		List<WebElement> productNamesList= driver.findElements(By.xpath("//div[@class='contentHolder']//child::div[@class='nameCls']"));
		
		for(WebElement productName: productNamesList)
		{
			System.out.println(productName.getText());
		}
	}
	
	public static void putOnSleep(int num)
	{
		try
		{
			Thread.sleep(num*1000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in sleep");
		}
	}

}
