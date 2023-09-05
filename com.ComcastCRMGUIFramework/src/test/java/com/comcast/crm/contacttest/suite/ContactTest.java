package com.comcast.crm.contacttest.suite;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;
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
			System.out.println("Pass ============ " + contactInfo.getContactInformation().getText());
		} else {
			System.out.println("Fail ============ Contact not created");
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
			System.out.println("Pass ============ " +contactInfo.getContactInformation().getText());
			System.out.println("Organization Name : "+contactInfo.getOrganizationName().getText());
		} else {
			System.out.println("Fail ============ Contact not created");
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
			System.out.println("Pass ============ " + contactInfo.getContactInformation().getText());
			System.out.println("Support start date : "+contactInfo.getSupportStartDate().getText());
			System.out.println("Support end date : "+contactInfo.getSupportEndDate().getText());
		} else {
			System.out.println("Fail ============ Contact not created");
		}
	}
}
