package com.selenium.trainingOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static WebDriver driver;
    public static String orangehrmURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    
    public static void main( String[] args ) throws InterruptedException {
//        System.out.println( "Hello World!" );
    	driver = new EdgeDriver();
    	driver.manage().window().maximize();
    	driver.get(orangehrmURL);
    	Thread.sleep(3000);
//    	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    	
    	//print current url
    	
    	String getUrl = driver.getCurrentUrl();
    	System.out.println("The current url is: "+getUrl);
    	
    	//Get the current website title and verify the title
        String websiteTitle = driver.getTitle();
        System.out.printf("The website title is: %s\n", websiteTitle);
        
        // to validate the Login header text
        WebElement loginText = driver.findElement(By.xpath("//h5[contains(@class, 'orangehrm-login-title')]"));
        
        //verify the Login header is exist
        boolean loginExist = loginText.isDisplayed();
        if(loginExist) {
        	System.out.println("The login header is exists");
        }
        else {
        	System.out.println("The login header does not exist");
        }
        
        //exit the browser
        driver.quit();
    }
}
