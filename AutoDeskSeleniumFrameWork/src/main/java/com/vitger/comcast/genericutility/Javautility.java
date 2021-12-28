package com.vitger.comcast.genericutility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @return
 */
public class Javautility {
/**
 * it is used to generate random number
 * @return int data
 */
	public int getRandomNumber() {
		Random random=new Random();
		int intRandom = random.nextInt(1000);
		return intRandom;
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
	
	