package assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
@Test
	public void Dupe() throws InterruptedException {
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
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("13002");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		String text01 = driver.findElement(By.xpath("//div[@class ='x-paging-info']")).getText();
		if(text01.equalsIgnoreCase("No records to display"))
		{
			System.out.print(text01);
			System.out.print(". Please create a record and then create its duplicate");
			driver.close();
		}
		else
		{
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementByName("submitButton").click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("13002");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElement(By.xpath("//div[contains(text(), 'Displaying records')]")).getText();
            SoftAssert softassert = new SoftAssert();
			softassert.assertNotEquals("No records to display", text);
			softassert.assertNotEquals("Displaying records 1 - 1 of 1", text);
			System.out.println("Duplicte record is created");
			driver.close();
			softassert.assertAll();
		}
}
}
