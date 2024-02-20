package com.report.takeScreenshotProject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
   
	WebDriver driver;
	String url1 = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeClass
	public void setUp() throws Exception {
		driver = new EdgeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@AfterMethod
	public void screenshotIfFailed(ITestResult testResult) throws Exception {
		if (testResult.getStatus() == ITestResult.FAILURE){
			System.out.println("testResult.getStatus()");
			takeScreenshot();
		}
	}
	
	@Test (priority = 1, description = "Failed TC, Take screenshot when failed")
	public void TC001() throws IOException {
		String expectedTitle = "Orange";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected title");
	}
	
	@Test (priority = 0, description = "Passed TC, take some screenshots")
	public void TC002() throws InterruptedException, IOException {
		WebElement usernameInput = driver.findElement(By.name("username"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		usernameInput.sendKeys("Admin");
		passwordInput.sendKeys("admin123");
		
		//take screenshot after input username and password
		takeScreenshot();
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		submitButton.click();
		
		Thread.sleep(3000);
		//take screenshot after login
		takeScreenshot();
	}
	
	
	
    //function to screenshot
    public void processScreenshot(WebDriver driver, String filePath) throws IOException {
        // convert webdriver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        //call getScreenshotAs method to get screenshot
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        //move image file to destination
        File destinationFile = new File(filePath);

        //copy file at destination
        FileHandler.copy(sourceFile, destinationFile);
    }
    
    public void takeScreenshot() throws IOException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HHmmss");
        Date date = new Date();

        processScreenshot(driver, "resources/screenshots/"+formatter.format(date).toString()+".png");
    }
}
