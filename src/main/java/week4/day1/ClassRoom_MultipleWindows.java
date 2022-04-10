package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom_MultipleWindows {
	
	public static void main(String[] args) {
		String URL="https://www.irctc.co.in/";
		
		//Set up the chrome browser
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser
		WebDriver chDriver= new ChromeDriver();
		
		//Load the URL
		chDriver.get(URL);
		
		//Maximize the window
		chDriver.manage().window().maximize();
		
		//Apply implicit wait
		chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click on ok button
		chDriver.findElement(By.xpath("//button[text()='OK']")).click();
		
		//Click on flights
		chDriver.findElement(By.linkText("FLIGHTS")).click();
		
		//Get all window handles
		Set<String> allWindowsSet= chDriver.getWindowHandles();
		
		//convert set of windows to list for switching between them
		List<String> allWindowsList= new ArrayList<String>(allWindowsSet);
		String parentWindow="";
		
		if(allWindowsList.size()>0)
		{
			parentWindow=allWindowsList.get(0);
		}
		
		//Switch to last window
		chDriver.switchTo().window(allWindowsList.get(allWindowsList.size()-1));
		
		//Print the title
		System.out.println("Title of another window is : "+chDriver.getTitle());
		
		//Close the last window
		chDriver.close();
		
		//Switch to parent window
		chDriver.switchTo().window(parentWindow);
		
		//Print the title of parent window
		System.out.println("Title of parent window is : "+chDriver.getTitle());
		
		
		
		
		
		
	}

}
