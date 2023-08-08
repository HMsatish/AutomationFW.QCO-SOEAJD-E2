package VTiger.practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class photoUpload {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.karnemaka.kar.nic.in/pqrs/VerifyUpload.aspx");
		driver.findElement(By.id("ContentPlaceHolder1_txtAppId")).sendKeys("SD5044491");
		WebElement dayDrp = driver.findElement(By.id("ContentPlaceHolder1_DDDay"));
		WebElement monthDrp = driver.findElement(By.id("ContentPlaceHolder1_DDMonth"));
		WebElement yearDrp = driver.findElement(By.id("ContentPlaceHolder1_DDYear"));
		handleDropDown(dayDrp, "31");
		handleDropDown(monthDrp, "May");
		handleDropDown(yearDrp, "2000");
		Thread.sleep(5000);
		driver.findElement(By.id("ContentPlaceHolder1_Button1")).submit();
		//driver.quit();
	}

	public static void handleDropDown(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
}
