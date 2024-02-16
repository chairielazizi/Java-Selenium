package com.selenium.trainingOne;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrainingExcelMethod {

	public static WebDriver driver;
	public static String urlOne = "https://qa.simplifyqa.app/login";
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		driver = new EdgeDriver();
		driver.get(urlOne);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
//		Credentials satu = new Credentials("nama", "password");
//		satu.toString();
//		WebElement loginInput = driver.findElement(By.xpath("//input[@name=\"email\"]"));
//		loginInput.sendKeys(Credentials.username);
//		
//		WebElement loginButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
//		loginButton.click();
//		
//		WebElement passwordInput = driver.findElement(By.xpath("//input[@name=\"password\"]"));
//		passwordInput.sendKeys(Credentials.password);
//		
//		WebElement loginButton1 = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
//		loginButton1.click();
		
//		WebElement logoIcon = driver.findElement(By.xpath("//img[@alt=\"Logo icon\"]"));
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.visibilityOf(logoIcon));
//		if (logoIcon.isDisplayed() != false) {
//			System.out.println("Successfully logged in to SQA website");
//		}
//		else {
//			System.out.println("Logo not found");
//		}
//		
//		
//		WebElement sidebarButton = driver.findElement(By.xpath("//i[contains(@class, 'menu-sidebar-toggler')]"));
//		Thread.sleep(3000);
//		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait4.until(ExpectedConditions.elementToBeClickable(sidebarButton));
////		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sidebarButton);
//		if(sidebarButton.isDisplayed() != false) {
//			sidebarButton.click();
//			System.out.println("Sidebar clicked");
//		}
		
//		WebElement executionPlanOption = driver.findElement(By.xpath("//a[@href=\"/user/executionplan\"]"));
////		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
////		wait2.until(ExpectedConditions.elementToBeClickable(executionPlanOption));
//		if(executionPlanOption.isDisplayed() != false) {
//			executionPlanOption.click();
//			System.out.println("Execution plan clicked");
//		}
//		
//		WebElement firstRowExecutionPlan = driver.findElement(By.xpath("(//tbody/tr[2]/td/div) [1]"));
////		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));
////        wait3.until(ExpectedConditions.visibilityOf(firstRowExecutionPlan));
//        if (executionPlanOption.isDisplayed() != false) {
//        	firstRowExecutionPlan.click();
//        	System.out.println("Execution plan first row clicked");
//        }
//        
//        WebElement excelDownloadButon = driver.findElement(By.xpath("//img[@alt=\"excel-icon\"]"));
//        if (excelDownloadButon.isDisplayed() != false) {
////        	excelDownloadButon.click();
//        	System.out.println("Excel download is clicked");
//        }
        
        FileInputStream file = new FileInputStream("C:\\Users\\Chairiel Azizi\\Downloads\\Chaiqq 141 Executionzz.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet1 = workbook.getSheet("Sheet 1");
        XSSFRow row1 = sheet1.getRow(1);
        XSSFCell cell1 = row1.getCell(0);
        String cellPrint1 = cell1.getStringCellValue();
        System.out.println("The row 2 and column 1 is: "+ cellPrint1);
        
        XSSFRow row2 = sheet1.getRow(4);
        XSSFCell cell2 = row2.getCell(0);
        String cellPrint2 = cell2.getStringCellValue();
        System.out.println("The row 5 and column 1 is : " + cellPrint2);
        
        //get row count in excel
        int rowCount = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
        System.out.println("The row count is : " + rowCount+1);
        
        for (int i = 0; i < rowCount+1; i++) {
        	int cellcount = sheet1.getRow(i).getLastCellNum();
        	for (int j = 0; j < cellcount; j++) {
        		System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue() + ",");
        	}
        	System.out.println();
        	
        }
        
        workbook.close();

        
		
		driver.quit();
	}

}
;