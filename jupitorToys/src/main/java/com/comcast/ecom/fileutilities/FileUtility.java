package com.comcast.ecom.fileutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Data/commondata.properties");
		Properties obj=new Properties();
		obj.load(fis);
		String data=obj.getProperty(Key);
		return data;
		
	}

}
