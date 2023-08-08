package VTiger.practise;

import java.util.ResourceBundle;

public class PropertyFilePracties {

	public static void main(String[] args) {
		/*Aproach 1
		//step 1:Load the Document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2:Create object of Properties class from java.util
		Properties pObj=new Properties();
		
		//step 3:Load the file into properties file
		pObj.load(fis);
		
		//step 4:Provide the key and get the value
		String value = pObj.getProperty("Username");
		System.out.println(value);
		*/
		
		//Aproach 2
		ResourceBundle rb = ResourceBundle.getBundle("CommonData");
		String value = rb.getString("Url");
		System.out.println(value);

	}

}
