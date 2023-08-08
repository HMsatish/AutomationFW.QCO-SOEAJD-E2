package VTiger.practise;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class PractiiceGenericUtilityMethod {

	public static void main(String[] args) throws Throwable {
		JavaUtility jUtile=new JavaUtility();
		int randomNumber=jUtile.getRamdomNumber();
		System.out.println(randomNumber);
		System.out.println(jUtile.getSystemDate());
		
		PropertyFileUtility pUtile=new PropertyFileUtility();
		String value = pUtile.getDataFromPropertyFile("Url");
		System.out.println(value);
		System.out.println(pUtile.readDataFromPropertyFile("browser"));
		
		ExcelFileUtility eUtile=new ExcelFileUtility();
		String data=eUtile.getDataFromExcel("Organizations", 1, 2);
		System.out.println(data);
	}

}
