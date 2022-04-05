package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1_Facebook {
	
	public static void main(String[] args) {
		//1. Set up the binaries for chrome driver
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		//2. Launch the chrome browser
		ChromeDriver chDriver = new ChromeDriver();
		
		//3. Load the URL
		String appURL="https://en-gb.facebook.com/";
		chDriver.get(appURL);
		
		//4. Maximize the browser
		chDriver.manage().window().maximize();
		
		//5. Add implicitwait
		int timeUnit=10;
		chDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeUnit));
		
		//6. Click on create new account
		chDriver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		//7. Enter Firstname, lastName, email and password
		String fName="TestFName";
		String lName="TestLName";
		String emailAddr="Test_123@yahoo.com";
		String pwd="Test@123";
		chDriver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fName);
		chDriver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lName);
		chDriver.findElement(By.xpath("//div[text()='Mobile number or email address']//following-sibling::input[contains(@name,'reg_email')]")).sendKeys(emailAddr);
		chDriver.findElement(By.xpath("//div[text()='New password']//following-sibling::input")).sendKeys(pwd);
		
		//8. Handle drop downs
		WebElement dayEle= chDriver.findElement(By.id("day"));
		Select objDay= new Select(dayEle);
		objDay.selectByVisibleText("28");
		
		String selectedDOB=objDay.getFirstSelectedOption().getText()+"-";
		
		//Select month
		WebElement monthEle= chDriver.findElement(By.id("month"));
		Select objMonth= new Select(monthEle);
		objMonth.selectByIndex(4);
		
		selectedDOB+=objMonth.getFirstSelectedOption().getText()+"-";
		
		//Select year
		WebElement yearEle= chDriver.findElement(By.id("year"));
		Select objYear= new Select(yearEle);
		objYear.selectByValue("1975");
		
		selectedDOB+=objYear.getFirstSelectedOption().getText();
		System.out.println("Selected Date of birth is : "+selectedDOB);
		
		//9. Select the female radio button
		//Verify radio button is selected or not 
		WebElement femaleRadioButton=chDriver.findElement(By.xpath("//label[text()='Female']//following-sibling::input"));
		if(femaleRadioButton.isSelected())
		{
			System.out.println("Female Radio button is selected");
		}
		else
		{
			System.out.println("Female Radio button is not selected, click on the button");
		}
		
		femaleRadioButton.click();
		
		if(femaleRadioButton.isSelected())
		{
			System.out.println("Female Radio button is selected");
		}
		else
		{
			System.out.println("Female Radio button is not selected");
		}
	}
	

}
