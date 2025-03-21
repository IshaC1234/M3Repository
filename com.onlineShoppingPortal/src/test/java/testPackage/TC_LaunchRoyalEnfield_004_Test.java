package testPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_LaunchRoyalEnfield_004_Test {
  @Test
  public void launchRoyalEnfield() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://www.ktmindia.com/");
	  Thread.sleep(3000);
	  driver.quit();
  }
}
