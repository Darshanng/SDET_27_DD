package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.objectepository.HomePage;
import com.crm.autodesk.objectepository.LoginPage;
import com.vitger.comcast.genericutility.Fileutility;
import com.vitger.comcast.genericutility.Javautility;
import com.vitger.comcast.genericutility.Webdriverutility;

public class POMPractice {

	public static void main(String[] args) throws Throwable {
		Fileutility Fs=new Fileutility();
        Webdriverutility wb=new Webdriverutility();
        
        
        
      //read the value using getproperty("key")
	      String URL=Fs.getPropertyKeyValue("url");
	      String BROWSER=Fs.getPropertyKeyValue("browser");
	      String USERNAME=Fs.getPropertyKeyValue("username");
	      String PASSWORD=Fs.getPropertyKeyValue("password");
	      
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
         	   
         	   //logout
         	   hp.logout(driver);
	      
	}

}
