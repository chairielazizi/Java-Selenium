package com.selenium.trainingOne;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PDFTest {

	public PDFTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static PDDocument pdf1;
	public static File file;
	
	@BeforeTest
	public void setup() throws Exception {
		file = new File("C:\\Users\\Chairiel Azizi\\Downloads\\Documents\\testpdf.pdf");
		pdf1 = Loader.loadPDF(file);
		
	}
	
	@AfterTest
	public void quit() throws IOException {
		pdf1.close();
	}
	
	@Test
	public void testcase01() throws IOException {
		PDPage page1 = pdf1.getPage(0);
		
		PDImageXObject image1 = PDImageXObject.createFromFile("C:\\Users\\Chairiel Azizi\\Downloads\\Documents\\Trees-22.jpg", pdf1);
		
		PDPageContentStream content1 = new PDPageContentStream(pdf1, page1);
		
		content1.drawImage(image1, 55, 20, 200, 200);;
		System.out.println("Printed on pdf!");
		
		content1.close();
		pdf1.save("C:\\Users\\Chairiel Azizi\\Downloads\\Documents\\pdf1.pdf");
	}
	
	

}
