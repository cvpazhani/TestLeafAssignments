package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ErailWebTable {

	public static void main(String[] args) throws InterruptedException {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("https://erail.in/");

		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Uncheck Sort on Date field
		driver.findElementById("chkSelectDateOnly").click();

		//Clear the From station and enter the From station
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("CVP",Keys.TAB);

		//Clear the To station and enter the To station
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("MS",Keys.TAB);

		Thread.sleep(1000);
		//Find the Departing Train list Webtable
		WebElement departTrainTable = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']");

		Thread.sleep(3000);
		//Find all Train list from each row
		List<WebElement> allTrainRows = departTrainTable.findElements(By.tagName("tr"));
		System.out.println(allTrainRows.size());
		//WebElement trainFirstRow = allTrainRows.get(1);
		//		System.out.println(trainFirstRow);

		for (int i = 0; i <= allTrainRows.size()-1; i++) {
			WebElement trainFirstRow = allTrainRows.get(i);

			//Find the Train Name from each row
			List<WebElement> trainColumn = trainFirstRow.findElements(By.tagName("a"));
			String trainName = trainColumn.get(1).getText();
			System.out.println(trainName);
		}
	}
}
