package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4_FramesTest {
	
	public static void main(String[] args) {
			//Pageurl
			String pageURL="http://leafground.com/pages/frame.html";

			//Set up the chrome browser
			WebDriverManager.chromedriver().setup();

			//Launch the chrome browser
			WebDriver chDriver= new ChromeDriver();

			//Maximize the browser
			chDriver.manage().window().maximize();

			//launch the url
			chDriver.get(pageURL);

			//Switch to first frame
			WebElement iframe1=chDriver.findElement(By.xpath("//iframe[contains(@src,'default')]"));
			chDriver.switchTo().frame(iframe1);

			//Take the screenshot of click me button of first frame
			WebElement clickMeButtonEle = chDriver.findElement(By.id("Click"));

			File srcScreenshot=clickMeButtonEle.getScreenshotAs(OutputType.FILE);

			try {
				String fileName=LocalDateTime.now().toString().replaceAll("[^0-9a-zA-z]", "").trim();
				FileUtils.copyFile(srcScreenshot,new File("D:\\Eclipse Workspace\\SeleniumJavaPractice\\src\\Screenshots\\"+fileName+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Switch to default content
			chDriver.switchTo().defaultContent();
			
			//Find the number of frames in the page
			List<WebElement> allFramesList=chDriver.findElements(By.xpath("//iframe"));

			System.out.println("Total number of frames in the page is : "+allFramesList.size());
			
			//close the browser
			chDriver.close();
}

}
