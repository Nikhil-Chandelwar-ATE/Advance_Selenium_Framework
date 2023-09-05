package com.comcast.crm.contacttest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;
import com.comcast.crm.objectrepository.ContactInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;

public class CreateContactWithSupportDateTest extends BaseTest {

	@Test
	public void createContactWithSupportDateTest() throws Throwable {
		
		int randomNumber = javaLib.getRandomNumber();
		String lastName = excelLib.getDataFromExcelFile("Contact", 1, 2) + randomNumber;

		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getvTigerLogo().isDisplayed(), true, "Logo Verification : ");
		homePage.getContactsLink().click();
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.getCreateContactImage().click();

		CreatingNewContactPage creatingContact = new CreatingNewContactPage(driver);
		creatingContact.getLastNameTextField().sendKeys(lastName);
		String currentDate = javaLib.getSystemDateYYYYMMDD();
		creatingContact.getSupportStartDate().clear();
		creatingContact.getSupportStartDate().sendKeys(currentDate);
		String futureDate = javaLib.getRequiredDateYYYYMMDD(30);
		System.out.println(futureDate);
		creatingContact.getSupportEndDate().clear();
		creatingContact.getSupportEndDate().sendKeys(futureDate);
		creatingContact.getSaveButton().click();

		ContactInformationPage contactInfo = new ContactInformationPage(driver);
		contactInfo.getContactInformation().getText();

		webDriverLib.waitUntilElementLoaded(driver, contactInfo.getContactInformation());
		Assert.assertEquals(contactInfo.getContactInformation().isDisplayed(), true, "Contact Information : ");
		Reporter.log(contactInfo.getContactInformation().getText(), true);
		Reporter.log(contactInfo.getSupportStartDate().getText(),true);
		Reporter.log(contactInfo.getSupportEndDate().getText(),true);
	}
}
