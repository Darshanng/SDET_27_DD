package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {

	@Test(dataProvider = "getdata")
	public void readDataFromDataProviderTest(String name , int Qty)
	{
		System.out.println("Mobile name---->"+name+"----Mobile Qantity---->qty");
	}
	
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="Iphone";
		objArr[0][1]=10;

		objArr[1][0]="Samsung";
		objArr[1][1]=30;

		objArr[2][0]="Vivo";
		objArr[2][1]=20;
		
		return objArr;
		
	}
	
	
	
}
