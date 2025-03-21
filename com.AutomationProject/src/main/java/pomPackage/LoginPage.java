package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(id = "Email") private WebElement emailTextBox;
	@FindBy(id = "Password") private WebElement passwordTextBox;
	@FindBy(xpath = "//input[@value='Log in']") private WebElement loginButton;
	@FindBy(id = "RememberMe") private WebElement remembermeCheckBox;
	@FindBy(linkText = "Forgot password") private WebElement forgotpasswordLink;
	
	//initialization
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRemembermeCheckBox() {
		return remembermeCheckBox;
	}

	public WebElement getForgotpasswordLink() {
		return forgotpasswordLink;
	}
	
	public void invalidLoginMethod(String email, String pass) throws InterruptedException
	{
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pass);
		loginButton.click();
		Thread.sleep(1000);
		emailTextBox.clear();
		passwordTextBox.clear();
		
	}
	
	public void validLoginMethod(String email, String pass)
	{
		emailTextBox.sendKeys(email);
		passwordTextBox.sendKeys(pass);
		loginButton.click();
	}
	
}
