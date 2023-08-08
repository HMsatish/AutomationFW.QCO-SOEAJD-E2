package VTiger.OrganizationsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryTest extends BaseClass{

	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createOrgWithIndustry() throws Throwable {
		
		//step 3:Navigate to Organizations link 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
			    
		//step 4:Click on Create Organization look Up Image 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
				
		//step 5:Create Organization with Mandatory fields and Select "Chemicals" in the industry drop down
		String ORGNAME =eUtil.getDataFromExcel("Organizations",4,2)+jUtil.getRamdomNumber();
		String INDUSTRY = eUtil.getDataFromExcel("Organizations",4,3);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME, INDUSTRY);
				
		//step 6:Validate.
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));	
	}
}
