package com.osa.tetes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.osa.base.Browser;
import com.osa.common.App;

public class HomePageExcel {

	public WebDriver dr;

	@Test(priority = 0)
	@Parameters("browserName")
	public void verifyHomePageTitle(String browser) {
		dr = Browser.openBrowser(browser);
		dr.get(App.URL);
		String homePageTitle = dr.getTitle();
		Assert.assertEquals(homePageTitle,
				"OSA Consulting Tech Corp || Best Available Resources For Software Industry");
		dr.findElement(By.xpath("//a[text()='Forum Login']")).click();
		dr.findElement(By.id("username")).sendKeys("xyz@gmail.com");
		dr.findElement(By.id("password")).sendKeys("64545ggfdgfd");
		dr.findElement(By.xpath("//*[@id=\"login_button\"]")).click();
		dr.close();
		
		}

}
