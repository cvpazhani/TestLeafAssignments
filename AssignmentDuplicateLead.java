package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentDuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		//Timeout
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

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

		//Click on Email
		driver.findElementByXPath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[1]/div[1]/ul/li[3]/a[2]/em/span/span").click();

		//Enter Email
		driver.findElementById("ext-gen282").sendKeys("babu@testleaf.com");

		//Click find leads button
		driver.findElementById("ext-gen334").click();

		//Capture name of First Resulting lead
		String text = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").getText();

		Thread.sleep(4000);
		//Click First Resulting lead
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();

		//Click Duplicate Lead
		driver.findElementByXPath("(//a[@class='subMenuButton'])[1]").click();
		
		Thread.sleep(4000);

		// Verify the title as 'Duplicate Lead'
		String title = driver.getTitle();

		if (title.equals("Duplicate Lead | opentabs CRM")) {
			System.out.println("Title of the page is :"+ title);
		}

		//Click Create Lead
		driver.findElementByClassName("smallSubmit").click();

		//Confirm the duplicated lead name is same as captured name
		String firstName= driver.findElementById("viewLead_firstName_sp").getText();

		if (firstName.equals(text)) {
			System.out.println("duplicated lead name is same as captured name");
		}


	}
}
