package VTiger.OrganizationsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateNewOrganizationTest extends BaseClass {

	@Test(groups = {"SmokeSuite","RegressionSuite"},invocationCount = 2,priority = 1)
	public void createNewOrgTest() throws Throwable {
		
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
	}
	
}
