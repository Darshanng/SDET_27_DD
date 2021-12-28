package com.crm.autodesk.objectepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConatctPage {

	//step2
	
	@FindBy (xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	@FindAll({@FindBy(name = "search_text"),@FindBy(xpath = "//input[@class='txtBox']")})
	private WebElement searchtextEdt;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;

	
	//step3
	public ConatctPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	public WebElement getSearchtextEdt() {
		return searchtextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//business Library
	public void clickCreateContactImg()
	{
		createContactLookUpImg.click();
	}
	
	
	}

