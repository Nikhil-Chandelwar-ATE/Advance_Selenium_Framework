package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationsPage;

public class CreateOrganizationWithIndustryTest extends BaseTest {

	@Test
	public void createOrganizationWithIndustryTest() throws Throwable {
		
		int randomNumber = javaLib.getRandomNumber();
		String orgName = excelLib.getDataFromExcelFile("Organization", 1, 2) + randomNumber;

		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getvTigerLogo().isDisplayed(), true, "Logo Verification : ");
		homePage.getOrganizationsLink().click();

		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrganizationImage().click();

		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.getOrganizationNameTextField().sendKeys(orgName);
	
		webDriverLib.selectOption(createOrg.getIndustryDropDown(), excelLib.getDataFromExcelFile("Organization", 4, 3));
		webDriverLib.selectOption(createOrg.getTypeDropDown(), excelLib.getDataFromExcelFile("Organization", 4, 4));
		createOrg.getSaveButton().click();

		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		webDriverLib.waitUntilElementLoaded(driver, orgInfo.getOrganizationInformation());
		Assert.assertEquals(orgInfo.getOrganizationInformation().isDisplayed(), true, "Organization Information : ");
		Reporter.log(orgInfo.getOrganizationInformation().getText(), true);
		Reporter.log(orgInfo.getIndustry().getText(), true);
		Reporter.log(orgInfo.getType().getText(), true);
	}
}
