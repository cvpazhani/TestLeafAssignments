package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("http://leaftaps.com/opentaps/control/main");

		//Find the UserName
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.sendKeys("DemoSalesManager");

		//Find the Password
		WebElement elePassword = driver.findElementByName("PASSWORD");
		elePassword.sendKeys("crmsfa");

		//Click on Login
		driver.findElementByClassName("decorativeSubmit").click();

		//Click on CRMFS Link in the Welcome Page
		driver.findElementByLinkText("CRM/SFA").click();

		//Click on leads
		driver.findElementByXPath("//a[@href='/crmsfa/control/leadsMain']").click();

		Thread.sleep(4000);

		//Click on Find Leads
		driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();

		//Click on Phone
		driver.findElementByXPath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[1]/div[1]/ul/li[2]").click();

		//Enter Phone Number
		driver.findElementByName("phoneNumber").sendKeys("1234567890");
		//Find Leads
		driver.findElementByPartialLinkText("Find Leads").click();

		Thread.sleep(4000);
		//Click First Resulting lead
		WebElement firstLead = driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]");
//		System.out.println(firstLead);
		String fLead = firstLead.getText();
		System.out.println(fLead);

		driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]").click();

		//Click on Delete button
		driver.findElementByClassName("subMenuButtonDangerous").click();

		Thread.sleep(3000);
		//Find Leads
		driver.findElementByPartialLinkText("Find Leads").click();
		
		//Find the deleted Lead
		driver.findElementByName("id").sendKeys(fLead);

		//Find No Records display message
		String errorMessage = driver.findElementByXPath("//div[@class='x-paging-info']").getText();

		if (errorMessage.equals("No records to display")) {

			System.out.println("Lead is deleted");		


		}
		driver.close();
	}
}

