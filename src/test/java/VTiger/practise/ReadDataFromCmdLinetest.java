package VTiger.practise;

import org.testng.annotations.Test;

public class ReadDataFromCmdLinetest {

	@Test
	public void read() {
		String UN = System.getProperty("userName");
		System.out.println(UN);
		String pwd = System.getProperty("password");
		System.out.println(pwd);
	}
}
