package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationImage;
	
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	
	@FindBy(xpath = "(//select[@id='bas_searchfield'])[1]")
	private WebElement organizationsDropDown;
	
	@FindBy(css = "[name='submit']")
	private WebElement searchButton;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;

	public WebElement getCreateOrganizationImage() {
		return createOrganizationImage;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getOrganizationsDropDown() {
		return organizationsDropDown;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}	
}
