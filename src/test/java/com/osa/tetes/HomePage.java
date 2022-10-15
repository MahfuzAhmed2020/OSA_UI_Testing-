package com.osa.tetes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.osa.base.Browser;
import com.osa.common.App;

public class HomePage {
	public WebDriver dr;
	
	
	@Test(priority = 0)
	@Parameters("browserName")
	public void verifyHomePageTitle(String browser) {
		dr=Browser.openBrowser(browser);
		dr.get(App.URL);
		String homePageTitle=dr.getTitle();
		Assert.assertEquals(homePageTitle, "OSA Consulting Tech Corp || Best Available Resources For Software Industry");	
		
	}

	@Test(priority = 1 )
	public void clickOnForumLoginButton() {
		dr.findElement(By.xpath("//a[text()='Forum Login']")).click();
	}
	@Test(priority = 2)
	public void verifyLogin() {
		dr.findElement(By.id("username")).sendKeys("xyz@gmail.com");
		dr.findElement(By.id("password")).sendKeys("64545ggfdgfd");
		dr.findElement(By.xpath("//*[@id=\"login_button\"]")).click();
	}
	
	@Test(priority = 3)
	public void closingBrowser() {
		dr.close();
	}

}
