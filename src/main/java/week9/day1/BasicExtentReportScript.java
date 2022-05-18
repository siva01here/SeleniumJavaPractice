package week9.day1;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasicExtentReportScript {
	
	public static void main(String[] args) {
		//Step 1 create object for extent html reporter and add the file path for html report
		ExtentHtmlReporter objReporter = new ExtentHtmlReporter("./reports/ExtentReport.html");
		
		//Step 2 create object for extent report
		ExtentReports objExtReport = new ExtentReports();
		
		//Step 3 attach the html report to the extent report object
		objExtReport.attachReporter(objReporter);
		
		//Step 4 create object for extent test
		ExtentTest objExtTest= objExtReport.createTest("Login Test Case", "Login test of the application");
		//Assign category and author using extent test object
		objExtTest.assignAuthor("Sivakumar Ramanan");
		objExtTest.assignCategory("SmokeTest");
		
		//pass or fail the test step with test step description
		objExtTest.pass("Enter Username");
		objExtTest.pass("Enter password");
		
		//Attach the screenshot if in case a failure or pass from the specified path 
		try {
			objExtTest.pass("Click on login button",MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/file.png").build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// flush the extent report instance
		objExtReport.flush();

		
		
	}

}
