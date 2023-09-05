package com.comcast.crm.contacttest.suite;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseTest;
import com.comcast.crm.listenersutility.ListenersImplementation;
import com.comcast.crm.objectrepository.ContactInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;

public class ContactTest extends BaseTest {

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {

		int randomNumber = javaLib.getRandomNumber();
		String lastName = excelLib.getDataFromExcelFile("Contact", 1, 2) + randomNumber;

		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactImage().click();

		CreatingNewContactPage creatingContact = new CreatingNewContactPage(driver);
		creatingContact.getLastNameTextField().sendKeys(lastName);
		creatingContact.getSaveButton().click();

		ContactInformationPage contactInfo = new ContactInformationPage(driver);
		contactInfo.getContactInformation().getText();
		webDriverLib.waitUntilElementLoaded(driver, contactInfo.getContactInformation());

		if (contactInfo.getContactInformation().getText().contains(lastName)) {
			ListenersImplementation.test.log(Status.PASS, contactInfo.getContactInformation().getText());
		} else {
			ListenersImplementation.test.log(Status.FAIL, "========== Fail ==========");
		}
	}
	
	@Test(groups = "regressionTest")
	public void createContactWithOrganizationTest() throws Throwable {
		
		int randomNumber = javaLib.getRandomNumber();
		String lastName = excelLib.getDataFromExcelFile("Contact", 1, 2) + randomNumber;
		
		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
		
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactImage().click();
		
		CreatingNewContactPage creatingContact = new CreatingNewContactPage(driver);
		creatingContact.getLastNameTextField().sendKeys(lastName);
		creatingContact.getAddOrganizationImage().click();
		
		String parentID = driver.getWindowHandle();
		Set<String> allWindoID = driver.getWindowHandles();
		allWindoID.remove(parentID);
		for (String string : allWindoID) {
			driver.switchTo().window(string);
			driver.findElement(By.cssSelector("[id='1']")).click();
		}
		driver.switchTo().window(parentID);
		creatingContact.getSaveButton().click();
		
		ContactInformationPage contactInfo = new ContactInformationPage(driver);
		contactInfo.getContactInformation().getText();
		webDriverLib.waitUntilElementLoaded(driver, contactInfo.getContactInformation());
		if (contactInfo.getContactInformation().getText().contains(lastName)) {
			ListenersImplementation.test.log(Status.PASS, contactInfo.getContactInformation().getText());
			ListenersImplementation.test.log(Status.PASS, contactInfo.getOrganizationName().getText());
		} else {
			ListenersImplementation.test.log(Status.FAIL, "========== Fail ==========");
		}
	}
	
	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		
		int randomNumber = javaLib.getRandomNumber();
		String lastName = excelLib.getDataFromExcelFile("Contact", 1, 2) + randomNumber;

		HomePage homePage = new HomePage(driver);
		homePage.getContactsLink().click();
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactImage().click();

		CreatingNewContactPage creatingContact = new CreatingNewContactPage(driver);
		creatingContact.getLastNameTextField().sendKeys(lastName);
		String currentDate = javaLib.getSystemDateYYYYMMDD();
		creatingContact.getSupportStartDate().clear();
		creatingContact.getSupportStartDate().sendKeys(currentDate);
		String futureDate = javaLib.getSystemDateYYYYMMDD();
		creatingContact.getSupportEndDate().clear();
		creatingContact.getSupportEndDate().sendKeys(futureDate);
		creatingContact.getSaveButton().click();

		ContactInformationPage contactInfo = new ContactInformationPage(driver);
		contactInfo.getContactInformation().getText();

		webDriverLib.waitUntilElementLoaded(driver, contactInfo.getContactInformation());

		if (contactInfo.getContactInformation().getText().contains(lastName)) {
			ListenersImplementation.test.log(Status.PASS, contactInfo.getContactInformation().getText());
			ListenersImplementation.test.log(Status.PASS, "Support start date : "+contactInfo.getSupportStartDate().getText());
			ListenersImplementation.test.log(Status.PASS, "Support end date : "+contactInfo.getSupportEndDate().getText());
		} else {
			ListenersImplementation.test.log(Status.FAIL, "========== Fail ==========");
		}
	}
}
