package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		//Timeout
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("https://acme-test.uipath.com/account/login");
		
		//Enter Email Id
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		
		//Enter Password
		driver.findElementById("password").sendKeys("leaf@12");
		
		//Click on LogIn button
		driver.findElementById("buttonLogin").click();
		
		//Mouse Over Action
		WebElement elementByXPath = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(driver);
		builder.moveToElement(elementByXPath).perform();
		
		//Clicking on Vendor Search Mouse Over link
		driver.findElementByXPath("//a[@href='/vendors/search']").click();
		
		//Find Vendor Name 
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		
		//Click on Search
		driver.findElementById("buttonSearch").click();
		
		//Find the Country name based on the vendor
		String country = driver.findElementByXPath("//table[@class='table']/tbody[1]/tr[2]/td[5]").getText();
		System.out.println(country);
		
		//Logout
		driver.findElementByXPath("//a[@href='/account/logout/']").click();
		
		//Close browser
		driver.close();
		
		
		
		
		
	}

}
