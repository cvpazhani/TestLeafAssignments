package week2.day3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

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

		//Click on the Create Lead Link from the Shortcuts Panel in the left side of the My Home page
		driver.findElementByLinkText("Create Lead").click();


		//Create the Lead with the mandatory fields in Create Lead Page
		driver.findElementById("createLeadForm_companyName").sendKeys("test");
		driver.findElementById("createLeadForm_firstName").sendKeys("test");
		driver.findElementById("createLeadForm_lastName").sendKeys("test");
		
		//Find the Source dropdwon
		WebElement sourceDropDown = driver.findElementById("createLeadForm_dataSourceId");
		
		//Create a select class for the source dropdown
		Select sdropdown = new Select(sourceDropDown);
		
		//select the value by a visible text
		sdropdown.selectByVisibleText("Cold Call");
		
		
		//Find the Industry dropdown
		WebElement industryDropDown = driver.findElementById("createLeadForm_industryEnumId");
		
		//Create a select class for the source dropdown
		Select idropdown = new Select(industryDropDown);
		
		//Find the number of values inside industry dropdown
		int industryDropDownCount = idropdown.getOptions().size();
		
		//Select last value of the dropdown
		
		idropdown.selectByIndex(industryDropDownCount-1);
		
		
		//After entering the mandatory details, click on Create Lead button to create a lead
		driver.findElementByXPath("//input[@value='Create Lead']").click();

		String title = driver.getTitle();
		System.out.println(title);

		if(title =="View Lead | opentabs CRM")
		{
			System.out.println("Lead Created");
		}

	}
}
