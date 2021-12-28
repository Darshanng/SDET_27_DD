package com.crm.createorganization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

import com.vitger.comcast.genericutility.Excelutility;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		//create a genericutility
		Excelutility Es=new Excelutility();
	     Fileutility Fs=new Fileutility();
	     Javautility Js=new Javautility();
	     Webdriverutility wb=new Webdriverutility();
		

	   //get the random data
			int randNum = Js.getRandomNumber();
				
				// step-3 read the value using getproprty("key")
				String BROWSER=Fs.getPropertyKeyValue("browser");
				String URL=Fs.getPropertyKeyValue("url");
				String USERNAME=Fs.getPropertyKeyValue("username");
				String PASSWORD=Fs.getPropertyKeyValue("password");
				
				//read test data from excel file
			     String orgName =Es.getDataFromExcel("Sheeet2", 1, 2)+randNum;
			     String industry =Es.getDataFromExcel("Sheet2", 1, 5);	     
			     String type = Es.getDataFromExcel("Sheet2", 1, 6);
			     
			     
			        WebDriver driver = null;
	             	if (BROWSER.equals("chrome")) {
	             		driver=new ChromeDriver();
	             		
	        			}else if (BROWSER.equals("firefox")) {
	        				driver=new FirefoxDriver();
	        				}else {
	        					driver=new ChromeDriver();
	        				}
	        		driver.get(URL);
	        		driver.manage().window().maximize();
	        		//step-5 login
	        		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	        		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        		driver.findElement(By.id("submitButton")).click();
	        		//step-6 navigate to organization module
	        		driver.findElement(By.linkText("Organizations")).click();
	        		//step-7 click on the organization button
	        		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	        		//step-8 enter all the details and create organizatination
	        		driver.findElement(By.name("accountname")).sendKeys(orgName);
	        		WebElement ele = driver.findElement(By.name("industry"));
	        		wb.select(ele, industry);
	        		WebElement ele1 = driver.findElement(By.name("accounttype"));
	        		wb.select(ele1, type);
	        		
	        	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        	    Thread.sleep(3000);
	        		//step verify the organization name in the header of msg
	        		String actual_msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	        		if (actual_msg.contains(orgName)) {
	        			
	        			System.out.println("org is successfully created..pass");
	        			}else {
	        				System.out.println("org is not created...fail");
	        			}
	        		String industry_msg = driver.findElement(By.id("mouseArea_Industry")).getText();
	        	
	        		if (industry_msg.contains(industry)) {
	        			
	        			System.out.println("industry is successfully created..pass");
	        			}else {
	        				System.out.println("industryis not created...fail");
	        			}
	        		String type_msg = driver.findElement(By.id("mouseArea_Type")).getText();

	               if (type_msg.contains(type)) {
	        			
	        			System.out.println("type is successfully created..pass");
	        			}else {
	        				System.out.println("type not created...fail");
	        			}
	               
	             //step- logoutt
	       		wb.mouseOverOnElemnet(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	       		driver.findElement(By.linkText("Sign Out")).click();
	       		driver.quit();
		
		
		System.out.println("TestCase Pass");
	}


	}


