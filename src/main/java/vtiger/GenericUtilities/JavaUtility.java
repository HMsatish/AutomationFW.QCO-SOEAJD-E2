package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * this class consist of all the generic methods related to java
 * @author Satish
 *
 */
public class JavaUtility {
	
	/**
	 * this method will genetate the system date in specific formate
	 * @return current system date
	 */
	public String getSystemDate() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH-mm-ss").format(new Date());
		return timeStamp;
	}
	
	/**
	 * This method will genetate a random number for every execution
	 * @return random value
	 */
	public int getRamdomNumber() {
		Random r=new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * This method will genetate a randome String for every execution
	 * @return randome String
	 */
	public String getRandomeString() {
		String randomeString=RandomStringUtils.randomAlphabetic(3);
		return randomeString;
	}
	
	
	/**
	 * This method will genetate a randome AlphaNumeric value for every execution
	 * @return randomAlphaNumeric value
	 */
	public String getRandomAlphaNumeric() {
		
		String str = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+num);
	}
	
	/**
	 * This method will generate the system date
	 * @return
	 */
	public String getSysDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	/**
	 * This method will generate system date in specific format
	 * @return
	 */
	public String getSystemDateinFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String day = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		
		String date = day+"-"+month+"-"+year+" "+time;
		return date;
	}
}
