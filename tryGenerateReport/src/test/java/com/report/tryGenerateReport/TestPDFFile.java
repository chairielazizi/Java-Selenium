package com.report.tryGenerateReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPDFFile {

	public TestPDFFile() {
		// TODO Auto-generated constructor stub
	}
	
	WebDriver driver;
	@BeforeClass
	public void setUp(){
//		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\browserdrivers\\chromedriver.exe");
		driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	@Test(priority=1, description="Sample Test Fail Reported in PDF")
	public void testMethod1() {
	String expectedTitle = "TestingFailed";
	Assert.assertEquals(driver.getTitle(), expectedTitle, "Title not matched"); 
	}
	@Test(priority=0, description="Sample Test Pass Reported in PDF")
	public void testMethod2() {
	boolean matchCondition = driver.getTitle().contains("Google");
	Assert.assertTrue(matchCondition, "Title matched");
	}

}
