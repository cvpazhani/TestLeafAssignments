package week1.day3;

public class AsciiChar {

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

	}
}
