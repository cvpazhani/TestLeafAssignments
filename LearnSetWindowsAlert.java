package week3.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnSetWindowsAlert {

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

		//Click on Merge Leads
		driver.findElementByXPath("//a[text()='Merge Leads']").click();

		//Find the current window id
		String fWindow = driver.getWindowHandle();

		//Click on From Lead
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();

		Thread.sleep(2000);
		
		//Switch to fromLeadWindow and enter First Name
		Set<String> fromLeadWindow = driver.getWindowHandles();
		List<String> fromLeadWin = new ArrayList<String>(fromLeadWindow);
		driver.switchTo().window(fromLeadWin.get(1));

		driver.findElementByXPath("//input[@name='firstName']").sendKeys("pals");

		//Click find leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(2000);
		
		//Select the first lead id from the result list and capture the result list
		WebElement fromLeadid = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String firstLead = fromLeadid.getText();
		System.out.println(firstLead);
		fromLeadid.click();

		//Switch back to current window
		driver.switchTo().window(fWindow);

		//Click on To Lead
		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();

		Thread.sleep(2000);
		
		//Switch to toLeadWindow and enter First Name
		Set<String> toLeadWindow = driver.getWindowHandles();
		List<String> toLeadWin = new ArrayList<String>(toLeadWindow);
		driver.switchTo().window(toLeadWin.get(1));

		driver.findElementByXPath("//input[@name='firstName']").sendKeys("pals");

		//Click find leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(2000);
		//Select the second lead id from the result list and capture the result list
		WebElement toLeadid = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		String secondLead = toLeadid.getText();
		System.out.println(secondLead);
		toLeadid.click();

		//Switch back to current window
		driver.switchTo().window(fWindow);

		Thread.sleep(2000);
		//Click on Merge button
		driver.findElementByXPath("//a[text()='Merge']").click();

		//Handle the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		Thread.sleep(2000);
		//Click on Find Leads
		driver.findElementByXPath("//a[@href='/crmsfa/control/findLeads']").click();
		
		
		//Enter the lead id
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input[@name='id']").sendKeys(firstLead);
		
		Thread.sleep(2000);
		//Click find leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		//No record to display
		if (driver.findElementByXPath("//div[text()='No records to display']").getText().equals("No records to display")) {
			System.out.println("First Lead is Merged with Second Lead"+secondLead);
		}





	}

}
