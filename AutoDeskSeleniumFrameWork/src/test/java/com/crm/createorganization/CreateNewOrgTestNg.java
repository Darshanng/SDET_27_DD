package com.crm.createorganization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.objectepository.CreateOrganizationPage;
import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.OrganizationInfoPage;
import com.crm.autodesk.objectepository.OrganizationPage;
import com.vitger.comcast.genericutility.BaseClass;

public class CreateNewOrgTestNg extends BaseClass{
	@Test(groups = "Smokesuite")
	public void createOrgWithIndustryTest() throws Throwable{
	int randomNum=JU.getRandomNumber();
	
	String orgName = Ex.getDataFromExcel("Sheet1", 1, 2)+ randomNum;
	String industry = Ex.getDataFromExcel("Sheet1", 1, 3);
	String type = Ex.getDataFromExcel("Sheet1", 1, 4);
	
	//WebDriver driver;
	WB.waitForPageToLoad(driver);
	
	HomePage hp=new HomePage(driver);
	hp.clickonOrganizationLink();
	
	OrganizationPage oP=new OrganizationPage(driver);
	oP.clickcreateOrgLookUpImg();
	
	CreateOrganizationPage cOP=new CreateOrganizationPage(driver);
	cOP.createOrg(orgName);
	
	OrganizationInfoPage oIP=new OrganizationInfoPage(driver);
	String actualorgname=oIP.getOrgInfo();
	
	Assert.assertTrue(actualorgname.contains(industry));
	
	
	
	}

}
