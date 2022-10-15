package com.exelfileread.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class Facfebook {
public static WebDriver dr;
//	public static void main(String[] args) {
//		//runTools("chrome","https://www.facebook.com/login.php","hgdggdgh","32136594");	
//	}
	
	
	@Test(dataProvider="facebookData",dataProviderClass=CommonDataProvider.class)
	public static void runTools(String browser,String url,String email,String pass){
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
		
			Actions act = new Actions(dr); //where driver is WebDriver type
			
			
			act.moveToElement(dr.findElement(By.id("email"))).perform();//mouseover
			act.contextClick().perform();//for right click"
		
		dr.findElement(By.id("email")).sendKeys(email);
		dr.findElement(By.id("pass")).sendKeys(pass);
		dr.findElement(By.xpath("//button[@id='loginbutton']")).click();
		dr.quit();
		
		
	}

	

	
	
}
