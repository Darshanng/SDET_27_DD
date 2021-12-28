package com.vitger.comcast.genericutility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {
	
	
	public String getPropertyKeyValue(String key) throws Throwable  {
	 FileInputStream fis = new FileInputStream("./Data/commondata.properties");
	Properties pobj= new Properties();
	pobj.load(fis);
	return pobj.getProperty(key);
}
}