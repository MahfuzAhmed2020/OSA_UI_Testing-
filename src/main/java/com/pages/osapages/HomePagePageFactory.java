package com.pages.osapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePagePageFactory {

	public WebDriver dr;

	public HomePagePageFactory(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = "//a[text()='Forum']")
	WebElement Forum;
	@FindBy(xpath = "//*[@id=\"ftco-nav\"]/ul/li[5]/a")
	WebElement blog;
	@FindBy(id = "username")
	WebElement email;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "login_button")
	WebElement login_button;

	public void clickOnForumButton() {
		Forum.click();
	}

	public void enterEmailOnForumPage() {
		email.sendKeys("abc@yahoo.com");
	}

	public void enterPasswordOnForumPage() {
		password.sendKeys("123hkhkk14");
	}

	public void clickLoginButton() {
		login_button.click();
	}

}
