package com.selenium.trainingOne;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    public WebDriver driver;
    public String URLone = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeTest
    public void setup() throws InterruptedException {
    	driver = new EdgeDriver();
    	driver.manage().window().maximize();
    	driver.get(URLone);
    	Thread.sleep(3000);
    }
    
    @AfterTest
    public void done() {
    	driver.quit();
    }
    
    @Test
    public void testcase01() {
    	String getUrl = driver.getCurrentUrl();
    	System.out.println("The current url is "+getUrl);
    	
    	//Get the current title and verify the title
        String websiteTitle = driver.getTitle();
//        assertEquals("OrangeHRM", websiteTitle);
        System.out.printf("The website title is: %s\n", websiteTitle);
        
        WebElement loginText = driver.findElement(By.xpath("//h5[contains(@class, 'orangehrm-login-title')]"));
        
        boolean loginExist = loginText.isDisplayed();
        if(loginExist) {
        	System.out.println("The login header is exists");
        }
        else {
        	System.out.println("The login header does not exist");
        }
    }
    
    @Test
	public void testcase02(){
    	//get username field
        driver.findElement(By.name("username")).sendKeys("Admin");
        //get password field
        driver.findElement(By.name("password")).sendKeys("admin123");
        //click login button
        driver.findElement(By.xpath("//button[1]")).click();
    }
}
