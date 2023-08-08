package VTiger.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzesPractice {

	@Test(retryAnalyzer = vtiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void sample() {
		
		Assert.fail();
		System.out.println("Hi");
	}
}
