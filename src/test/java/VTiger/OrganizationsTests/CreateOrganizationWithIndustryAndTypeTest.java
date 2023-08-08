package VTiger.OrganizationsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {

	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createOrgWithIndustryAndTypeTest() throws Throwable 
	{
		//step 3:Navigate to Organizations link 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
					    
		//step 4:Click on Create Organization look Up Image 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
						
		//step 5:Create Organization with Mandatory fields And Select "Energy" in the industry drop down and Select "Customer" in the Type Drop down
		String ORGNAME =eUtil.getDataFromExcel("Organizations",7,2)+jUtil.getRamdomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organizations",7,3);
		String TYPE = eUtil.getDataFromExcel("Organizations",7,4);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME, INDUSTRY, TYPE);
						
		//step 6:Validate.
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));	
	}
}
