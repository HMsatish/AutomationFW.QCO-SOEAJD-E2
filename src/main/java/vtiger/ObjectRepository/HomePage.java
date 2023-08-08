package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	 // declaration
     @FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index'][normalize-space()='Organizations']")
     private WebElement organizationsLnk;
     
     @FindBy(xpath = "//a[.='Contacts']")
     private WebElement contactsLnk;
     
     @FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
     private WebElement opportunitiesLnk ;
     
     @FindBy(xpath = "//a[normalize-space()='Products']")
     private WebElement productsLnk ;
     
     @FindBy(xpath = "//a[@href='javascript:;'][normalize-space()='More']")
     private WebElement moreLnk ;
     
     @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
     private WebElement administratorImg ;
     
     @FindBy(xpath = "//a[text()='Sign Out']")
     private WebElement signOutLnk ;
     
     
    // initialization
     public HomePage(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
     }


     // Utilization
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}


	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}


	public WebElement getProductsLnk() {
		return productsLnk;
	}


	public WebElement getMoreLnk() {
		return moreLnk;
	}


	public WebElement getAdministratorImg() {
		return administratorImg;
	}


	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	//Business Library
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrgLink() {
		organizationsLnk.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactLink() {
		contactsLnk.click();
	}
	
	/**
	 * This method will click on Products link
	 */
	public void clickOnProductsLink() {
		productsLnk.click();
	}
   
	/**
	 * This method will click on Opportunities link
	 */
    public void clickOnOpportunitiesLink() {
    	opportunitiesLnk.click();
	}
    
    /**
     * This method will click on More link
     */
    public void clickOnMoreLink() {
    	moreLnk.click();
	}
     
    /**
     * This method will perform signout operation
     * @param driver
     */
    public void logOutOfApp(WebDriver driver) {
    	mouseHoverAction(driver, administratorImg);
    	signOutLnk.click();
	}
   
}
