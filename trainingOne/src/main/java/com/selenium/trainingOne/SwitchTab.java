package com.selenium.trainingOne;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class SwitchTab {

	public SwitchTab() {
		// TODO Auto-generated constructor stub
	}
	
	public static WebDriver driver;
	public static String url = "https://webdriveruniversity.com/";

	public static void main(String[] args) throws InterruptedException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(4000);
		
		//to store tabs
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		WebElement contactUsLink = driver.findElement(By.id("contact-us"));
//		System.out.println("Tab size " + tabs.size());
		contactUsLink.click();
//		System.out.println("Tab size " + tabs.size());
//		
//		driver.switchTo().window(tabs.get(1));
//		System.out.println("Change to new tab");
//		
//		Thread.sleep(3000);
//		
//		driver.switchTo().window(tabs.get(0));
//		Thread.sleep(2000);
//		driver.switchTo().window(tabs.get(1));
		
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
//		System.out.println("ctrl + tab");
//		Thread.sleep(2000);
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.SHIFT).build().perform();
//		System.out.println("ctrl + shift");
		
		String currentTab = driver.getWindowHandle();
		
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(currentTab)) {
				driver.switchTo().window(tab);
			}
		}
		
		driver.quit();
		

	}

}
