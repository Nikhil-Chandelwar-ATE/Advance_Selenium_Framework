package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactImage;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement supportEndDate;
	
	@FindBy(xpath = "(//td[@class='dvtCellInfo'])[5]/img")
	private WebElement addOrganizationImage;
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveButton;

	public WebElement getCreateContactImage() {
		return createContactImage;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getAddOrganizationImage() {
		return addOrganizationImage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
}
