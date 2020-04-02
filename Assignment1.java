package week1.day3;

/*import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;*/

public class Assignment1 {

	public static void main(String[] args) {

		String text = "Welcome";
		String revCharArray = "";
		char[] charArray = text.toCharArray();
		for (int i=charArray.length-1;i>=0;i--) 
		{
			revCharArray += charArray[i];
			System.out.println(revCharArray);

		}
		StringBuilder sb=new StringBuilder(text);  
		System.out.println(sb.reverse());

	}
}