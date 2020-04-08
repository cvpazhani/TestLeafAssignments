package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W2D2CheckBoxAssignment {

	public static void main(String[] args) throws InterruptedException {
		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("http://www.leafground.com/pages/checkbox.html");

		//find all the check boxes and select 
		List<WebElement> allCheckBoxes = driver.findElementsByXPath("//label[text()='Select all below checkboxes ']/following::input");
		System.out.println(allCheckBoxes.size());
		for (int i = 0; i <= allCheckBoxes.size()-1; i++) {
			if (!allCheckBoxes.get(i).isSelected()) {
				allCheckBoxes.get(i).click();
			}

		}
	}
}

