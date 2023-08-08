package VTiger.practise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OpportunityModule extends BaseClass{

	@Test
	public void createOpportunityWithContact() throws Throwable  {
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
		
		//step 7:Navigate to Opportunities link
		driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
			
		//step 8:Click on Create Opportunity look up image
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			
		//step 9:Create Opportunity with manadatory fields
		String opportunityName=jUtil.getRandomeString()+" "+eUtil.getDataFromExcel("Opportunity", 1, 2);
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(opportunityName);
		
		//step 10:Select the Contacts from Related To drop down
		WebElement relatedToDropDown = driver.findElement(By.id("related_to_type"));
		wUtil.handleDropDown(relatedToDropDown,eUtil.getDataFromExcel("Opportunity", 1, 3));
		
		//step 11:Select the Contacts from Contacts look up image
		driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img")).click();
		
		//step 12:swith to child window
		wUtil.switchToWindow("Contacts", driver);
		
		//step 13:Search for Contacts
		driver.findElement(By.id("search_txt")).sendKeys(Lastname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[normalize-space()='"+Lastname+"']")).click();
		wUtil.switchToWindow("Potentials", driver);
		
		
		//step 14:Save and Verify
		driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
		String oppoHeaderText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (oppoHeaderText.contains(opportunityName)) {
			assertEquals(oppoHeaderText.contains(opportunityName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}	
	}
	
	@Test
	public void createOpportunityWithOrganizations() throws Throwable  {
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
		
		//step 7:Navigate to Opportunities link
		driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
			
		//step 8:Click on Create Opportunity look up image
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
			
		//step 9:Create Opportunity with manadatory fields
		String opportunityName=jUtil.getRandomeString()+" "+eUtil.getDataFromExcel("Opportunity", 4, 2);
		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(opportunityName);
		
		//step 10:Select the Organization from Related To drop down
		WebElement relatedToDropDown = driver.findElement(By.id("related_to_type"));
		wUtil.handleDropDown(eUtil.getDataFromExcel("Opportunity", 4, 3),relatedToDropDown);
		
		//step 11:Select the Organization from Organization look up image
		driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img")).click();
		
		//step 12:swith to child window
		wUtil.switchToWindow("Accounts", driver);
		
		//step 13:Search for Organization
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[normalize-space()='"+OrgName+"']")).click();
		wUtil.switchToWindow("Potentials", driver);
		
		
		//step 14:Save and Verify
		driver.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
		String oppoHeaderText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (oppoHeaderText.contains(opportunityName)) {
			assertEquals(oppoHeaderText.contains(opportunityName),true);
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}	
	}
}
