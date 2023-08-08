package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	// Declaration
    @FindBy(xpath = "//img[@title='Create Organization...']")
    private WebElement createOrgLookUpImg;
    
	
   // Initialization
    public OrganizationsPage(WebDriver driver)
    {
   	 PageFactory.initElements(driver,this);
    }


    // Utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
    

	//Business Library
	
	/**
	 * This method will click on create organization look up Image
	 */
	public void clickOnCreateOrgLookUpImg() {
		createOrgLookUpImg.click();
	}
  
	
    
  
    
    
}
