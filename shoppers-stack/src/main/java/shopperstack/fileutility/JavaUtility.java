package shopperstack.fileutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int generateRandomNum(int range) {
		Random ran=new Random();
		int randomNumber=ran.nextInt(range);
		return randomNumber;
	}
	
	public String getSystemDate() {
		Date dateObj=new Date();
		String date = dateObj.toString();
		return date.replace(" ", "_").replace(":", "_");
	}
	
	public void getSystemDateInDD_MM_YYYY() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date dateObj=new Date();
		String date = sdf.format(dateObj);
		System.out.println(date);
		
	}
	
	
	
}
