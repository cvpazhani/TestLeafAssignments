package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LeafGroundWebTable {

	public static void main(String[] args) throws InterruptedException {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("http://www.leafground.com/pages/table.html");

		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Find the table
		WebElement table = driver.findElementById("table_id");

		//Find the number of rows in the webtable
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int rowsCount = allRows.size();
		System.out.println(rowsCount);
		
		//Find the number of columns in the row
		
		List<WebElement> allColumns = allRows.get(1).findElements(By.tagName("td"));
		int coloumnCount = allColumns.size();
		System.out.println(coloumnCount);
		
		for (int i = 1; i <= rowsCount-1; i++) {
			String firstColoumn= allRows.get(i).findElement(By.tagName("td")).getText();
			if (firstColoumn.equals("Learn to interact with Elements")) {
				String progressValue= allRows.get(i).findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td")).getText();
				System.out.println(progressValue);
				boolean vitalTaskValue = allRows.get(i).findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td[2]")).isSelected();
				System.out.println(vitalTaskValue);
			}
			/*
			 * String Progress = ""; WebElement progressValues =
			 * allRows.get(i).findElement(By.xpath("//tr[@class='even']/td[2]")); // String
			 * leastProgress[] = progressValues; String linkText = progressValues.getText();
			 * Progress= linkText; System.out.println(Progress);
			 */
		}
	
	}
}

