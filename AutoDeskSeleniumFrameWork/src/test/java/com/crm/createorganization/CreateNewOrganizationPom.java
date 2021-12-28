package com.crm.createorganization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.objectepository.ConatctPage;
import com.crm.autodesk.objectepository.CreateContactPage;
import com.crm.autodesk.objectepository.CreateNewOrganization;
import com.crm.autodesk.objectepository.CreateOrganizationPage;
import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.LoginPage;
import com.crm.autodesk.objectepository.OrganizationInfoPage;
import com.crm.autodesk.objectepository.OrganizationPage;
import com.crm.createcontactwithorgaTest.CreateContactswithorgtest;
import com.vitger.comcast.genericutility.Excelutility;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class CreateNewOrganizationPom extends Webdriverutility {
	public static void main(String[] args) throws Throwable {
		//create a genericutility
				Excelutility Es=new Excelutility();
			     Fileutility Fs=new Fileutility();
			     Javautility Js=new Javautility();
			     Webdriverutility wb=new Webdriverutility();
			     
		// read the value from Properties File
		String URL=Fs.getPropertyKeyValue("url");
		String UserName=Fs.getPropertyKeyValue("username");
		String Password=Fs.getPropertyKeyValue("password");
		String Browser=Fs.getPropertyKeyValue("browser");
		String time=Fs.getPropertyKeyValue("timeout");
		long Timeout=Long.parseLong(time);  
		

		//get rowdom num
	      int random = Js.getRandomNumber();
	
		//get the data from Excel
          String testdata_org=Es.getDataFromExcel("Sheet1", 1, 2)+random;
          String testdata_conctact =Es.getDataFromExcel("Sheet1", 1,2 )+random;


		//Open Browser and Enter URL
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		//login
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, Timeout);

		//login to VTIGER application
		 LoginPage lp= new LoginPage(driver);
   	   lp.login(UserName, Password);
   	   
   	   //navigate to organization page;
   	   HomePage hp=new HomePage(driver);
   	   hp.clickonOrganizationLink();

   	//click on craete Organization button
  	  OrganizationPage Op=new OrganizationPage(driver);
  	  Op.clickcreateOrgLookUpImg();
 
   //enter all the Deatials and create Organzation and save
  	  CreateOrganizationPage cop=new CreateOrganizationPage(driver);
  	  cop.createOrg(testdata_org);
  	  
  	    OrganizationInfoPage oi=new OrganizationInfoPage(driver);
  	    oi.getOrgInfo();
         Thread.sleep(5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Contacts']")));
         hp.clickonContactLink();
		
        ConatctPage cp=new ConatctPage(driver);
         cp.clickCreateContactImg();
         System.out.println("dharshan out");
         
         CreateContactPage ccp=new CreateContactPage(driver);
         ccp.createContactWithOrgName(testdata_org, testdata_conctact, driver);
         
         
         
         

 		
//		//Navigate to Organization Tab
//		driver.findElement(By.linkText("Contacts")).click();
//
//		//click on Create Organization
//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//
//		//Enter the details and click on save
//		driver.findElement(By.name("lastname")).sendKeys(testdata_conctact);
//		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
//		Set<String> set = driver.getWindowHandles();
//		Iterator<String>it=set.iterator();
//
//		while (it.hasNext()) {
//			String currentID=it.next();
//			driver.switchTo().window(currentID);
//			String cpageTitle = driver.getTitle();
//			if (cpageTitle.contains("Accounts")) {
//				break;
//				
//			}
//		}
//		driver.findElement(By.name("search_text")).sendKeys(testdata_org);
//		  driver.findElement(By.name("search")).click();
//		  driver.findElement(By.xpath("//a[text()='"+testdata_org+"']")).click();
//		  Set<String> set1 = driver.getWindowHandles();
//			Iterator<String>it1=set1.iterator();
//			
//			while (it1.hasNext()) {
//				String currentID=it1.next();
//				driver.switchTo().window(currentID);
//				String cpageTitle = driver.getTitle();
//				if (cpageTitle.contains("contacts")) {
//					break;
//				}
//			}
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//		
		// SignOut
		wb.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
     	driver.quit();
//		
//		System.out.println("TestCase Pass");
	}


	}


