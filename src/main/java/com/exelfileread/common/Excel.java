package com.exelfileread.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void main(String[] args) {
		Object[][] value=getValue("\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx", "labor");
for(Object a[]:value) {
	
	for(Object p:a) {
		
		System.out.print(p+"   ");
	}
	System.out.println();
}
		
		
	}

	public static Object[][] getValue(String filePath, String sheetName) {
		Object[][] value = null;
		DataFormatter formate = new DataFormatter();
		try {
			FileInputStream fileInput = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowSize = sheet.getPhysicalNumberOfRows();
			int colSize = sheet.getRow(0).getLastCellNum();
			value = new Object[rowSize][colSize];
			//System.out.println("rowSize = "+rowSize + "\ncolSize =" + colSize);
			Iterator<Row> rowIterator = sheet.rowIterator();
			int rowNumber = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int colNumber = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					value[rowNumber][colNumber] = formate.formatCellValue(cell).trim();
					colNumber++;
				}
				rowNumber++;
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return value;
	}

}
