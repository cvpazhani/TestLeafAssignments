package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LeaftapActions {

	public static void main(String[] args) {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome brower
		ChromeDriver driver = new ChromeDriver();

		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		//find the elements to be selected
		WebElement item7 = driver.findElementByXPath("//ol[@id='selectable']//li[7]");
		WebElement item4 = driver.findElementByXPath("//ol[@id='selectable']//li[4]");
		
		//Create Action Class
		Actions builder = new Actions(driver);
		
		//Select the items from 7 to 4 in reverse order
		builder.clickAndHold(item7).release(item4).perform();
		
	}
}
