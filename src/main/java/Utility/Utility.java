package Utility;

import java.io.File;
import java.io.IOException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.naveenautomation.TestBase.TestBase;

public class Utility extends TestBase {
	
	public static void takeFailedTestScreenShot(String testCaseName) {
		// Get the current date and Time
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		
		
		String directoryPath = "./FailedScreenShot/";
		 // Create the directory if it doesn't exist
	    File directory = new File(directoryPath);
	    if (!directory.exists()) {
	        if (directory.mkdirs()) {
	            System.out.println("Directory created successfully.");
	        } else {
	            System.out.println("Failed to create directory.");
	            return; // Exit the method if directory creation fails
	        }
	    }
		
		
		
		
		
		
		
	 // Save the screen shot in a file
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot
		try {
			FileUtils.copyFile(screenShotFile,
					new File("./FailedScreenShot/" + testCaseName + timeStamp + ".jpeg"));
		} catch (IOException e) {
			System.out.println("Unable to save or take screen shot of failed test " + testCaseName);

		}

	}


	public static Date generateRandomDate() {
		return new Date();
	}


	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

		}
	}
	

}
	


