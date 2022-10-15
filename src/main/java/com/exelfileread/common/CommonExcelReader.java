package com.exelfileread.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonExcelReader {

	public static void main(String[] args) {
		Object[][] value = getValueFromExelFile("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx", "Sheet4");
		for (Object s[] : value) {
			for (Object p : s) {
				System.out.println(p);
			}
		}
	}

	public static Object[][] getValueFromExelFile(String excelPath, String sheetName) {
		DataFormatter format = new DataFormatter();
		Object[][] value = null;
		try {
			FileInputStream fileInput = new FileInputStream(new File(excelPath));
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowNum = sheet.getPhysicalNumberOfRows();
			int cellNum = sheet.getRow(0).getLastCellNum();
			value = new Object[rowNum][cellNum];

			Iterator<Row> rowIterator = sheet.rowIterator();
			int rowNumber = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int cellNumber = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					value[rowNumber][cellNumber] = format.formatCellValue(cell).toString().trim();
					cellNumber++;
				}
				rowNumber++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

}
