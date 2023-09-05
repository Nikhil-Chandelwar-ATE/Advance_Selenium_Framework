package com.comcast.crm.basetest;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.TakesScreenshotUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;

public class BaseTest {

	public WebDriver driver = null;
	public FileUtility fileLib = new FileUtility();
	public WebDriverUtility webDriverLib = new WebDriverUtility();
	public ExcelUtility excelLib = new ExcelUtility();
	public JavaUtility javaLib = new JavaUtility();
	public TakesScreenshotUtility screenshot = new TakesScreenshotUtility();
	public static WebDriver sDriver;
	Date date;
	
	//@Parameters("browser")
	@BeforeClass(groups = {"regressionTest","smokeTest"})
	public void launchBrowser() throws IOException {
		String BROWSER = fileLib.getDataFromProprtyFile("browser");
		String URL = fileLib.getDataFromProprtyFile("url");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		System.out.println("===== Browser launched successfully =====");
	}
	
	@BeforeMethod(groups = {"regressionTest","smokeTest"})
	public void login(ITestResult result) throws IOException {
		String USERNAME = fileLib.getDataFromProprtyFile("username");
		String PASSWORD = fileLib.getDataFromProprtyFile("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(USERNAME, PASSWORD);
		System.out.println("===== User logged in successfully =====");
	}
	
	@AfterMethod(groups = {"regressionTest","smokeTest"})
	public void logout() {
		Actions action = new Actions(driver);
		HomePage homePage = new HomePage(driver);
		action.moveToElement(homePage.getAdministratorImage()).perform();
		homePage.getSignOutLink().click();
		System.out.println("===== User logged out successfully =====");
	}
	
	@AfterClass(groups = {"regressionTest","smokeTest"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("===== Browser closed successfully =====");

	}
}
