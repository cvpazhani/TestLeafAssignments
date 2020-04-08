package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllLinks {

	public static void main(String[] args) throws InterruptedException {
		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("http://www.leafground.com/pages/Link.html");
		
		List<WebElement> findAllLinks = driver.findElementsByTagName("a");
		int linksCount = findAllLinks.size();
		System.out.println(linksCount);
		
		findAllLinks.get(1).click();
		
		driver.navigate().back();
		Thread.sleep(1000);
		
		List<WebElement> findAllLinksAgain = driver.findElementsByPartialLinkText("Go to Home Page");
		int linksCountAgain = findAllLinksAgain.size();
		System.out.println(linksCountAgain);
		findAllLinksAgain.get(linksCountAgain-1).click();
		
		driver.navigate().back();
//		Thread.sleep(1000);
		WebElement elementFollowingText = driver.findElementByXPath("(//a[text()='Go to Home Page'])[2]/following::label");
		System.out.println(elementFollowingText.getText());
		
		
		

			}
	}

