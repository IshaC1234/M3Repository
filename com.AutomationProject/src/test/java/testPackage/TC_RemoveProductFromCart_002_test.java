package testPackage;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;

@Listeners(genericLibrary.MyListener.class)
public class TC_RemoveProductFromCart_002_test extends BaseTest {
  @Test
  public void removeProductFromCart() {
	  WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		
		ep.getSmartPhoneAddToCartButton().click();
		
		wp.getShoppingCartLink().click();
		
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		sp.getSmartphoneCheckBox().click();
		
		sp.getUpdatecartButton().click();
		
		SoftAssert sa = new SoftAssert();
		try {
		sa.assertEquals(sp.getSmartPhoneCartProductButton().isDisplayed(), false, "Product is not removed form Cart");
		}
		catch (Exception e) {
			Reporter.log("Product is removed from Cart",true);
		}
		sa.assertAll();
		
	}
  }
