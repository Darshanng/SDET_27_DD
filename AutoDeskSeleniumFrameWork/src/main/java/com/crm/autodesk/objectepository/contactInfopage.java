package com.crm.autodesk.objectepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInfopage {
	
	//step2
	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderinfoText;

	//step3
	public contactInfopage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //step4
	public WebElement getContactHeaderinfoText() {
		return contactHeaderinfoText;
	}
	
	//step5
	public String getcontactInfo()
	{
		return contactHeaderinfoText.getText();
	}
	
	
}
