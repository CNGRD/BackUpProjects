package jupitorToys;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.ecom.baseUtil.BaseClass;
import com.comcast.ecom.listenerImplementationClass.ListenerImplementationClass;
import com.comcast.ecom.objectRepo.ContactsPage;
import com.comcast.ecom.objectRepo.HomePage;

@Listeners(ListenerImplementationClass.class)
public class JoyToysTest extends BaseClass
{
	@Test
	public void contactTest() throws IOException, InterruptedException
	{
		ContactsPage c1=new ContactsPage(driver);

		String foreNameError=elib.getDataFromExcel("error", 1, 0);
		String mailError=elib.getDataFromExcel("error", 1, 1);
		String messageError=elib.getDataFromExcel("error", 1, 2);
		
		String foreName = elib.getDataFromExcel("data", 1, 0);
		String email=elib.getDataFromExcel("data", 1, 2);
		String message=elib.getDataFromExcel("data", 1, 4);
		
		HomePage hPage=new HomePage(driver);
		hPage.navigateToContactsPage(driver);
		c1.clickOnSubmitButton();
		
		Thread.sleep(2000);
		c1.validateError(foreNameError, mailError, messageError);
		

		Thread.sleep(4000);
		c1.validateMandatoryData(foreName, email, message);
		
		System.out.println("Successfully completed first testcase");
	}


}
