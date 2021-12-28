package com.crm.autodeskorgtest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.objectepository.CreateOrganizationPage;
import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.OrganizationInfoPage;
import com.crm.autodesk.objectepository.OrganizationPage;
import com.vitger.comcast.genericutility.BaseClass;



@Listeners(com.vitger.comcast.genericutility.ListnersImplentation.class)
public class OrgTestJavaTestNg extends BaseClass{
	@Test(groups = "Regressionsuite")
	public void CreateOrgTest() throws Throwable
	{
		// read common data from properties file
		int Random = JU.getRandomNumber();
		String orgName = Ex.getDataFromExcel("Sheet1", 1, 2) + Random;
		  
       
		//navigate to Organization
		HomePage hp = new HomePage(driver);
		hp.getOragnizationLnk().click();
		
		
		OrganizationPage op = new OrganizationPage(driver);
	    op.clickcreateOrgLookUpImg();
	    
	   CreateOrganizationPage Cop=new CreateOrganizationPage(driver);
	   Assert.fail();
	   
	   
	   
	   OrganizationInfoPage oi=new OrganizationInfoPage(driver);
	   String actu_msg = oi.getOrgInfo();
	    Assert.assertTrue(actu_msg.contains(orgName));
	    
	 }
}
