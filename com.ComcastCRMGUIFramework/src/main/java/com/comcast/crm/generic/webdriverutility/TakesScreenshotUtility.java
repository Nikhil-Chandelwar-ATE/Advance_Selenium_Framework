package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakesScreenshotUtility {

	public void takeScreenshot(WebDriver driver) throws Throwable {

		Date currentDate = new Date();
		String time = currentDate.toString().replace(" ", "-").replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+time+".png");
		FileHandler.copy(src, dest);
	}
}
