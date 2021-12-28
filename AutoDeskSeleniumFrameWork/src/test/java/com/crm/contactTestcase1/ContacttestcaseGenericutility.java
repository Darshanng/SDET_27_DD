package com.crm.contactTestcase1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.vitger.comcast.genericutility.Excelutility;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class ContacttestcaseGenericutility {

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
				      driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
				      driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
				      driver.findElement(By.id("submitButton")).click();
				      driver.findElement(By.xpath("//a[.='Contacts']")).click();
				      driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				      driver.findElement(By.name("lastname")).sendKeys(orgName);
			          driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
				      
				    //verify Organization name in header
			          String actuString= driver.findElement(By.className("dvHeaderText")).getText();
			          if(actuString.contains(orgName)) {
			        	  System.out.println("Contact is sucussfully created..pass");
			          }
			          else
			          {
			        	  System.out.println("Contact is not created..Fail");
			          }
			          
			          //Logout
			         wb.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
			  		 driver.findElement(By.linkText("Sign Out")).click();
			  		 driver.quit();		  		
	}
}
