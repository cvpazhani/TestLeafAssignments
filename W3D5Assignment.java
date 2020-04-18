package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class W3D5Assignment {

	public static void main(String[] args) throws InterruptedException {

		//add  system property : webdriver.chrome.driver, system is a java class which is in built, setproperty is the method available in the system class(again which is a static class and no need to create an object/reference for the class and we can call the class by its name directly)
		System.setProperty("webdriver.chrome.driver", "D:/Eclipse/Workspace/MavenProject/drivers/chromedriver.exe");

		//Open the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Open the webpage using the get method available in the ChromeDriver class by calling a reference object(driver)
		driver.get("https://dev92474.service-now.com/");

		//Switch to the fram
		driver.switchTo().frame("gsft_main");

		//Login with valid credentials username as admin and password as India@123 
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("India@123");

		driver.findElementById("sysverb_login").click();

		//Enter Incident in filter navigator and press enter 
		driver.findElementByXPath("//div[@class='input-group-transparent']//input[@id='filter']").sendKeys("Incident");

		Thread.sleep(1000);

		//Click on Create new option Under Incident 
		driver.findElementByXPath("//a[contains(@href,'incident.do')]//div/div").click();

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		Thread.sleep(3000);
		//Get the text of Number Field and Store it in a String
		String incidentNumber = driver.findElementByXPath("//div[@id='element.incident.number']/div[2]/input").getAttribute("Value");
		System.out.println(incidentNumber);

		//Click on the Search Button Available in the Caller Field & Choose First Value Opened in the new Window
		driver.findElementByXPath("//div[@class='input-group ref-container']//button[@id='lookup.incident.caller_id']").click();

		//Switch to another window
		Set<String> callerWindow = driver.getWindowHandles();
		List<String> Win = new ArrayList<String>(callerWindow);
		driver.switchTo().window(Win.get(1));

		//Choose the first value in the caller window
		driver.findElementByXPath("//tbody[@class='list2_body']/tr[3]/td[3]/a").click();

		//Switch back to the current window
		driver.switchTo().window(Win.get(0));
		System.out.println(driver.getTitle());

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		//Select the Value as Software in Category Field		
		WebElement categorydropdown = driver.findElementByName("incident.category");
		Select categorydd = new Select(categorydropdown);
		categorydd.selectByValue("software");
		//		categorydd.selectByIndex(2);


		//Select Internal Application in Sub Category Field
		WebElement subcategorydropdown = driver.findElementByName("incident.subcategory");
		Select subcategorydd = new Select(subcategorydropdown);
		subcategorydd.selectByIndex(2);

		//Select Walk-in in Contact Type Field
		WebElement contacttypedropdown = driver.findElementByName("incident.contact_type");
		Select contacttypedd = new Select(contacttypedropdown);
		contacttypedd.selectByValue("walk-in");

		//Select state as In-Progress 
		WebElement statedropdown = driver.findElementByName("incident.state");
		Select statedd = new Select(statedropdown);
		statedd.selectByValue("2");

		//Select state as In-Progress 
		WebElement urgencyropdown = driver.findElementByName("incident.urgency");
		Select urgencydd = new Select(urgencyropdown);
		urgencydd.selectByValue("2");

		//Click on the Search Button Available in the Assignment Group & Choose Last Residing Value Opened in new Window
		driver.findElementByName("lookup.incident.assignment_group").click();

		//Switch to another window
		Set<String> callerWindow1 = driver.getWindowHandles();
		List<String> Win1 = new ArrayList<String>(callerWindow1);
		driver.switchTo().window(Win1.get(1));

		List<WebElement> assignmentLink = driver.findElementsByClassName("glide_ref_item_link");
		int assignmentLinkCount = assignmentLink.size();
		System.out.println(assignmentLinkCount);
		assignmentLink.get(assignmentLinkCount-1).click();

		//Switch back to current window
		driver.switchTo().window(Win1.get(0));

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		//Enter Short Description as "Creating Incident For the Purpose of Management"
		driver.findElementById("incident.short_description").sendKeys("Creating Incident For the Purpose of Management");

		//Click on the Submit Button
		driver.findElementById("sysverb_insert_bottom").click();

		Thread.sleep(5000);
		//Enter Incident in filter navigator and press enter 
		driver.findElementByXPath("//input[@class='form-control'][1]").sendKeys(incidentNumber,Keys.ENTER);

		Thread.sleep(3000);
		//Click on the newly Created Incident Displayed
		driver.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").click();

		Thread.sleep(2000);
		//Get the newly created incident number
		String newlyCreatedincidentNumber = driver.findElementByXPath("//div[@id='element.incident.number']/div[2]/input").getAttribute("Value");
		System.out.println(newlyCreatedincidentNumber);

		if (newlyCreatedincidentNumber.equals(incidentNumber)) {

			System.out.println("Newly created incident number"+newlyCreatedincidentNumber +" is matching with "+incidentNumber);
		}

		Thread.sleep(1000);
		//Select Impact as High 
		WebElement impactropdown = driver.findElementByName("incident.urgency");
		Select impactdd = new Select(impactropdown);
		impactdd.selectByValue("1");

		//Update Description as "Successfully Created an incident"
		driver.findElementById("incident.description").sendKeys("Successfully Created an incident");

		//Enter Work Notes as "Done Right"
		driver.findElementById("activity-stream-textarea").sendKeys("Done Right");

		Thread.sleep(1000);
		//Click on the Update button.
		driver.findElementById("sysverb_update_bottom").click();

		Thread.sleep(1000);
		//Switch to parent frame
		driver.switchTo().parentFrame();
		//Logout and Close
		driver.findElementById("user_info_dropdown").click();
		driver.findElementByXPath("//a[text()='Logout']").click();
		driver.close();
	}

}
