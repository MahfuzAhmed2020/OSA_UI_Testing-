package com.exelfileread.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;



public class CommonDataProvider {
	
	

	@DataProvider(name = "facebookData")
	public Object[][] facebookDataLogin() {

		Object[][] value = CommonExcelReader.getValueFromExelFile("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx",
				"facebook");

		return value;
	}
	

	@DataProvider(name = "loginData")
	public Object[][] getDataLogin() {

		Object[][] value = CommonExcelReader.getValueFromExelFile("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx",
				"toolsqa");

		return value;
	}
	
	
	public static void scrollMyScreen(WebDriver dr,String pixel) {
		
		JavascriptExecutor js = (JavascriptExecutor) dr;  
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	
	
	
	

}
