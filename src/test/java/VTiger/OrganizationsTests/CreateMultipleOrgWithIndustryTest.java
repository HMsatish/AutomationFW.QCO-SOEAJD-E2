package VTiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass{

	
	@Test(groups = {"SmokeSuite","RegressionSuite"},dataProvider = "GetData")
	public void createMultipleOrgWithIndustryTest(String ORG,String INDUSTRY ,String TYPE) throws Throwable {
		        //step 3:Navigate to Organizations link 
		        HomePage hp = new HomePage(driver);
				hp.clickOnOrgLink();
							    
				//step 4:Click on Create Organization look Up Image 
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				System.out.println("hi");
								
				//step 5:Create Organization with Mandatory fields And Select "Energy" in the industry drop down and Select "Customer" in the Type Drop down
				String ORGNAME =ORG+jUtil.getRamdomNumber();
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createNewOrg(ORGNAME, INDUSTRY, TYPE);
								
				//step 6:Validate.
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getOrgHeader();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));	
	}
	
	@DataProvider(name="GetData")
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
		
	}
}
