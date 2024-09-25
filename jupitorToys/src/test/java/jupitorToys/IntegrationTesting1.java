package jupitorToys;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.ecom.baseUtil.BaseClass;
import com.comcast.ecom.javaUtility.WebDriverUtility;
import com.comcast.ecom.objectRepo.CartPage;
import com.comcast.ecom.objectRepo.ToysPage;

public class IntegrationTesting1 extends BaseClass
{
	@Test
	public void addProductToCart() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String subtotalStuffedFrogPrice=elib.getDataFromExcel("price", 5, 0);
		String subtotalFluffyBunnyPrice=elib.getDataFromExcel("price", 5, 1);
		String subtotalValentineBearPrice=elib.getDataFromExcel("price", 5, 2);
		WebDriverUtility wLib=new WebDriverUtility();
		CartPage cPage=new CartPage(driver);
		ToysPage tPage=new ToysPage(driver);
		cPage.addTocart();
		wLib.waitForPageToLoad(driver);
		cPage.getCartClick().click();
		wLib.waitForPageToLoad(driver);
		tPage.validateSubTotalOfEach(subtotalStuffedFrogPrice, subtotalFluffyBunnyPrice, subtotalValentineBearPrice);
		System.out.println("There a dataflow between shop and cart modules");
		
	}

}
