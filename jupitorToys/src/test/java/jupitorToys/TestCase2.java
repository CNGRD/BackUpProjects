package jupitorToys;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.ecom.baseUtil.BaseClass;
import com.comcast.ecom.listenerImplementationClass.ListenerImplementationClass;
import com.comcast.ecom.objectRepo.ContactsPage;
import com.comcast.ecom.objectRepo.HomePage;

@Listeners(ListenerImplementationClass.class)
public class TestCase2 extends BaseClass
{
	@Test
	public void clickOnContactSubmitButtonTest() throws EncryptedDocumentException, IOException
	{
		ContactsPage c=new ContactsPage(driver);
		HomePage hPage=new HomePage(driver);
		hPage.navigateToContactsPage(driver);
		
		String foreName = elib.getDataFromExcel("data", 1, 0);
		String surName=elib.getDataFromExcel("data", 1, 1);
		String email=elib.getDataFromExcel("data", 1, 2);
		String phno=elib.getDataFromExcel("data", 1, 3);
		String message=elib.getDataFromExcel("data", 1, 4);
		c.populateAllFields(foreName, surName, email, phno, message);
		System.out.println("Successfully completed testcase 2");

	}
}
