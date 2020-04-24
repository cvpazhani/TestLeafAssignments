package SeleniumExam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeManagement {

	public static void main(String[] args) throws InterruptedException {
		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		//Timeout
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("https://dev67018.service-now.com/navpage.do");

		//Switch to the fram
		driver.switchTo().frame("gsft_main");

		//Login with valid credentials username as admin and password as India@123 
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("Pazhani!23");

		driver.findElementById("sysverb_login").click();

		//Enter Incident in filter navigator and press enter 
		driver.findElementByXPath("//div[@class='input-group-transparent']//input[@id='filter']").sendKeys("Change");

		Thread.sleep(1000);
		//Click Create New in Change Management
		driver.findElementByXPath("(//div[text()='Create New'])[3]").click();

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		Thread.sleep(3000);
		//Get the text of Number Field and Store it in a String
		driver.findElementByXPath("//a[contains(text(),'Normal: Changes without')]").click();

		//Get the Change Request Number
		String changeManagementNumber = driver.findElementById("change_request.number").getAttribute("Value");
		System.out.println(changeManagementNumber);

		//Enter Short Description
		driver.findElementById("change_request.short_description").sendKeys("Create a New Change Management Request");

		//Click on Submit Button to create CM
		driver.findElementByXPath("(//button[text()='Submit'])[2]").click();

		Thread.sleep(5000);
		//Enter Incident in filter navigator and press enter 
		driver.findElementByXPath("//input[@class='form-control'][1]").sendKeys(changeManagementNumber,Keys.ENTER);

		Thread.sleep(3000);
		//Click on the newly Created Incident Displayed
		driver.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").click();
		
		Thread.sleep(2000);
		//Get the newly created incident number
		String newlyChangeManagementNumber = driver.findElementById("change_request.number").getAttribute("Value");
		System.out.println(newlyChangeManagementNumber);

		if (newlyChangeManagementNumber.equals(changeManagementNumber)) {

			System.out.println("Newly created incident number"+newlyChangeManagementNumber +" is matching with "+changeManagementNumber);
		}

	}

}
