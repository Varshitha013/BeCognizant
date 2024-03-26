package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	static FileInputStream fileInputStream;
	static FileOutputStream fileOutputStream;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
	public String readExcelData(String sheetName,int rowNumber,int cellNumber) throws IOException {
		
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Featured_News_Test_Data.xlsx");
		
		workbook = new XSSFWorkbook(fileInputStream);
		
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(rowNumber);
		
		cell = row.getCell(cellNumber);
		
		workbook.close();
		
		fileInputStream.close();
		
		return cell.toString();
		
	}
	
	public static void writeData(String sheetName,int rowNumber,int cellNumber,String data) throws IOException {
		
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Featured_News_Test_Data.xlsx");
		
		workbook = new XSSFWorkbook(fileInputStream);
		
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.createRow(rowNumber);
		
		cell = row.createCell(cellNumber);
		
		cell.setCellValue(data);
		
		fileOutputStream = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\Featured_News_Test_Data.xlsx");
		
		workbook.write(fileOutputStream);
		
		workbook.close();
		
		fileInputStream.close();
		
		fileOutputStream.close();
	}

}
