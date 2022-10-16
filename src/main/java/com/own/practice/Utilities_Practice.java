package com.own.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilities_Practice {
	static WebDriver dr;

	public static void main(String[] args) {
		Actions act = new Actions(dr);
		act.keyDown(Keys.DOWN);

	}

	public static void scrollMyScreen(WebDriver dr, String pixel) {
		// JavascriptExecutor js = (JavascriptExecutor) dr;
		// js.executeScript("window.scrollBy(0," + pixel + ")");
		// Create JavascriptExecor variable
		JavascriptExecutor js = (JavascriptExecutor) dr;

		// Approachi - number of pixels
		js.executeScript("window.scrollBy(0,2000)", "");

		// Approach - till we found certain element on the web page
		WebElement flag = dr.findElement(By.xpath(""));
		js.executeScript("arguments [0].scrollIntoView();", flag);

		// Appraoch3 - till end of the page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");

	}

}
