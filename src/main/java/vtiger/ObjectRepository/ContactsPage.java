package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	
	    // declaration
		@FindBy(xpath = "//img[@title='Create Contact...']")
		private WebElement CreateContactLookUpImg;

		// initialization
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Utilization
		public WebElement getCreateContactLookUpImg() {
			return CreateContactLookUpImg;
		}
		
		//business library
		/**
		 * this method will click on the look up image
		 */
		public void clickOnCreateContactLookUpImg()
		{
			CreateContactLookUpImg.click();
		}
}
