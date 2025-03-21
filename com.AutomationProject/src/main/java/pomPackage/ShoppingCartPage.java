package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	//declaration
	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']") 
	private WebElement smartPhoneCartProductButton;
	
	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@title='Show details for Smartphone']/../..//input[@name='removefromcart']")
	private WebElement smartphoneCheckBox;

	@FindBy(name = "updatecart")
	private WebElement updatecartButton;
	@FindBy(name = "continueshopping")
	private WebElement continueShoopingButton;
	@FindBy(id = "checkout")
	private WebElement checkoutButton;
	
	@FindBy(id = "termsofservice") private WebElement termOfServiceCheckbox;

	
	//initialization
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getSmartPhoneCartProductButton() {
		return smartPhoneCartProductButton;
	}


	public WebElement getSmartphoneCheckBox() {
		return smartphoneCheckBox;
	}


	public WebElement getUpdatecartButton() {
		return updatecartButton;
	}


	public WebElement getContinueShoopingButton() {
		return continueShoopingButton;
	}


	public WebElement getCheckoutButton() {
		return checkoutButton;
	}


	public WebElement getTermOfServiceCheckbox() {
		return termOfServiceCheckbox;
	}	
}
