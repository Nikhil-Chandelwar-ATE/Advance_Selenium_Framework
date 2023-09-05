package com.comcast.crm.organizationtest.suite;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;
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
			System.out.println("Pass ============ "+orgInfo.getOrganizationInformation().getText());
		} else {
			System.out.println("Fail ============ Organization not created");	
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
			System.out.println("Pass ============ " + orgInfo.getOrganizationInformation().getText());
			System.out.println("Industry : " + orgInfo.getIndustry().getText());
			System.out.println("Type : " + orgInfo.getType().getText());
		} else {
			System.out.println("Fail ============ Organization not created");
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
			System.out.println("Pass ============ " + orgInfo.getOrganizationInformation().getText());
			System.out.println("Oragnization Name : " + orgInfo.getOrganizationName().getText());
			System.out.println("Phone Number : " + orgInfo.getPhone().getText());
		} else {
			System.out.println("Fail ============ Organization not created");
		}
	}
}
