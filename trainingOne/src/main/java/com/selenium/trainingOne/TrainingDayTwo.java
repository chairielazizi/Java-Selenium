package com.selenium.trainingOne;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TrainingDayTwo {

	public static WebDriver driver;
    public static String orangehrmURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new EdgeDriver();
		driver.get(orangehrmURL);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//validate the login header text
        WebElement loginText = driver.findElement(By.xpath("//h5[contains(@class, 'orangehrm-login-title')]"));
        if(loginText.isDisplayed() != false) {
        	System.out.println("Succcessfully loaded the page");
        }
        
        // find the text field for username and password
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        
        //fill in the username and password
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        System.out.println("Successfully entered the username and password");
        
        //click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        if (loginButton.isDisplayed() != false) {
        	loginButton.click();
        	System.out.println("Successfully clicked the login button");
        }
        Thread.sleep(3000);
        
        
        //validate and click PIM
        WebElement pimOption = driver.findElement(By.xpath("//span[text()='PIM']"));
        if (pimOption.isDisplayed() != false) {
        	pimOption.click();
        	System.out.println("Successfully clicked the pim option");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        
        //validate and click add button
        WebElement addEmployeeButton = driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]"));
        if (addEmployeeButton.isDisplayed() != false) {
        	addEmployeeButton.click();
        }
        
        //initialize the name of employee
        String firstname = getAlphaNumericString(5);
        Random random = new Random();
        String lastname = Integer.toString(random.nextInt(10000));
        System.out.println(firstname);
        System.out.println(lastname);
        
        //enter firstname
        WebElement firstnameInput = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstnameInput.sendKeys(firstname);
        
        WebElement lastnameInput = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastnameInput.sendKeys(lastname);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        WebElement employeeID = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        employeeID.clear();
        employeeID.sendKeys(lastname);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        
        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        if (saveButton.isDisplayed() != false) {
        	saveButton.click();
        	System.out.println("Successfully clicked on save button");
        }
        
        WebElement employeeListButton = driver.findElement(By.xpath("//a[text()='Employee List']"));
        if (employeeListButton.isDisplayed() != false) {
        	employeeListButton.click();
        	System.out.println("Successfully clicked on employee list button");
        }
        
        WebElement employeeNameInput = driver.findElement(By.xpath("(//input[@placeholder=\"Type for hints...\"]) [1]"));
        employeeNameInput.sendKeys(firstname + " " + lastname);
        WebElement employeeDropdown = driver.findElement(By.xpath("//span[contains(text(), '"+firstname+"')]"));
        employeeDropdown.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
        Thread.sleep(2000);
        
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        if (searchButton.isDisplayed() != false) {
        	searchButton.click();
        	System.out.println("Successfully clicked on search button");
        }
        
        WebElement result = driver.findElement(By.xpath("(//div[@class=\"oxd-table-card\"]/div/div/div)[2]"));
        if (result.isDisplayed() != false) {
        	System.out.println("Successfully found the new added employee: " + result.getText());
        }
        
        driver.quit();
        
        
	}
	
	protected static String getAlphaNumericString(int n) 
	 { 
	 
	  // choose a Character random from this String 
	  String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	         + "0123456789"
	         + "abcdefghijklmnopqrstuvxyz"; 
	 
	  // create StringBuffer size of AlphaNumericString 
	  StringBuilder sb = new StringBuilder(n); 
	 
	  for (int i = 0; i < n; i++) { 
	 
	   // generate a random number between 
	   // 0 to AlphaNumericString variable length 
	   int index 
	    = (int)(AlphaNumericString.length() 
	      * Math.random()); 
	 
	   // add Character one by one in end of sb 
	   sb.append(AlphaNumericString 
	      .charAt(index)); 
	  } 
	 
	  return sb.toString(); 
	 } 

}
