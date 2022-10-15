package com.osa.tetes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.osa.base.Browser;
import com.osa.common.App;
import com.osa.exelfile.ExcelOutputInput;

public class ToolsSQA {
	public WebDriver dr;

	@Test(dataProvider = "loginData")
	public void toolSQA(String name, String email, String text, String browser, String perAddress)
			throws InterruptedException {
		dr = Browser.openBrowser(browser);
		dr.get(App.TOOLSQAURL);
		Assert.assertEquals(dr.getTitle(), "Free QA Automation Tools Tutorial for Beginners with Examples");
		// dr.switchTo().alert().dismiss();
		dr.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[6]/a/span/span")).click();
		dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]")).click();
		dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]")).click();
		dr.findElement(By.xpath("//span[text()='Text Box']")).click();
		dr.findElement(By.id("userName")).sendKeys(name);
		dr.findElement(By.id("userEmail")).sendKeys(email);
		dr.findElement(By.id("currentAddress")).sendKeys(text);
		dr.findElement(By.id("permanentAddress")).sendKeys(perAddress);

		Thread.sleep(2000);

		dr.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		dr.quit();
	}

	@DataProvider(name = "loginData")
	public Object[][] testData() {

		// Object[][] sss
		// =ExcelOutputInput.getValue("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx",
		// "Sheet2");
		// Object[][] sss
		// =ExcelOutputInput.getValue("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx",
		// "Sheet2");
		Object[][] ss = ExcelOutputInput.getValue("C:\\Users\\mahfu\\Desktop\\ExelTemp\\TestDemo.xlsx", "Sheet3");
		// String [][] data= {{"userName","password"},{"userName1","password1"}};
		return ss;

	}

}
