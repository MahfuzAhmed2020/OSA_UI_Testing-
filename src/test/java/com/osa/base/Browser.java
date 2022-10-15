package com.osa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.osa.common.App;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {	
	public static void main(String[] args) {
		openBrowser("firefox") ;
		
	}
	static WebDriver dr=null;
	static String basePath=System.getProperty("user.dir");
	public static WebDriver openBrowser(String browser) {

		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			getBrowserForWindows(browser);
		}else {
			getBrowserForMac(browser);
		}
		return dr;
	}
	public static WebDriver getBrowserForWindows(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
			 dr=new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", basePath+"\\src\\test\\resources\\drivers\\DriversNew\\chromedriver.exe");
			 dr= new ChromeDriver();
		}else {//C:\Users\mahfu\Desktop\OSA0130202007B\OSA_UI_Testing (2)\OSA_UI_Testing\src\test\resources\drivers\windows\chromedriver.exe
			System.out.println("You have entered "+ browser+" that does not exist. Please either chrome or firefox");
		}
		return dr;
	}
	
	
	public static void getBrowserForMac(String browser) {
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\test\\resources\\drivers\\mac\\geckodriver");
			 dr=new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", basePath+"\\src\\test\\resources\\drivers\\mac\\chromedriver");
			 dr= new ChromeDriver();
		}else {
			System.out.println("You have entered "+ browser+" that does not exist. Please either chrome or firefox");
		}
	}
	
	/*//  bonigarcia
	  
	  public static void getBrowserForWindows(String browser) {
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dr = new FirefoxDriver();
		}else {
			System.out.println("The browser path is not executeble");
		}
		
	}
	
	public static void getBrowserForMac(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr = new ChromeDriver();
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dr = new FirefoxDriver();
		}else {
			System.out.println("The browser path is not executeble");
		}
	}
	 *<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>4.3.1</version>
	</dependency> 
	 * */
	

}
