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

import com.vitger.comcast.genericutility.Excelutility;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class OrgTestjavaGenericutility {

	public static void main(String[] args) throws Throwable {
		
		//craete a object for generic 
		     Excelutility Es=new Excelutility();
		     Fileutility Fs=new Fileutility();
		     Javautility Js=new Javautility();
		     Webdriverutility wb=new Webdriverutility();
		    
		
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
	      driver.get(URL);
	      driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	      driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
	      driver.findElement(By.id("submitButton")).click();
	      
	      //navigate to Organization module
          driver.findElement(By.xpath("//a[.='Organizations']")).click();
          //click on craete Organization button
          driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
          //enter all the Deatials and create Organzation
          driver.findElement(By.name("accountname")).sendKeys(orgName);
          driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
          
          //verify Organization name in header
          String actuString= driver.findElement(By.className("dvHeaderText")).getText();
          if(actuString.contains(orgName)) {
        	  System.out.println("org is sucussfully created..pass");
          }
          else
          {
        	  System.out.println("org is not created..Fail");
          }
          
          //Logout
          wb.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
  		  driver.findElement(By.linkText("Sign Out")).click();
  		  driver.quit();
	}
	}


