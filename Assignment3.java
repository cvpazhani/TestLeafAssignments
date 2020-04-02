package week1.day3;

/*import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;*/

public class Assignment3 {

	public static void main(String[] args) {

		String inputText = "A1B2C3";
		String outputText = "";
		//Char asciiChar1 = "";
//		char[] charArray = text.toCharArray();
		for (int i=0;i>=inputText.length();i++) 
		{
			char eachChar = inputText.charAt(i);
			System.out.println(eachChar);
			
			int asciiChar = eachChar;
			asciiChar = asciiChar + 1;
			
			eachChar = (char)asciiChar;
			System.out.println(eachChar);
			
			outputText = outputText.concat(Character.toString(eachChar));
		}
		System.out.println(outputText);
		/*StringBuilder sb=new StringBuilder(text);  
		System.out.println(sb.reverse());*/

	}
}