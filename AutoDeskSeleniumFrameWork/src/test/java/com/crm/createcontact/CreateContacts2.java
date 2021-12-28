package com.crm.createcontact;

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

public class CreateContacts2 {

	public static void main(String[] args) throws IOException {
		//get the java representation object of the physical file
				FileInputStream fis=new FileInputStream("./Data/commondata.properties");
				//create a object to property class to load all the keys
			      Properties pobj = new Properties();
			      pobj.load(fis);
			      //read the value using getproperty("key")
			      String URL=pobj.getProperty("url");
			      String BROWSER=pobj.getProperty("browser");
			      String USERNAME=pobj.getProperty("username");
			      String PASSWORD=pobj.getProperty("password");
			      
			    //get rowdom num
			       Random ran = new Random();
			       int randnum = ran.nextInt(1000);
			      
			      //get the data from Excel file
			      FileInputStream Fs=new FileInputStream("./Data/Book.xlsx");
			      Workbook wb = WorkbookFactory.create(Fs);
			      Sheet sh = wb.getSheet("Sheet1");
			      Row rw = sh.getRow(1);
			      String orgName = rw.getCell(2).getStringCellValue() + randnum;
			      
			      WebDriver driver=null;
			      if(BROWSER.equals("firefox"));
			      {
			    	driver = new FirefoxDriver();
			      }
			      
			      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			      
			    //login
			      driver.get(URL);
			      driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
			      driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
			      driver.findElement(By.id("submitButton")).click();
			      driver.findElement(By.xpath("//a[.='Contacts']")).click();
			      driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			      driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(orgName);
			      driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			      
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
		          Actions act = new Actions(driver);
		          act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		          driver.findElement(By.linkText("Sign Out")).click();
		          driver.close();
			      
	}

}
