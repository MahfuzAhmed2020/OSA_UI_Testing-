package com.exelfileread.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ToolsQA {
	public static WebDriver dr;
	@Test(dataProvider="loginData",dataProviderClass=CommonDataProvider.class)
	public static void runTools(String browser,String url,String name,String email,String currentAddress,String permanentAddress) throws InterruptedException{
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
		dr=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\windows\\geckodriver.exe");
			dr=new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
			dr=new ChromeDriver();
		}
		dr.get(url);
		dr.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[6]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div")).click();
		dr.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]")).click();
		dr.findElement(By.xpath("//span[text()='Text Box']")).click();
		dr.findElement(By.id("userName")).sendKeys(name);
		
		dr.findElement(By.id("userEmail")).sendKeys(email);
		dr.findElement(By.id("currentAddress")).sendKeys(currentAddress);
		dr.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
		Thread.sleep(4000);
		
		CommonDataProvider.scrollMyScreen(dr, "800");
		Thread.sleep(4000);
		CommonDataProvider.scrollMyScreen(dr, "-300");
		
		Thread.sleep(4000);
	 dr.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		
		/*dr.findElement(By.id("email")).sendKeys(email);
		dr.findElement(By.id("pass")).sendKeys(pass);
		dr.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();*/
		dr.quit();
		
		
	}

}