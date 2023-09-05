package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Creating New Organization']")
	private WebElement creatingNewOrganizationTitle;
	
	@FindBy(css = "[name='accountname']")
	private WebElement organizationNameTextField;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(id = "phone")
	private WebElement phoneTextField;
	
	@FindBy(xpath = "(//input[contains(@value,'Save')])[1]")
	private WebElement saveButton;

	public WebElement getCreatingNewOrganizationTitle() {
		return creatingNewOrganizationTitle;
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
