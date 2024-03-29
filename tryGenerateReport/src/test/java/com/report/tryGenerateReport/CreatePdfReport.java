package com.report.tryGenerateReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdfReport {

	public CreatePdfReport() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Document docu;
	
	public void openPdfPath() throws FileNotFoundException, DocumentException{
		String fileName = new File("C:\\Users\\Chairiel Azizi\\Documents\\Coding\\eclispe\\tryGenerateReport\\report").getAbsoluteFile().toString()+"/pdf-"+System.currentTimeMillis()+".pdf";
		FileOutputStream fos = new FileOutputStream(fileName);
		docu = new Document();
		PdfWriter.getInstance(docu, fos);
		docu.open();
	}
	public void addData(String authorName, String title, String description){
		docu.addAuthor(authorName);
		docu.addTitle(title);
		docu.addSubject(description);
		}
	public void addParagraph(String text) throws DocumentException{
		docu.add(new Paragraph(text));
	}
	public void addImage(Image img) throws DocumentException {
		docu.add(img);
	}
	public void closePdf(){
		docu.close();
	}

}
