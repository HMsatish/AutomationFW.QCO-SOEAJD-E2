package VTiger.practise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VendorsModule extends BaseClass {
    
	@Test
	public void createVendor () throws Throwable {
		//step 3:Navigate to more link 
		WebElement moreLink = driver.findElement(By.xpath("//a[.='More']"));
	    wUtil.mouseHoverAction(driver, moreLink);
		
	    //step 4:Navigate to Vendors link 
	    driver.findElement(By.name("Vendors")).click();
			
	    //step 5:Click on Create Vendors look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
			
		//step 5:Create Vendors with Mandatory fields
		String VendorName =eUtil.getDataFromExcel("Vendors",1,2)+jUtil.getRamdomNumber();
		driver.findElement(By.name("vendorname")).sendKeys(VendorName);
			
		//step 6:Save and Verify.
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String title = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (title.contains(VendorName)) {
			assertEquals(title.contains(VendorName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		
	}
	
	@Test
	public void CreateVendorWithGLAccount () throws Throwable {
		//step 3:Navigate to more link 
		WebElement moreLink = driver.findElement(By.xpath("//a[.='More']"));
	    wUtil.mouseHoverAction(driver, moreLink);
		
	    //step 4:Navigate to Vendors link 
	    driver.findElement(By.name("Vendors")).click();
			
	    //step 5:Click on Create Vendors look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
			
		//step 5:Create Vendors with Mandatory fields
		String VendorName =eUtil.getDataFromExcel("Vendors",4,2)+jUtil.getRamdomNumber();
		driver.findElement(By.name("vendorname")).sendKeys(VendorName);
		
		//step 6:Select "303-Interest-Income" in the GL Account  drop down
		WebElement GLAccountDropDown = driver.findElement(By.name("glacct"));
		wUtil.handleDropDown(GLAccountDropDown, eUtil.getDataFromExcel("Vendors",4,3));
		
		//step 7:Save and Verify.
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String title = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (title.contains(VendorName)) {
			assertEquals(title.contains(VendorName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		
	}
	
}
