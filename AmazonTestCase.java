package week1.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTestCase {

	public static void main(String[] args) {
		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		//Timeout
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("https://www.amazon.in/");
		
		//Select All Books category from the main navigation menu
		driver.findElementById("nav-hamburger-menu").click();
		driver.findElementByLinkText("Books & Audible").click();
		driver.findElementByLinkText("Fiction Books").click();
		
		//Select the first book from the Best Seller Books category
		driver.findElementByXPath("(//span[@class='a-size-base a-color-base'])[1]").click();
		
		//Fetch Author Name
		String authorName = driver.findElementByXPath("(//a[@class='a-link-normal'])[2]").getText();
		System.out.println(authorName);
		
		
	}
}
