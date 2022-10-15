package com.pages.osapages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	public static WebDriver dr;
	public static HomePagePageFactory k;

	static String basePath = System.getProperty("user.dir");

	public static void main(String[] args) throws InterruptedException {

		add();

	}

	public static void add() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", basePath + "\\src\\test\\resources\\drivers\\windows\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://osaconsultingtech.com/");
		Thread.sleep(3000);
		k = new HomePagePageFactory(dr);
		k.clickOnForumButton();
		k.enterEmailOnForumPage();
		k.enterPasswordOnForumPage();
		k.clickLoginButton();

		// HomePagePageFactory ele = PageFactory.initElements(dr,
		// HomePagePageFactory.class);
//		ele.clickOnForumButton();
//		ele.enterEmailOnForumPage();
//		ele.enterPasswordOnForumPage();
//		ele.clickLoginButton();

		// dr.quit();

	}

}
