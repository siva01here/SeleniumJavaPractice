package week6.day1.assignments;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment2_TestngAttributes {
	
	@BeforeSuite
	public void beforeSuiteMethod()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTestMethod()
	{
		System.out.println("Before Test");
	}
	
	@BeforeClass
	public void beforeClassMethod()
	{
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@Test(invocationCount=5, enabled=true, priority=-1)
	public void testMethod1()
	{
		System.out.println("Test Method 1 is executed");
	}
	
	@Test(priority=0, enabled=false)
	public void testMethod2()
	{
		System.out.println("Test Method 2 is executed");
	}
	
	@Test(priority=1, enabled=true, dependsOnMethods="testMethod1")
	public void testMethod3()
	{
		System.out.println("Test Method 3 is executed");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After suite method");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After test method");
	}
	
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After class method");
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After method");
	}
	
	

}
