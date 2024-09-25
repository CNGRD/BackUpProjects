package com.comcast.ecom.javaUtility;

import java.util.Random;

public class JavaUtility 
{
	public int randomNumber()
	{
		Random r=new Random();
		int rand=r.nextInt(1000);
		return rand;
	}

}
