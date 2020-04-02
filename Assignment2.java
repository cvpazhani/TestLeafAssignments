package week1.day3;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {

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
		
		//Get the Welcome Sales Manager text
		String text = driver.findElementByTagName("h2").getText();
		System.out.println(text.length());
		String substring = text.substring(8, 26);
		System.out.println(substring);

		
	}
}
