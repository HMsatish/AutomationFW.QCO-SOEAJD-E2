package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	   // Declaration
	    @FindBy(name = "accountname")
	    private WebElement orgNameEdt ;
		
	    @FindBy(name = "industry")
	    private WebElement industryDropDown ;
	    
	    @FindBy(name = "accounttype")
	    private WebElement typeDropDown ;
	    
	    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	    private WebElement saveBtn ;
	    
	    
	   // initializations
	    public CreateNewOrganizationPage(WebDriver driver)
	    {
	   	 PageFactory.initElements(driver,this);
	    }


	  // utilization
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}


		public WebElement getTypeDropDown() {
			return typeDropDown;
		}


		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}


		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business Libraries
		
		/**
		 * This method will create a new Org With mandatory fields and save
		 * @param ORGNAME
		 */
		public void createNewOrg(String ORGNAME) {
			orgNameEdt.sendKeys(ORGNAME);
			saveBtn.click();
		}
	    
		/**
		 * This method will create a new Org With industry fields and save
		 * @param ORGNAME
		 * @param INDUSTRY
		 */
		public void createNewOrg(String ORGNAME,String INDUSTRY) {
			orgNameEdt.sendKeys(ORGNAME);
			handleDropDown(industryDropDown, INDUSTRY);
			saveBtn.click();
		}
		
		
		/**
		 * This method will create a new Org With industry  and type fields and save
		 * @param ORGNAME
		 * @param INDUSTRY
		 * @param TYPE
		 */
		public void createNewOrg(String ORGNAME,String INDUSTRY,String TYPE) {
			orgNameEdt.sendKeys(ORGNAME);
			handleDropDown(industryDropDown, INDUSTRY);
			handleDropDown(typeDropDown, TYPE);
			saveBtn.click();
		}

	    
		
	    
		
}
