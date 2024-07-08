package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	WebDriver driver;
	public OrganizationsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewOrg;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	

	public WebElement getCreateNewOrg() {
		return createNewOrg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}
	
	
}
