package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.basetest.BaseClass;

@Listeners(com.comcast.crm.generic.listenerUtility.ListenerImplementationClass.class)
public class NewTest extends BaseClass{

	@Test
	public void demo()
	{
		System.out.println("------- execute -----");
		Assert.fail();
	}
}
