package com.ninza.hrm.api.genericutility;
/**
 * 
 * @author Nithin
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	static Connection conn=null;
	static ResultSet result=null;
   static FileUtility fLib=new FileUtility();
   /**
    * 
    * @param url
    * @param username
    * @param password
    * @throws SQLException
    */
    public boolean executeQueryVerifyAndGetData(String query,int colIndex,String expectedData) throws SQLException
    {
    	boolean flag=false;
    	result=conn.createStatement().executeQuery(query);
    	while(result.next())
    	{
    		if(result.getString(colIndex).equals(expectedData))
    		{
    			flag=true;
    			break;
    		}
    	}
    	if(flag)
    	{
    		System.out.println(expectedData+" =====>data verified in data base table");
    		return true;
    	}
    	else
    	{
    		System.out.println(colIndex+" =======> data not verified in data base table");
    		return false;
    	}
    	
    	
    }
   
    public void getConnection(String url,String username,String password) throws SQLException
	{
		
		try 
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			conn=DriverManager.getConnection(url,username,password);
			
		} 
		catch (Exception e) 
		{
			System.out.println("Sql Exception Caught");
		}
	}
	public void getDbConnection() throws SQLException
	{
		
		try 
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			conn=DriverManager.getConnection(fLib.getDataFromPropertiesFile("DBUrl"),fLib.getDataFromPropertiesFile("DB_Username"), fLib.getDataFromPropertiesFile("Db_Password"));
			
		} 
		catch (Exception e) 
		{
			System.out.println("Sql Exception Caught");
		}
	}
	public void closeDbconnection() throws SQLException
	{
		conn.close();
	}

	public ResultSet executeNonSelectQuery(String query) throws SQLException
	{
		ResultSet res=null;
		try {
			java.sql.Statement stat = conn.createStatement();
			res= stat.executeQuery(query);
			
		} catch (Exception e) 
		{
			System.out.println("SQL Exception Caught");
		}
		return res;
	}
	
	public int nonSelectQuery(String query)
	{
		int res=0;
		try 
		{
			Statement stat=conn.createStatement();
			 res=stat.executeUpdate(query);
			
		} 
		catch (Exception e) 
		{
			System.out.println("SQL exception caught");
		}
		return res;
	}
	

}
