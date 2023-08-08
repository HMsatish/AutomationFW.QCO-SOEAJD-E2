package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	// declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(id = "search_txt")
	private WebElement orgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	

	// initiliazation
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}


	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}


	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	
	//Business Library
	/**
	 * This method will create new contact with mandatory fields and save
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create new contact with Organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 * @throws InterruptedException 
	 */
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
}
