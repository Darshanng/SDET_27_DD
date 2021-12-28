package com.crm.autodesk.objectepository;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Step1
public class OrganizationPage {
	
//step2
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	
	//step3
	public OrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
     public void clickcreateOrgLookUpImg()
     {
    	 createOrgLookUpImg.click();
     }

}
