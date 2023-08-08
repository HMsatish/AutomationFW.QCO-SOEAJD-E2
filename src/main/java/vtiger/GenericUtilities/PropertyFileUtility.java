package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * this class consist of all the generic methods related to property file
 * @author Satish
 *
 */
public class PropertyFileUtility {
	
	
	/**
	 * this method reads data from property file based on given key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj.getProperty(key);
	}
	
	/**
	 * this method reads data from property file based on given key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable {
		ResourceBundle rb = ResourceBundle.getBundle("CommonData");
		return rb.getString(key);
	}
	
	
	
}
