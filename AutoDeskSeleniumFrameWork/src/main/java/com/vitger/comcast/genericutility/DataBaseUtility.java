package com.vitger.comcast.genericutility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DataBaseUtility {
	
	
	@BeforeSuite
	public void ConnecttoDB()
	{
		System.out.println("-----Database is connected---");
	}

	@AfterSuite
	public void closetheDB()
	{
		System.out.println("-----Database is closed---");
	}
	
}
