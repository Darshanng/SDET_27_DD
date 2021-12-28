package com.crm.autodesk.objectepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vitger.comcast.genericutility.Webdriverutility;

public class LoginPage extends Webdriverutility{
	
	//step1:create a seprate class foer webpage
	
	
	//step2:identify all the webelements and delcare them as private
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//Initilize the elements using constructor 
	public LoginPage(WebDriver diver)
	{
		PageFactory.initElements(diver, this);
	}
	

	//Utilization and provide getters method
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	// Business Libraray
	public void login(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	

}
