package com.crm.IndustryType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.objectepository.CreateNewOrganization;
import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.LoginPage;
import com.crm.autodesk.objectepository.OrganizationPage;
import com.vitger.comcast.genericutility.Excelutility;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class IndustryType {

	public static void main(String[] args) throws Throwable {
		//Specifying Driver
	       System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	       
	     //Create Object to Libraries
	Fileutility fLib = new Fileutility();
	Webdriverutility wLib = new Webdriverutility();
	Excelutility eLib = new Excelutility();
	Javautility jLib = new Javautility();

	//read common data from property file
	String BROWSER = fLib.getPropertyKeyValue("browser");
	String URL = fLib.getPropertyKeyValue("url");
	String USERNAME = fLib.getPropertyKeyValue("username");
	String PASSWORD = fLib.getPropertyKeyValue("password");

	// Get Random Data
	int randomNum = jLib.getRandomNumber();

	//Get the data from excel

	String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + randomNum;
	String industry_type = eLib.getDataFromExcel("Sheet1", 1, 6);
	String type = eLib.getDataFromExcel("Sheet1", 1, 7);
	/* FileInputStream fis_1 = new FileInputStream("./data/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis_1);
	Sheet sh = wb.getSheet("Sheet1");
	Row row = sh.getRow(1);
	String orgName = row.getCell(2).getStringCellValue() + rannum;
	String industry_type = row.getCell(6).getStringCellValue();
	String type = row.getCell(7).getStringCellValue(); */
	 
	//Browser specific condition
	WebDriver driver;
	if(BROWSER.equals("chrome"))
	{
	driver = new ChromeDriver();

	}
	else if(BROWSER.equals("firefox"))
	{
	driver = new FirefoxDriver();
	}
	else if (BROWSER.equals("ie"))
	{
	driver = new InternetExplorerDriver();
	}
	else
	{
	driver = new ChromeDriver();
	}
	//Implicit Wait
	wLib.waitForPageToLoad(driver);
	driver.get(URL);

	//Step 1 : Login to Vtiger application
	/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();*/
	LoginPage lp = new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);

	//Step 2 : Navigate to organization
	   //driver.findElement(By.linkText("Organizations")).click();
	HomePage hp = new HomePage(driver);
	hp.clickonOrganizationLink();
	//Step 3 : Click on crete organization button
	//driver.findElement(By.xpath("//img[@alt ='Create Organization...']")).click();
	OrganizationPage op = new OrganizationPage(driver);
	op.clickcreateOrgLookUpImg();

	//Step 4 : Enter all the details and cretae new organization
	//driver.findElement(By.name("accountname")).sendKeys(orgName);
	CreateNewOrganization cop = new CreateNewOrganization(driver);
	cop.createOrganizationWithIndustryAndType(orgName, industry_type, type);


	//Step 5 : select  industry type
	//WebElement ele1 = driver.findElement(By.name("industry"));
	//wLib.select(ele1, industry_type);
	/*Select sel1 = new Select(ele1);
	sel1.selectByVisibleText(industry_type);*/
	//select the type
	//WebElement ele2 = driver.findElement(By.name("accounttype"));
	//wLib.select(ele2, type);
	/*Select sel2 = new Select(ele2);
	sel2.selectByVisibleText(type);*/
	//save the org
	//driver.findElement(By.xpath("//input[@class ='crmbutton small save']")).click();
	//wait stmt
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
	//Thread.sleep(2000);

	WebElement ele3 = driver.findElement(By.className("dvHeaderText"));
	wLib.waitForTheElementToBeClickAble(driver, ele3);
	//Verification
	String actualIndustry = driver.findElement(By.className("small")).getText();
	if(actualIndustry.contains(industry_type))
	{
	System.out.println("The industry selected  :  Passed");
	}
	else
	{
	System.out.println("Industry is not selected :  Failed");
	}
	String actualType = driver.findElement(By.className("small")).getText();
	if(actualType.contains(type)) {
	System.out.println("Type is selected : PASSED");
	}
	else
	{
	System.out.println("Type is not selected : FAILED");
	}


	//Step 6 : logout
	//wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	//driver.findElement(By.linkText("Sign Out")).click();
	hp.logout(driver);
	driver.close();


	}


	}


