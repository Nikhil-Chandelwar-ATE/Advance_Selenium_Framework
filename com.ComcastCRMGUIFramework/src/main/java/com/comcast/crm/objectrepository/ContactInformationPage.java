package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInformation;
	
	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastName;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStartDate;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEndDate;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement organizationName;

	public WebElement getContactInformation() {
		return contactInformation;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}
}
