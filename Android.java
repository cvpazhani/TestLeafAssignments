package week1.day1;

public class Android {
	
	String mobModel = "SamsungM30";
	boolean isTouchMobile = true;
	int mobPrice = 24000;
	float softwareVersion = 13.23f; 
	long mobICCID = 23243243;

	public static void main(String[] args) {

		//Printing syso statement
		System.out.println("Am Ready");
		//Create an object for the class Mobile
		Android mob = new Android();
		
		//Print Mobile Model
		String mobModel2 = mob.mobModel;
		System.out.println(mobModel2);
		
		//Print Mobile type
		boolean isTouchMobile2 = mob.isTouchMobile;
		System.out.println(isTouchMobile2);
		
		//Print Mobile price
		int mobPrice2 = mob.mobPrice;
		System.out.println(mobPrice2);
		
		//Print Mobile Software Version		
		float softwareVersion2 = mob.softwareVersion;
		System.out.println(softwareVersion2);
		
		//Print Mobile ICCID 
		long mobICCID2 = mob.mobICCID;
		System.out.println(mobICCID2);
	}
}
