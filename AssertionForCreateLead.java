package assertion;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionForCreateLead 
{   
	@Test
	public void CreateLeadd()
	{
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leaftaps.com/opentaps/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementById("username").sendKeys("democsr");
			driver.findElementById("password").sendKeys("crmsfa");
			driver.findElementByClassName("decorativeSubmit").click();
			driver.findElementByLinkText("CRM/SFA").click();
			driver.findElementByLinkText("Leads").click();
			driver.findElementByLinkText("Create Lead").click();
			driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
			driver.findElementById("createLeadForm_firstName").sendKeys("Hari");
			driver.findElementById("createLeadForm_lastName").sendKeys("R");
			driver.findElementByName("submitButton").click();
			boolean firstnamedisp = driver.findElement(By.id("viewLead_firstName_sp")).isDisplayed();
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(firstnamedisp);
			driver.close();
			softassert.assertAll();
	}
	

}
