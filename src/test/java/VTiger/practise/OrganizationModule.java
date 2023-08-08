package VTiger.practise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrganizationModule extends BaseClass{

	@Test
	public void CreateOrganization() throws Throwable {
		//step 3:Navigate to Organizations link 
		    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
				
		//step 4:Click on Create Organization look Up Image 
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
		//step 5:Create Organization with Mandatory fields
			String OrgName =eUtil.getDataFromExcel("Organizations",1,2)+jUtil.getRamdomNumber();
			driver.findElement(By.name("accountname")).sendKeys(OrgName);
				
		//step 6:Save and Verify.
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (title.contains(OrgName)) {
				assertEquals(title.contains(OrgName),true);
				System.out.println("Test pass");
			} else {
				System.out.println("Test fail");
			}
	}
	
	@Test
	public void CreateOrganizationWithIndustry() throws Throwable {
		//step 3:Navigate to Organizations link 
	    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			
	    //step 4:Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
	    //step 5:Create Organization with Mandatory fields
		String OrgName =eUtil.getDataFromExcel("Organizations",4,2)+jUtil.getRamdomNumber();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//step 6:Select "Chemicals" in the industry drop down
		WebElement industryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
		wUtil.handleDropDown(eUtil.getDataFromExcel("Organizations",4,3),industryDropDown);
		
		//step 7:Save and Verify.
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (title.contains(OrgName)) {
			assertEquals(title.contains(OrgName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}	
	}
	
	@Test
	public void CreateOrganizationWithIndustryAndType() throws Throwable {
		//step 3:Navigate to Organizations link 
	    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			
	    //step 4:Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
	    //step 5:Create Organization with Mandatory fields
		String OrgName =eUtil.getDataFromExcel("Organizations",7,2)+jUtil.getRamdomNumber();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//step 6:Select "Energy" in the industry drop down
		WebElement industryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
		wUtil.handleDropDown(eUtil.getDataFromExcel("Organizations",7,3),industryDropDown);
		
		//step 7:Select "Customer" in the Type Drop down 
		WebElement typeDropDown = driver.findElement(By.name("accounttype"));
		wUtil.handleDropDown(typeDropDown,eUtil.getDataFromExcel("Organizations",7,4) );
		
		//step 8:Save and Verify.
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (title.contains(OrgName)) {
			assertEquals(title.contains(OrgName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}	
	}
	
}
