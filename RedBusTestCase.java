package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusTestCase {

	public static void main(String[] args) throws InterruptedException {
		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		//Timeout
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("https://www.redbus.in");
		
		//Enter Source
		driver.findElementById("src").sendKeys("Chennai");
		Thread.sleep(5000);
		driver.findElementById("src").sendKeys(Keys.TAB);
		
		//Enter Destination
		driver.findElementById("dest").sendKeys("Coimbatore");
		Thread.sleep(5000);
		driver.findElementById("dest").sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		//Select the date
//		driver.findElementById("onward_cal").click();
//		driver.findElementByXPath("//label[@for='onward_cal']").click();
		
//		Thread.sleep(4000);
		//select date
		driver.findElementByXPath("(//td[text()='30'])[2]").click();
		
		//Click Search Buses
		driver.findElementById("search_btn").click();
		
		//After 6pm
		driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[2]").click();
		
		Thread.sleep(2000);
		
		//Sleeper type under Buses
		driver.findElementByXPath("(//label[@for='bt_SLEEPER'])[2]").click();
		
		Thread.sleep(2000);
		
		//Sort Seats Available
		driver.findElementByLinkText("Seats Available").click();
		//System.out.println("Hi");
		driver.close();
	}
}
