package assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions 
{
  @Test
  public void TestAssertions()
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
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		driver.close();
	  
  }
}
