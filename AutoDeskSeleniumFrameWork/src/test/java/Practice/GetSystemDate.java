package Practice;

import java.util.Date;

public class GetSystemDate {

	public static void main(String[] args) {
		Date date=new Date();
		 String dateandtime = date.toString();
		 System.out.println(dateandtime);

	}
	
	/**
	 * used to get the date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
	       return date.toString();	
	}	
	/**
	 * used to get system date in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDatewithformate() {
		Date date=new Date();
		String dateAndTime = date.toString();
	
		String YYYY= dateAndTime.split(" ")[5];
		String DD= dateAndTime.split(" ")[2];
		int MM= date.getMonth()+1;
		  
		String finalFormate = YYYY+"-"+MM+"-"+DD;
		System.out.println(finalFormate);
		return finalFormate;
		
	}
	
	
}

