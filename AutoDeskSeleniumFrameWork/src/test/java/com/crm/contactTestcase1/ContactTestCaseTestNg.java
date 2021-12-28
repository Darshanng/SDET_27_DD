package com.crm.contactTestcase1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.objectepository.ConatctPage;
import com.crm.autodesk.objectepository.CreateContactPage;
import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.LoginPage;
import com.crm.autodesk.objectepository.contactInfopage;
import com.vitger.comcast.genericutility.BaseClass;


@Listeners(com.vitger.comcast.genericutility.ListnersImplentation.class)
public class ContactTestCaseTestNg extends BaseClass {
	
	@Test(groups = "Smokesiute")
	public void ContactTestcaseTest() throws Throwable 
	
	{
		int Random = JU.getRandomNumber();
		String orgName = Ex.getDataFromExcel("Sheet1", 1, 0);
		
		 //navigate to organization page;
   	   HomePage hp=new HomePage(driver);
   	   hp.clickonContactLink();
   	   
   	  ConatctPage cp=new ConatctPage(driver);
   	  cp.clickCreateContactImg();
   	  
   	  
   	  CreateContactPage ccp=new CreateContactPage(driver);
   	  Assert.fail();
   	  
   	   contactInfopage ci=new contactInfopage(driver);
   	    String actu_msg = ci.getcontactInfo();
   	 if(actu_msg.contains(orgName))
	    {
	    System.out.println("------Contact Created--------");
	    }
	    else 
	    {
	     System.out.println("------Contact Created--------");
	     }
	}
}
