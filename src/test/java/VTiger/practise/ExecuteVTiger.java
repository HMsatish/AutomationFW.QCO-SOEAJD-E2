package VTiger.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExecuteVTiger {

	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
		Test.maximizeWindow(driver);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
	}

}
