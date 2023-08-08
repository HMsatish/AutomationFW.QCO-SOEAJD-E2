package VTiger.practise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModule extends BaseClass {

	@Test
	public void CreateContacts() throws Throwable {
		//step 3:Navigate to Contacts link
			driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
				
		//step 4:Click on Create contact look Up Image
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
		//step 5:Create Contact with Mandatory fields.
			String Lastname=eUtil.getDataFromExcel("Contacts", 1, 2)+jUtil.getRamdomNumber();
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname);
			
		//step 6:Save and Verify
			driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
			String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (headerText.contains(Lastname)) {
				assertEquals(headerText.contains(Lastname),true);
				System.out.println("Test pass");
			} else {
				System.out.println("Test fail");
			}		
	}
	
	@Test
	public void CreateContactWithOrganization() throws Throwable {
		
		//step 3:Navigate to Organizations link 
	    	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
			
	    //step 4:Click on Create Organization look Up Image 
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
		//step 5:Create Organization with Mandatory fields
		String OrgName =eUtil.getDataFromExcel("Organizations",1,2)+jUtil.getRamdomNumber();
			driver.findElement(By.name("accountname")).sendKeys(OrgName);
			
		//step 6:Save button
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			
			
		//step 7:Validate for Organization	
			String title = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (title.contains(OrgName)) {
				assertEquals(title.contains(OrgName),true);
				System.out.println("Test pass");
			} else {
				System.out.println("Test fail");
			}
		
		//step 8:Navigate to Contacts link
			driver.findElement(By.linkText("Contacts")).click();
			
	    //step 9:Click on Create contact look Up Image
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
		//step 10:Create Contact with Mandatory fields.
			String Lastname=eUtil.getDataFromExcel("Contacts", 4, 2);
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname);
		
		//step 11:Select the Organization from organization look up image
			driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
			
		//step 12:swith to child window
			wUtil.switchToWindow("Accounts",driver);
			
		//step 13:Search for Organization
			driver.findElement(By.id("search_txt")).sendKeys(OrgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
			wUtil.switchToWindow("Contacts",driver);
			
	    //step 14:Save and Verify
			driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
			String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (headerText.contains(Lastname)) {
				assertEquals(headerText.contains(Lastname),true);
				System.out.println("Test pass");
			} else {
				System.out.println("Test fail");
			}	
	}
}
