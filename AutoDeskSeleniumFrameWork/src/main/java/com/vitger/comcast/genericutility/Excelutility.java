package com.vitger.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./Data/Book.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
		public String getRowcount(String sheetName) throws EncryptedDocumentException, IOException  {
			FileInputStream fis = new FileInputStream("./Data/Book.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			return sheetName;
		
	}
		/**
		 * 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @param data
		 * @return
		 * @throws Throwable 
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public String setDataExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable  {
			FileInputStream fis = new FileInputStream("./Data/Book.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cell = row.createCell(celNum);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream("./Data/Book.xlsx");
		    wb.write(fos);
		    wb.close();
			return data;
		}

}
