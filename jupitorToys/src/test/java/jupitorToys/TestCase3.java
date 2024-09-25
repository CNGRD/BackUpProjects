package jupitorToys;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.ecom.baseUtil.BaseClass;
import com.comcast.ecom.javaUtility.WebDriverUtility;
import com.comcast.ecom.listenerImplementationClass.ListenerImplementationClass;
import com.comcast.ecom.objectRepo.CartPage;
import com.comcast.ecom.objectRepo.ToysPage;

@Listeners(ListenerImplementationClass.class)
public class TestCase3 extends BaseClass
{
	
	@Test
	public void addToysAndpriceTest() throws IOException, InterruptedException
	{
		
		String IndStuffedFrogPrice=elib.getDataFromExcel("price", 1, 0);
		String IndFluffyBunnyPrice=elib.getDataFromExcel("price", 1, 1);
		String IndValentineBearPrice=elib.getDataFromExcel("price", 1, 2);
		
		//subtotal
		String subtotalStuffedFrogPrice=elib.getDataFromExcel("price", 5, 0);
		String subtotalFluffyBunnyPrice=elib.getDataFromExcel("price", 5, 1);
		String subtotalValentineBearPrice=elib.getDataFromExcel("price", 5, 2);
		
		
		//Total Price
		String expTotalPrice=elib.getDataFromExcel("price", 8, 1);
		
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.waitForPageToLoad(driver);
		CartPage cPage=new CartPage(driver);
		
		cPage.addTocart();
		cPage.getCartClick().click();
		//individual price validation
		ToysPage tPage=new ToysPage(driver);
		tPage.validateIndProPrice(IndStuffedFrogPrice, IndFluffyBunnyPrice, IndValentineBearPrice);
		Thread.sleep(2000);
		//subtotal validation
		 tPage.validateSubTotalOfEach(subtotalStuffedFrogPrice, subtotalFluffyBunnyPrice, subtotalValentineBearPrice);
		 Thread.sleep(2000);
		//total validation
		 tPage.validateTotal(expTotalPrice);
		 
		
		
		
	}

}
