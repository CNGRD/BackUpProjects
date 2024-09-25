package com.ninza.hrm.api.genericutility;

/**
 * 
 * @author Nithin
 * 
 */
import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream("./ConfigEnvData/configEnvData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data=pObj.getProperty(key);
		
		return data;
		
	}

}
