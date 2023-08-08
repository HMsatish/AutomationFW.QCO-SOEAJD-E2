package VTiger.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest  extends BaseClass{

	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createContactWithOrganizationTest() throws Throwable 
	{
		//step 3:Navigate to Organizations link 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
			    
		//step 4:Click on Create Organization look Up Image 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
				
		//step 5:Create Organization with Mandatory fields
		String ORGNAME =eUtil.getDataFromExcel("Organizations",1,2)+jUtil.getRamdomNumber();
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME);
				
		//step 6:Validate.
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		//step 7:Navigate to Contacts link
		hp.clickOnContactLink();
					
		//step 8:Click on Create contact look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
				
		//step 9:Create Contact with Mandatory fields.
		String LASTNAME=eUtil.getDataFromExcel("Contacts", 4, 2)+jUtil.getRamdomNumber();
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
				
		//step 10: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String headerText = cip.getContactText();
		Assert.assertTrue(headerText.contains(LASTNAME));
		
	}
}
