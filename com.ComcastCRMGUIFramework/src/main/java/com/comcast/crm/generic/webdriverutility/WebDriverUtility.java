package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitUntilPageLoaded(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void waitUntilElementLoaded(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void switchToSpecificWindow(WebDriver driver, String pageTitle) {
		
		Set<String> allWindowID = driver.getWindowHandles();
		for (String string : allWindowID) {
			driver.switchTo().window(string);
			if (driver.getTitle().equals(pageTitle)) {
				break;
			}
		}
	}
	
	public void selectOption(WebElement element, int index) {
		
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	
	public void selectOption(WebElement element, String visibleText) {
		
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
		
	}
	
	public void switchToFrame(WebDriver driver, String name_or_id) {
		
		driver.switchTo().frame(name_or_id);
		
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		
		driver.switchTo().frame(index);
		
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		
		driver.switchTo().frame(element);
		
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		
		driver.switchTo().alert().accept();
		
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
		
	}

	public String getTextFromAlert(WebDriver driver) {
		
		String text = driver.switchTo().alert().getText();
		return text;
		
	}
}