package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelFile(String sheetName, int rowNum, int celNum) throws Throwable {

		FileInputStream fis = new FileInputStream("./testData/testscriptsdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(celNum);
		return cell.toString();

	}

	public void setDataToExcelFile(String sheetName, String data, int rowNum, int celNum) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./testData/");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet =  book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testData/testscriptsdata.xlsx");
		book.write(fos);
		book.close();
		
	}
	
	public Object[][] getMultipleDataFromExcelFile(String sheetName) throws Throwable {
	
		FileInputStream fis = new FileInputStream("./testData/testscriptsdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rowNum = sheet.getPhysicalNumberOfRows();
		int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowNum-1][colNum];
		
		for (int i = 1; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				
				data[i-1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
}
