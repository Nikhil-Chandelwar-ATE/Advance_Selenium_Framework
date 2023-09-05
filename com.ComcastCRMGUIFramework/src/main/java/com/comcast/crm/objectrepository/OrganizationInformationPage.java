package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

	public OrganizationInformationPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInformation;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement organizationName;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industry;
	
	@FindBy(id = "dtlview_Type")
	private WebElement type;
	
	@FindBy(id = "mouseArea_Phone")
	private WebElement phone;

	public WebElement getOrganizationInformation() {
		return organizationInformation;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getPhone() {
		return phone;
	}
}
