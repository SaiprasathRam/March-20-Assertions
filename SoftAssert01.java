package assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssert01
{
 @Test
 public void SoftAssertionMethod()
 {
	  String expTitle ="LeafTaps - TestLeaf Automation";
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demoCSR");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		boolean linkPresentCheck = driver.findElementByLinkText("CRM/SFA").isDisplayed();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		String actTitle = driver.getTitle();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actTitle, expTitle);
		softassert.assertFalse(linkPresentCheck);
		driver.close();
		System.out.println("Soft Assertion completed");
		softassert.assertAll();
	 
 }
}
