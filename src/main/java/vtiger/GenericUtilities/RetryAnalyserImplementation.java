package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provide implementation for IRetryAnalyzer interface
 * @author Satish
 *
 */
public class RetryAnalyserImplementation  implements IRetryAnalyzer{

	int count=1;
	int retryCount=3;
	
	public boolean retry(ITestResult result) {
		
		while (count<=retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
