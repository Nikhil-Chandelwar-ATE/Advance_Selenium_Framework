package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homeLink;

	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(xpath = "//img[@title='vtiger-crm-logo.gif']")
	private WebElement vTigerLogo;
	
	@FindBy(xpath = "//a[@name='Invoice']")
	private WebElement invoiceLink;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsLink;

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getvTigerLogo() {
		return vTigerLogo;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdministratorImage() {
		return administratorImage;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public void navigateToCampaignsPage(WebDriver driver) {

		this.driver = driver;
		Actions action = new Actions(driver);
		action.moveToElement(moreLink).perform();
		action.moveToElement(campaignsLink).click().perform();
	}
}
