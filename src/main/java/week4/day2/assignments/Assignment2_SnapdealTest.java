package week4.day2.assignments;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_SnapdealTest {
	
	public static void main(String[] args) {
		//Pageurl
		String pageURL="https://www.snapdeal.com/";

		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Create chrome options class to disable browser notifications
		ChromeOptions chOptions= new ChromeOptions();
		chOptions.addArguments("--disable-Notifications");

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver(chOptions);

		//Maximize the browser
		chDriver.manage().window().maximize();
		
		//Add implicitly wait
		chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//1. Launch snapdeal page
		chDriver.get(pageURL);

		//2. Go to men`s fashion
		chDriver.findElement(By.xpath("//span[@class='catText' and contains(text(),'Men')]")).click();

		//3. Go to sports shoes
		chDriver.findElement(By.xpath("//div[@id='category1Data']//child::span[text()='Sports Shoes']")).click();
		
		threadSleep(3);
		
		//4. Get the count of the sports shoes
		String totalSportShoesCount=chDriver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Total sports shoes count is : "+ totalSportShoesCount);

		//5. Click training shoes
		chDriver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		//6. Sort by low to high
		Actions objAction= new Actions(chDriver);
		objAction.moveToElement(chDriver.findElement(By.xpath("//span[@class='sort-label']//following-sibling::div"))).click().build().perform();
		threadSleep(5);
		chDriver.findElement(By.xpath("//li[@class='search-li' and @data-index='1']")).click();

		threadSleep(5);
		//7. Check the items are displayed are sorted correctly
		List<WebElement> pricesList=chDriver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> priceStrList= new ArrayList<String>();
		for(WebElement tempEle: pricesList)
		{
			priceStrList.add((tempEle.getText()).replaceAll("[^0-9]", ""));
		}
		System.out.println(priceStrList);
		boolean result=true;
		for(int i=0;i<priceStrList.size()-1;i++)
		{
			if(Integer.parseInt(priceStrList.get(i))>Integer.parseInt(priceStrList.get(i+1)))
			{
				result=false;
				break;
			}
		}

		if(result)
		{
			System.out.println("Items are displayed in low to high sorted order");
		}
		else
		{
			System.out.println("Items are not displayed in low to high sorted order");
		}

		//9. Filter with color navy
		//No items with color Navy is available when testing this so swapped the steps 
		//chDriver.findElement(By.xpath("//div[@data-displayname='Color']//child::button")).click();
		objAction.moveToElement(chDriver.findElement(By.xpath("//a[contains(text(),'Navy')]"))).click().build().perform();
		
		threadSleep(5);
		
		//8. Select the price range (900-1200)
		WebElement fromPrcEle=chDriver.findElement(By.xpath("//input[@name='fromVal']"));
		fromPrcEle.clear();
		fromPrcEle.sendKeys("900");

		
		WebElement toPrcEle=chDriver.findElement(By.xpath("//input[@name='toVal']"));
		toPrcEle.clear();
		toPrcEle.sendKeys("1200");

		chDriver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();

		threadSleep(5);
		


		//10. verify the applied filter
		List<WebElement> filtersList= chDriver.findElements(By.xpath("//div[@class='filters-top-selected']//child::a"));
		boolean filterResult=false;
		for(WebElement filterEle: filtersList)
		{
			String temp=filterEle.getText();
			System.out.println(temp);
			if(temp.contains("Rs") && temp.equals("Rs. 900 - Rs. 1200"))
			{
				filterResult=true;
			}
			else if (temp.equals("Navy"))
			{
				filterResult=true;
			}
		}

		if(filterResult)
		{
			System.out.println("Filters are set properly");
		}
		else
		{
			System.out.println("Filter are not set properly");
		}


		//11. Mouse hover on first resulting training shoes
		//12. Click quick view button

		
		objAction.moveToElement(chDriver.findElement(By.className("product-title"))).pause(2000).click(chDriver.findElement(By.xpath("//div[contains(text(),'Quick View')]"))).build().perform();

		
		//13. Print the cost and the discount percentage
		String costOfProduct= chDriver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String discPercentage=chDriver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Cost and discount the selected product is : "+costOfProduct+" & "+discPercentage);

		//14. Take the snapshot of the shoes
		threadSleep(5);
		WebElement prodImgEle=chDriver.findElement(By.xpath("//ul[@id='bx-slider-qv-image-panel']//child::img"));
		File srcImg= prodImgEle.getScreenshotAs(OutputType.FILE);
		String fileName=LocalDateTime.now().toString().replaceAll("[^0-9]","");
		File targetImg= new File("D:\\Eclipse Workspace\\SeleniumJavaPractice\\src\\Screenshots\\"+fileName+".png");
		try
		{
			FileUtils.copyFile(srcImg,targetImg);
		}
		catch(Exception e)
		{
			System.out.println("Exception in file copy");
		}


		//15. Close the current window
		chDriver.findElement(By.xpath("//div[contains(@class,'sidebarin')]//child::div[contains(@class,'close')]")).click();

		//16. close the main window
		chDriver.close();

	}
	
	public static void threadSleep(int seconds)
	{
		try
		{
			Thread.sleep(seconds*1000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thred.sleep");
		}
	}

}
