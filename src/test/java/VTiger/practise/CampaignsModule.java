package VTiger.practise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CampaignsModule extends BaseClass {

	@Test
	public void createCampaign () throws Throwable {
		//step 3:Navigate to more link 
		WebElement moreLink = driver.findElement(By.xpath("//a[.='More']"));
	    wUtil.mouseHoverAction(driver, moreLink);
		
	    //step 4:Navigate to compaigns link
	    driver.findElement(By.name("Campaigns")).click();
			
	    //step 5:Click on Create compaigns look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			
		//step 6:Create campaign with Mandatory fields
		String compaignName =jUtil.getRandomeString()+" "+eUtil.getDataFromExcel("Campaigns",1,2);
		driver.findElement(By.name("campaignname")).sendKeys(compaignName);
		
		//step 7:Choose campaign type as 'Trade Show'
		WebElement campaignTypeDropDown = driver.findElement(By.name("campaigntype"));
		wUtil.handleDropDown(campaignTypeDropDown, eUtil.getDataFromExcel("Campaigns",1,3));
		
		//step 8:Choose campaign status as 'Planning'
		WebElement campaignStatusDropDown = driver.findElement(By.name("campaignstatus"));
		wUtil.handleDropDown(campaignStatusDropDown, eUtil.getDataFromExcel("Campaigns",1,4));
		
		//step 9:Save and Verify.
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (title.contains(compaignName)) {
			assertEquals(title.contains(compaignName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
	}
	
	@Test
	public void CreateCampaignWithProduct () throws Throwable {
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
		
		//step 7:Navigate to more link 
		WebElement moreLink = driver.findElement(By.xpath("//a[.='More']"));
	    wUtil.mouseHoverAction(driver, moreLink);
		
	    //step 8:Navigate to compaigns link
	    driver.findElement(By.name("Campaigns")).click();
			
	    //step 9:Click on Create compaigns look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			
		//step 10:Create campaign with Mandatory fields
		String compaignName =jUtil.getRandomeString()+" "+eUtil.getDataFromExcel("Campaigns",4,2);
		driver.findElement(By.name("campaignname")).sendKeys(compaignName);
		
		//step 11:Choose campaign type as 'Webinar'
		WebElement campaignTypeDropDown = driver.findElement(By.name("campaigntype"));
		wUtil.handleDropDown(campaignTypeDropDown, eUtil.getDataFromExcel("Campaigns",4,3));
		
		//step 12:Choose campaign status as 'Active'
		WebElement campaignStatusDropDown = driver.findElement(By.name("campaignstatus"));
		wUtil.handleDropDown(campaignStatusDropDown, eUtil.getDataFromExcel("Campaigns",4,4));
		
		//step 13:Select the product from product look up image
		driver.findElement(By.xpath("//input[@name='product_name']/following-sibling::img")).click();
		
		//step 14:swith to child window
		wUtil.switchToWindow("Products", driver);
		
		//step 15:Search for product
		driver.findElement(By.id("search_txt")).sendKeys(productName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[normalize-space()='"+productName+"']")).click();
		wUtil.switchToWindow("Campaigns", driver);		
				
		//step 16:Save and Verify.
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String CampaignTitle = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (CampaignTitle.contains(compaignName)) {
			assertEquals(CampaignTitle.contains(compaignName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}
		
	}
}
