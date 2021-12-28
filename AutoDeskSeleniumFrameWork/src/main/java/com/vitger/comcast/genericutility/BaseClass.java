package com.vitger.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility DB=new DataBaseUtility();
	public Fileutility FU=new Fileutility();
	public Webdriverutility WB=new Webdriverutility();
	public Javautility JU=new Javautility();
	public Excelutility Ex=new Excelutility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = "Smokesuite,Regressionsuite")
	public void DBconnecetion()
	{
		DB.ConnecttoDB();
		System.out.println("-----Database connection succesfull----");
	}
   
   
	@BeforeClass(groups = { "Smokesuite","Regressionsuite"})
	public void LaunchBrowser() throws Throwable
	{
		//read the data
		 String BROWSER = FU.getPropertyKeyValue("browser");
		 		String URL = FU.getPropertyKeyValue("url");
		 		
		 		if(BROWSER.equalsIgnoreCase("chrome"))
		 		{
		 			driver = new ChromeDriver();
		 		}
		 		else
		 		{
		 			if(BROWSER.equalsIgnoreCase("Firefox"))
		 			{
		 				driver = new FirefoxDriver();
		 			}
		 			sdriver=driver;
		 			WB.waitForPageToLoad(driver);
		 			driver.get(URL);
		 			System.out.println("succesfully lanched firefox");
		 		}
		 		}
		 		
		 		@BeforeMethod(groups = { "Smokesuite","Regressionsuite"})
		          public void loginToApp() throws Throwable
		 		{
		 			//read the data
		 			String USERNAME = FU.getPropertyKeyValue("username");
			 		String PASSWORD = FU.getPropertyKeyValue("password");
		 			
			 		LoginPage Lp=new LoginPage(driver);
		 			Lp.login(USERNAME, PASSWORD);
		 			System.out.println("Login Successfull");
		 			
		 		}
		 		
	@AfterMethod(groups = { "Smokesuite","Regressionsuite"})
	public void logoutoffApp()
	{
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("Logout Successfull");
	}
	@AfterClass(groups = "Smokesuite,Regressionsuite")
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("----Browser closed-----");
	}
	
	@AfterSuite(groups = { "Smokesuite","Regressionsuite"})
	public void closeDBconnection()
	{
		DB.closetheDB();
		System.out.println("-----DataBase connection Closed----");
	}
}


