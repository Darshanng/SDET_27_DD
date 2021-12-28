package com.crm.createcontactwithorgaTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContacts {

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
			      
			    //login
			      WebDriver driver=new FirefoxDriver();
			      driver.get(URL);
			      driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
			      driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
			      driver.findElement(By.id("submitButton")).click();
			      driver.findElement(By.xpath("//a[.='Contacts']")).click();
			      driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			      driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(args);
			      
			      
	}

}
