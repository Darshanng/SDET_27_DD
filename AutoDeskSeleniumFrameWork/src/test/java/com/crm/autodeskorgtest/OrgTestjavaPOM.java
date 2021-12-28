package com.crm.autodeskorgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.objectepository.CreateOrganizationPage;
import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.LoginPage;
import com.crm.autodesk.objectepository.OrganizationInfoPage;
import com.crm.autodesk.objectepository.OrganizationPage;
import com.crm.createorganization.CreateOrganization;
import com.vitger.comcast.genericutility.Excelutility;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class OrgTestjavaPOM {

	public static void main(String[] args) throws Throwable {
		//get the java representation object of the physical file
		Fileutility Fs=new Fileutility();
        Webdriverutility wb=new Webdriverutility();
        Excelutility Es=new Excelutility();
        Javautility Js=new Javautility();
        
      //read the value using getproperty("key")
	      String URL=Fs.getPropertyKeyValue("url");
	      String BROWSER=Fs.getPropertyKeyValue("browser");
	      String USERNAME=Fs.getPropertyKeyValue("username");
	      String PASSWORD=Fs.getPropertyKeyValue("password");
	      
	    //get the Random Num
	      int randomNum = Js.getRandomNumber();
	      
	      
	    //Read the Excel file
          String orgName=Es.getDataFromExcel("Sheet1", 1, 0)+randomNum;
	      
	      // read common data from properties file
          WebDriver driver=null;
       	if (BROWSER.equals("chrome")) {
       		driver=new ChromeDriver();
       		
  			}else if (BROWSER.equals("firefox")) {
  				driver=new FirefoxDriver();
  				}else {
  					driver=new ChromeDriver();
  				}
       	
    	       driver.get(URL);
		       wb.waitForPageToLoad(driver);
         	   driver.manage().window().maximize();
         	   
         	   //login
         	   LoginPage lp= new LoginPage(driver);
         	   lp.login(USERNAME, PASSWORD);
         	   
         	   //navigate to organization page;
         	   HomePage hp=new HomePage(driver);
         	   hp.clickonOrganizationLink();
         	   
          //click on craete Organization button
         	  OrganizationPage Op=new OrganizationPage(driver);
         	  Op.clickcreateOrgLookUpImg();
        
          //enter all the Deatials and create Organzation and save
         	  CreateOrganizationPage cop=new CreateOrganizationPage(driver);
         	  cop.createOrg(orgName);
           
     	  //confromatiton
         	 OrganizationInfoPage Oi=new OrganizationInfoPage(driver);
               String actu_msg = Oi.getOrgInfo();
               
               
           
          //verify Organization name in header          
		if(actu_msg.contains(orgName)) 
          {
       	  System.out.println("org is sucussfully created..pass");
         }
          else          {
       	  System.out.println("org is not created..Fail");
          }
		
		//logout
		hp.logout(driver);
		
	}
	}


