package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	// declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	
	// initialization
	public ContactInfoPage(WebDriver driver) //test script
	{
		PageFactory.initElements(driver, this);
	}

	
	// Utilization
	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	

	//Business Library
	/**
	 * This method will get the contact header
	 * @return
	 */
	public String getContactText() {
		return ContactHeaderText.getText();
	}
}
