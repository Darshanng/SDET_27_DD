package com.crm.contactTestcase1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.objectepository.ConatctPage;
import com.crm.autodesk.objectepository.CreateContactPage;
import com.crm.autodesk.objectepository.CreateOrganizationPage;
import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.LoginPage;
import com.crm.autodesk.objectepository.contactInfopage;
import com.vitger.comcast.genericutility.Excelutility;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class ContacttestcasePom {

	public static void main(String[] args) throws Throwable {
		
		//create a genericutility
		Excelutility Es=new Excelutility();
	     Fileutility Fs=new Fileutility();
	     Javautility Js=new Javautility();
	     Webdriverutility wb=new Webdriverutility();
	     
				      //read the value using getproperty("key")
				      String URL=Fs.getPropertyKeyValue("url");
				      String BROWSER=Fs.getPropertyKeyValue("browser");
				      String USERNAME=Fs.getPropertyKeyValue("username");
				      String PASSWORD=Fs.getPropertyKeyValue("password");
				      
				    //get rowdom num
				      //get rowdom num
				      int random = Js.getRandomNumber();
				      
				      //get the data from Excel file
			          String orgName=Es.getDataFromExcel("Sheet1", 1, 2)+random;
				      
				      WebDriver driver=null;
				      if(BROWSER.equals("firefox"));
				      {
				    	driver = new FirefoxDriver();
				      }
				      
				      //login
				        driver.get(URL);
				        wb.waitForPageToLoad(driver);
		         	    driver.manage().window().maximize();
		         	    
		         	 //login
		          	   LoginPage lp= new LoginPage(driver);
		          	   lp.login(USERNAME, PASSWORD);
		          	   
		          	   //navigate to organization page;
		          	   HomePage hp=new HomePage(driver);
		          	   hp.clickonContactLink();
		          	   
		          	  ConatctPage cp=new ConatctPage(driver);
		          	  cp.clickCreateContactImg();
		          	  
		          	  CreateContactPage ccp=new CreateContactPage(driver);
		          	  ccp.createContact(orgName);
		          	  
		          	   contactInfopage ci=new contactInfopage(driver);
		          	    String actu_msg = ci.getcontactInfo();
		          	    
		          	    
		          	//verify Organization name in header          
		        		if(actu_msg.contains(orgName)) 
		                  {
		               	  System.out.println("Contact is sucussfully created..pass");
		                 }
		                  else          {
		               	  System.out.println("Contact is not created..Fail");
		                  }
		        		
				     		
			        //Logout
		               hp.logout(driver);

	}
}

