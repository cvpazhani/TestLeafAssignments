package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ErailLearnList {

	public static void main(String[] args) throws InterruptedException {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");



		//Uncheck Sort on Date field
		driver.findElementById("chkSelectDateOnly").click();

		//Click on Sort on Date
//		driver.findElementByXPath("(//a[text()='Date'])[1]").click();
		
		//Get all the Train Names
		List<WebElement> listtrainNames = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
		
		//Create another List using ArrayList (trainNames)
		List<String> trainNames = new ArrayList<String>();
		
		//for each loop : List<WebElement>
		for (WebElement train : listtrainNames) {
			//You will get each WebElement : get its text
			String trainText = train.getText();
			
			//Add the text to your created list (trainNames.add())
			trainNames.add(trainText);
			System.out.println(trainNames);
		}
		Collections.sort(trainNames);
		System.out.println(trainNames);
		for (String newlist : trainNames) {
			System.out.println(newlist);
		}
		driver.close();
	}
}
