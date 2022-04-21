package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5_NykaaPage {
	
	public static void main(String[] args)
	{
		//Pageurl
		String pageURL="https://www.nykaa.com";

		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();

		//Launch the chrome browser
		WebDriver chDriver= new ChromeDriver();

		//Maximize the browser
		chDriver.manage().window().maximize();
		
		//Apply implicit wait
		chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//launch the url
		chDriver.get(pageURL);

		//Create instance for advanced mouse movements
		Actions objAction = new Actions(chDriver);

		//2. Mouse over the brands
		objAction.moveToElement(chDriver.findElement(By.xpath("//a[text()='brands']"))).build().perform();

		//Wait for few seconds
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("Exception in thread.sleep");
		}

		//3. Click on loreal paris
		chDriver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();

		//4. Check the title contains L'Oreal
		String lOrealTitle= chDriver.getTitle();
		System.out.println(lOrealTitle);
		if(lOrealTitle.contains("Oreal Paris"))
		{
			System.out.println("Title is appropriate");
		}
		else
		{
			System.out.println("Title is not correct");
		}

		//5. Sort by customer top rated
		chDriver.findElement(By.className("sort-name")).click();
		chDriver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}

		//6. Click category-> click Hair -> click haircare->Shampoo
		chDriver.findElement(By.xpath("//div[@id='first-filter']//child::span")).click();
		chDriver.findElement(By.xpath("//span[contains(@class,'filter-name') and text()='Hair']")).click();
		chDriver.findElement(By.xpath("//span[contains(@class,'filter-name') and text()='Hair Care']")).click();
		chDriver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}

		//7. Click Concern->Color Protection
		chDriver.findElement(By.xpath("//span[text()='Concern']")).click();
		chDriver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}

		//8. check whether the filter is applied with Shampoo
		List<WebElement> appliedFiltersList= chDriver.findElements(By.xpath("//span[@class='filter-value']"));
		String filterText="Shampoo";
		boolean filterApplied=false;
		for(WebElement ele: appliedFiltersList)
		{
			if(ele.getText().equals("Shampoo"))
			{
				filterApplied=true;
				break;
			}
		}

		if(filterApplied)
		{
			System.out.println(filterText+" is applied fine");
		}
		else
		{
			System.out.println(filterText+" is not applied fine");
		}


		//9. click on L'Oreal Paris Color Protect Shampoo
		chDriver.findElement(By.xpath("//div[@id='product-list-wrap']//child::a")).click();
		Set<String> allWindowsSet=chDriver.getWindowHandles();
		List<String> allWindowsList= new ArrayList<String>(allWindowsSet);
		String parentWindow="";

		if(allWindowsList.size()>1)
		{
			parentWindow=allWindowsList.get(0);
			chDriver.switchTo().window(allWindowsList.get(allWindowsList.size()-1));
		}


		//10. Go to the new window and select size as 175ml
		Select sizeDropdown= new Select(chDriver.findElement(By.xpath("//select[@title='SIZE']")));
		sizeDropdown.selectByValue("0");

		//11. print the mrp of the product
		String mrpOnProductPage=chDriver.findElement(By.xpath("//span[text()='MRP:']//following-sibling::span")).getText();
		System.out.println("MRP of the product is : "+mrpOnProductPage);

		//12. click on ADD to BAG
		chDriver.findElement(By.xpath("//span[@class='btn-text']")).click();
		
		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}

		//13. Go to Shopping Bag
		chDriver.findElement(By.xpath("//span[@class='cart-count']")).click();
		
		try
		{
			Thread.sleep(5000);
		}catch(InterruptedException e)
		{
			System.out.println("Exception in thread.sleep");
		}

		//14. Print the Grand total amount
		chDriver.switchTo().frame(chDriver.findElement(By.xpath("//iframe[contains(@src,'Cart')]")));
		String carGrandTotalPrice=chDriver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("Grand total on the shopping bag is : "+carGrandTotalPrice);

		//15. Click Proceed
		chDriver.findElement(By.xpath("//span[text()='PROCEED']")).click();

		//16. Click on Continue as Guest
		chDriver.switchTo().defaultContent();
		chDriver.findElement(By.xpath("//button[@class='btn full big']")).click();

		//17. Check if this grand total is same as in step 14
		String checkoutGrandTotalPrice=chDriver.findElement(By.xpath("//div[text()='Grand Total']//following-sibling::div")).getText();
		System.out.println("Grand total on the checkout page is : "+checkoutGrandTotalPrice);
		if(carGrandTotalPrice.equals(checkoutGrandTotalPrice))
		{
			System.out.println("Total is same across pages");
		}
		else
		{
			System.out.println("Total is not same across pages");
		}


		//18. close all windows
		chDriver.quit();

	}
		


}
