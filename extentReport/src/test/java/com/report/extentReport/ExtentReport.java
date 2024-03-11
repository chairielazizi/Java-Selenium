package com.report.extentReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public ExtentReport() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private WebDriver driver;
	private String url1 = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	//create html reporter object
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1, test2;
	
	@BeforeSuite
	public void setUp() throws Exception {
		htmlReporter = new ExtentSparkReporter("extentReport.html");
		
		//create extent report and attach to it
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//initialize web driver
		driver = new EdgeDriver();
		driver.get(url1);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
//			driver.close();
		driver.quit();
		extent.getStats();
//		test1.pass("Closed the browser");
		test2.pass("Closed the browser");
		
		test1.info("test completed");
		test2.info("test completed");
		
		//write the result
		extent.flush();
	}
	
	@Test (priority = 0, description = "")
	public void TC001() throws Exception {
		test1 = extent.createTest("Testcase 001", "Failed TC example, validate the website title");
		test1.log(Status.INFO, "Starting test case");
		
		test1.pass("done maximize the window");
		
		String expectedTitle = "Orange";
		String actualTitle = driver.getTitle();
		test1.info("Checking whether [" + expectedTitle + "] to be the same as [" + actualTitle + "]");
		
//		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match expected title");
		boolean verifyTitle = actualTitle.equalsIgnoreCase(expectedTitle);
		if (verifyTitle) {
			test1.pass("The titles are matched");
		}
		else {
			test1.fail("The titles are not matched");
			
		}
		
		Assert.assertTrue(verifyTitle);
	}
	
	@Test (priority = 0, description = "")
	public void TC002() throws InterruptedException, IOException {
		test2 = extent.createTest("Testcase 002", "Passed TC example, login to website");
		test2.log(Status.INFO, "Starting test case");
		
		WebElement usernameInput = driver.findElement(By.name("username"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		
		usernameInput.sendKeys("Admin");
		if(usernameInput.getText()=="Admin") {			
			test2.pass("Input valid username");
		}
		else {
			test2.fail("Username not entered");
		}
		passwordInput.sendKeys("admin123");
		if(passwordInput.getText()=="admin123") {			
			test2.pass("Input valid password");
		}
		else {
			test2.fail("Password not entered");

		}
		
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		submitButton.click();
		test2.pass("Click the submit button");
		
		
		Thread.sleep(3000);
	}

}
