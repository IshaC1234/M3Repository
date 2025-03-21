package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import genericLibrary.Flib;
import genericLibrary.IAutoConstant;
import genericLibrary.SelectUtility;

public class CheckoutPage implements IAutoConstant{
	
	//Declaration
	@FindBy(id = "BillingNewAddress_CountryId")private WebElement countryDD;
	@FindBy(id = "BillingNewAddress_City")private WebElement cityTB;
	@FindBy(id = "BillingNewAddress_Address1")private WebElement address1TB;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")private WebElement pincodeTB;
	@FindBy(id = "BillingNewAddress_PhoneNumber")private WebElement phoneNOTB;
	@FindBy(xpath = "//input[@onclick='Billing.save()']")private WebElement billingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")private WebElement shippingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")private WebElement shippingMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")private WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")private WebElement paymentInfoContinueButton;
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")private WebElement confirmOrderContinueButton;
	@FindBy(xpath = "//strong[text()='Your order has been sucessfully processed!']")private WebElement orderProcessedText;
	@FindBy(id = "billing-address-select")private WebElement billingAddress01dAddressDD;
	
	//Initialization
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}

	public WebElement getCountryDD() {
		return countryDD;
	}

	public WebElement getCityTB() {
		return cityTB;
	}

	public WebElement getAddress1TB() {
		return address1TB;
	}

	public WebElement getPincodeTB() {
		return pincodeTB;
	}

	public WebElement getPhoneNOTB() {
		return phoneNOTB;
	}

	public WebElement getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}

	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}

	public WebElement getShippingMethodContinueButton() {
		return shippingMethodContinueButton;
	}

	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}

	public WebElement getPaymentInfoContinueButton() {
		return paymentInfoContinueButton;
	}

	public WebElement getConfirmOrderContinueButton() {
		return confirmOrderContinueButton;
	}

	public WebElement getOrderProcessedText() {
		return orderProcessedText;
	}
	
	public WebElement getBillingAddress01dAddressDD() {
		return billingAddress01dAddressDD;
	}
	
	//Operational Method
	public void buyProduct() throws EncryptedDocumentException, IOException
	{
		SelectUtility su = new SelectUtility();
		
		try
		{
		if(billingAddress01dAddressDD.isDisplayed()== true)
		{
			su.SelectByVisibleTextMethod(billingAddress01dAddressDD, "New Address");
		}
		}
		catch (Exception e)
		{
			su.SelectByVisibleTextMethod(countryDD, "India");
		}
		
		su.SelectByVisibleTextMethod(countryDD, "India");
		
		Flib flib = new Flib();
		int rn = flib.randomNumber();
		String city = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails",1, 0);
		String address1 = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails",1, 1);
		 long pin = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails",1, 2);
		 long phone = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails",1, 3);
		//String pin = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails",1, 2);
		//String phone = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails",1, 3);
		String phoneNo = phone+""+rn;
		
		cityTB.sendKeys(city);
		address1TB.sendKeys(address1);
		pincodeTB.sendKeys(String.valueOf(pin));
		phoneNOTB.sendKeys(String.valueOf(phoneNo));
		billingAddressContinueButton.click();
		
		shippingAddressContinueButton.click();
		shippingMethodContinueButton.click();
		paymentMethodContinueButton.click();
		paymentInfoContinueButton.click();
		confirmOrderContinueButton.click();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(orderProcessedText.isDisplayed(), true ,"Order is Not Placed!!");
		sa.assertAll();
		
	}

	
	
}
