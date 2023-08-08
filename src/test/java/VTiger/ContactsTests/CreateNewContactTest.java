package VTiger.ContactsTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

@Listeners(vtiger.GenericUtilities.ListenersImplementationClass.class)
public class CreateNewContactTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createNewContactTest() throws Throwable 
	{
		//step 3:Navigate to Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		Reporter.log("Clicked on contact");
			
		//step 4:Click on Create contact look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("Clicked on Create contact look Up Image");
		
		//step 5:Create Contact with Mandatory fields.
		String LASTNAME=eUtil.getDataFromExcel("Contacts", 1, 2)+jUtil.getRamdomNumber();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Contact created");
		
		//step 6: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerText = cip.getContactText();
		//wUtil.drowBorder(driver, cip.getContactHeaderText());
		Assert.assertTrue(headerText.contains(LASTNAME));
		//Assert.fail();
		Reporter.log("Test Pass");
	}
}
