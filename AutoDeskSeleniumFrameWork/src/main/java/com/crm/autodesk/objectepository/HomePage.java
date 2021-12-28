package com.crm.autodesk.objectepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitger.comcast.genericutility.Webdriverutility;

//step1:create a seprate class foer webpage
public class HomePage extends Webdriverutility{
	

		//step2:identify all the webelements and delcare them as private
        @FindBy(linkText="Organizations")
        private WebElement OragnizationLnk;
        
        @FindBy(linkText="Contacts")
        private WebElement contactLnk;
        
        @FindBy(linkText="Opportunities")
        private WebElement opportunitiesLnk;
        
        @FindBy(linkText="Products")
        private WebElement productLnk;
        
        @FindBy(linkText="Documents")
        private WebElement DocumentsLnk;
        
        @FindBy(linkText="Dashboard")
        private WebElement DashboardLnk;
        
        @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
        private WebElement AdminstatorImg;
       
        @FindBy(linkText = "Sign Out")
        WebElement signoutLnk;
        
        

//Initilize the elements using constructor 
	public HomePage(WebDriver diver)
	{
		PageFactory.initElements(diver, this);
	}
	
	//Utilization and provide getters method


	public WebElement getOragnizationLnk() {
		return OragnizationLnk;
	}


	public WebElement getContactLnk() {
		return contactLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}


	public WebElement getProductLnk() {
		return productLnk;
	}


	public WebElement getDocumentsLnk() {
		return DocumentsLnk;
	}


	public WebElement getDashboardLnk() {
		return DashboardLnk;
	}

	public WebElement getAdminstatorImg() {
		return AdminstatorImg;
	}
	
	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	
	// business library to click on organization
	 
	public void clickonOrganizationLink()
	{
		OragnizationLnk.click();
	}
	// business library to click on contact
	public void clickonContactLink()
	{
		contactLnk.click();
	}
	// business library to click on logout
	public void logout(WebDriver driver)
	{
		waitForTheElementToBeClickAble(driver, AdminstatorImg);
		mouseOverOnElemnet(driver, AdminstatorImg);
		signoutLnk.click();
	}
}    