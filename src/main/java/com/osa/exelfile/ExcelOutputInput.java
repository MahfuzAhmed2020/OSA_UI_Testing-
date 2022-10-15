package com.osa.exelfile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOutputInput {

	public static void main(String[] args) {
		
		
		inputUdemyExel("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx", "EclipseExcel");
		
		Object[][] s = getValue("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx", "Sheet3");
		for (Object[] s1 : s) {
			for (Object o : s1) {
				System.out.print(o + "    ");
			}
			System.out.println();
		}

		Object[][] r = getValue("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx", "Sheet1");
		for (Object[] s1 : r) {
			for (Object k : s1) {
				System.out.print(k + "    ");
			}
			System.out.println();
		}
		//outputUdemyExel("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx");

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
			System.out.println("rowSize = "+rowSize + "\ncolSize =" + colSize);
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

/*	public static void outputUdemyExel(String filePath) {

		try {
			FileOutputStream fileOutput = new FileOutputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("EclipseExc");
	//System.out.println("rowSize = "+rowSize + "\ncolSize =" + colSize);
			for (int i = 0; i < 2; i++) {
				XSSFRow row = sheet.createRow(i);
				for (int j = 0; j < 3; j++) {
					 row.createCell(j).setCellValue("dhaka");
				}
				
			}
			workbook.write(fileOutput);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}*/
	
	
	public static Object[][] inputUdemyExel(String filePath, String sheetName) {
		DataFormatter formate = new DataFormatter();
		Object [][]value=null;
		try {
			FileInputStream fileInput = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowSize = sheet.getPhysicalNumberOfRows();
			int colSize = sheet.getRow(0).getLastCellNum();
			value = new Object[rowSize][colSize];
			
			System.out.println("rowSize = "+rowSize + "\ncolSize =" + colSize);
			for (int i = 0; i < rowSize; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < colSize; j++) {
					XSSFCell cell = row.getCell(j);
					//cell.toString().trim();
					 value[i][j]=	formate.formatCellValue(cell).toString().trim();
				
				System.out.print(value+"    ");
				
				}
				System.out.println();
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
return value;
	}
	

}
