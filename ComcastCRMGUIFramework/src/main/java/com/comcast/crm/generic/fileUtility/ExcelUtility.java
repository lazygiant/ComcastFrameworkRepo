package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{

	public String getDataFromExcel(String sheet , int rowNum , int cellNum) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream("./testdata/testscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		String data=workbook.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
		
	}
	public int getRowCount(String sheet) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream("./testdata/testscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		int rowNum = workbook.getSheet(sheet).getLastRowNum();
		
		return rowNum;
	}
	public void setDataIntoExcel(String Sheet, int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fileInputStream = new FileInputStream("./testdata/testscriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		workbook.getSheet("Sheet1").getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fileOutputStream = new FileOutputStream("./testdata/testscriptData.xlsx");
		workbook.write(fileOutputStream);
		
		//To close() is mandatory otherwise in excel side one object will be opened
		workbook.close();
	}
}
