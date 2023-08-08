package VTiger.practise;import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductsModule extends BaseClass {
	
	@Test
	public void createProduct() throws Throwable {
		//step 3:Navigate to Products link 
		    driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
				
		//step 4:Click on Create Products look Up Image 
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
		//step 5:Create Products with Mandatory fields
			String productName =eUtil.getDataFromExcel("Products",1,2)+jUtil.getRamdomNumber();
			driver.findElement(By.name("productname")).sendKeys(productName);
				
		//step 6:Save and Verify.
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			String title = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if (title.contains(productName)) {
				assertEquals(title.contains(productName),true);
				System.out.println("Test pass");
			} else {
				System.out.println("Test fail");
			} 
	}
	
	@Test
	public void createProductWithVendorAndGLAccountDropDown() throws Throwable {
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
	
		//step 7:Navigate to Products link 
		    driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
				
		//step 8:Click on Create Products look Up Image 
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
		//step 9:Create Products with Mandatory fields
			String productName =eUtil.getDataFromExcel("Products",4,2)+jUtil.getRamdomNumber();
			driver.findElement(By.name("productname")).sendKeys(productName);
			
		//step 10:Select the Vendor from Vendor look up image
			driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img")).click();
			
		//step 11:swith to child window
			wUtil.switchToWindow("Vendors", driver);
			
		//step 12:Search for Vendor
			driver.findElement(By.id("search_txt")).sendKeys(VendorName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[normalize-space()='"+VendorName+"']")).click();
			wUtil.switchToWindow("Products", driver);
			
		//step 13:Choose 303-interest-income in GL Account Drop down
			WebElement GLAccountDropDown=driver.findElement(By.name("glacct"));
			wUtil.handleDropDown(GLAccountDropDown, eUtil.getDataFromExcel("Products",4,3));
				
		//step 14:Save and Verify.
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			String productTitle = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if (productTitle.contains(productName)) {
				assertEquals(productTitle.contains(productName),true);
				System.out.println("Test pass");
			} else {
				System.out.println("Test fail");
			} 
	}
}
