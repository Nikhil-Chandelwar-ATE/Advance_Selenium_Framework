package com.comcast.crm.contacttest;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;
import com.comcast.crm.objectrepository.ContactInformationPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;

public class CreateContactWithOrganizationTest extends BaseTest {

	@Test
	public void createContactWithOrganizationTest() throws Throwable {
		
		int randomNumber = javaLib.getRandomNumber();
		String lastName = excelLib.getDataFromExcelFile("Contact", 1, 2) + randomNumber;
		
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getvTigerLogo().isDisplayed(), true, "Logo Verification : ");
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
		Assert.assertEquals(contactInfo.getContactInformation().isDisplayed(), true, "Contact Information : ");
		Reporter.log(contactInfo.getContactInformation().getText(), true);
		Reporter.log(contactInfo.getOrganizationName().getText(),true);
	}
}
