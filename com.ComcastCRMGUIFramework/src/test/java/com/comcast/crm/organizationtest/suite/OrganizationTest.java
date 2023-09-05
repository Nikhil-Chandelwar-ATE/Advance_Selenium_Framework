package com.comcast.crm.organizationtest.suite;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseTest;
import com.comcast.crm.listenersutility.ListenersImplementation;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationInformationPage;
import com.comcast.crm.objectrepository.OrganizationsPage;

public class OrganizationTest extends BaseTest {

	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {
		
		int randomNumber = javaLib.getRandomNumber();
		String orgName = excelLib.getDataFromExcelFile("Organization", 1, 2)+randomNumber;
		
		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationsLink().click();
		
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrganizationImage().click();
		
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.getOrganizationNameTextField().sendKeys(orgName);
		createOrg.getSaveButton().click();
		
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		
		webDriverLib.waitUntilElementLoaded(driver, orgInfo.getOrganizationInformation());
		
		if (orgInfo.getOrganizationInformation().getText().contains(orgName)) {
			ListenersImplementation.test.log(Status.PASS, orgInfo.getOrganizationInformation().getText());
		} else {
			ListenersImplementation.test.log(Status.FAIL, "========== Fail ==========");
		}
	}
	
	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustryTest() throws Throwable {
		
		int randomNumber = javaLib.getRandomNumber();
		String orgName = excelLib.getDataFromExcelFile("Organization", 1, 2) + randomNumber;

		HomePage homePage = new HomePage(driver);
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

		if (orgInfo.getOrganizationInformation().getText().contains(orgName)) {
			ListenersImplementation.test.log(Status.PASS, orgInfo.getOrganizationInformation().getText());
			ListenersImplementation.test.log(Status.PASS, "Industry : " + orgInfo.getIndustry().getText());
			ListenersImplementation.test.log(Status.PASS, "Type : " + orgInfo.getType().getText());
		} else {
			ListenersImplementation.test.log(Status.FAIL, "========== Fail ==========");
		}
	}
	
	@Test(groups = "regressionTest")
	public  void createOrganizationWithPhoneTest() throws Throwable {

		int randomNumber = javaLib.getRandomNumber();
		String orgName = excelLib.getDataFromExcelFile("Organization", 1, 2) + randomNumber;

		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationsLink().click();

		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrganizationImage().click();

		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.getOrganizationNameTextField().sendKeys(orgName);
		createOrg.getPhoneTextField().sendKeys(excelLib.getDataFromExcelFile("Organization", 7, 3));
		createOrg.getSaveButton().click();

		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		webDriverLib.waitUntilElementLoaded(driver, orgInfo.getOrganizationInformation());

		if (orgInfo.getOrganizationInformation().getText().contains(orgName)) {
			ListenersImplementation.test.log(Status.PASS, orgInfo.getOrganizationInformation().getText());
			ListenersImplementation.test.log(Status.PASS, "Oragnization Name : " + orgInfo.getOrganizationName().getText());
			ListenersImplementation.test.log(Status.PASS, "Phone Number : " + orgInfo.getPhone().getText());
		} else {
			ListenersImplementation.test.log(Status.FAIL, "========== Fail ==========");
		}
	}
}
