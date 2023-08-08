package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of all the generic methods related to WebDriver
 * @author Satish
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver ) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver ) {
		driver.manage().window().minimize();
	}

	//wait utility
	/**
	 * This method will wait for all the findElement and findElements
	 * @param driver
	 */
	public void waitForElementsToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for the web page to get loaded 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	
	/**
	 * This method will wait until the specified element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until the specified element is clickable in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//DropDown utility
	/**
	 * This method will handle dropdown with the help of value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value ) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown with the help of index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index ) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 *  This method will handle dropdown with the help of Visible Text
	 * @param element
	 * @param VisibleText
	 */
	public void handleDropDown(String text,WebElement element) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	/**
	 * This method will help to select option from List<WebElement>
	 * @param dropDownOptions
	 * @param Text
	 */
	public void selectOptionFromListOfWebElement(List<WebElement> AllOtionsList,String Text) {
		for (WebElement option : AllOtionsList) {
			if (option.getText().contains(Text)) {
				option.click();
			}
	   }
	}
	
	//action class utility
	/**
	 * This method will perform mouse hover action on a web element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform Double click anywhere on the web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions action=new Actions(driver);
		action.doubleClick().perform();
	}
	
	/**
	 * This method will perform Double click on the Web Element 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement targetElement) {
		Actions action=new Actions(driver);
		action.dragAndDrop(srcElement, targetElement).perform();
	}
	
	/**
	 * A convenience method that performs click-and-hold at the location of the source element,moves by a given offset, then releases the mouse
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcElement,int xOffset ,int yOffset) {
		Actions action=new Actions(driver);
		action.dragAndDropBy(srcElement, xOffset,yOffset).perform();
	}
	
	/**
	 * This method will perform right click action anywhere on the web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on the Web Element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * This method will press and release the enter key
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to move the cursor anywhere on the web page bassed on offset value
	 * @param driver
	 * @param xOffSet
	 * @param yOffSet
	 */
	public void moveAcrossWebPage(WebDriver driver,int xOffSet,int yOffSet) {
		Actions action=new Actions(driver);
		action.moveByOffset(xOffSet,yOffSet).perform();
	}
	
	/**
	 * This method will perform click action on web element
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	
	//Alert utility
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop up
	 * @param driver
	 */
	public void dismisAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter the text in prompt pop up
	 * @param driver
	 * @param text
	 */
	public void sendTextToAlert(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will get the alert text
	 * @param driver
	 * @return
	 */
	public String getAlerttext(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	
	//Frame utility
	/**
	 * This method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on name or ID attributes
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch the control to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		 driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		 driver.switchTo().defaultContent();
	}
	
	//Window utility
	/**
	 * This method will switch the selenium controle from parent to child or 
	 * child to parent window bassed on the partial window title
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId : allWindowIds) {
		String currentTitle = driver.switchTo().window(windowId).getTitle();
			if(currentTitle.contains(partialTitle)){
				break;
			}
		}
	}
	
	/**
	 * This method will switch the selenium controle from parent to child or 
	 * child to parent window bassed on the partialUrl of webpage
	 * @param partialUrl
	 * @param driver
	 */
	public void switchToWindow(String partialUrl,WebDriver driver) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId : allWindowIds) {
		String currentTitle = driver.switchTo().window(windowId).getCurrentUrl();
			if(currentTitle.contains(partialUrl)){
				break;
			}
		}
	}
	
	
	//TakesScreenShot utility
	/**
	 * This method will take screenshot and return the path of destination
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src, dst);//this class is from commons IO tool
		
		return dst.getAbsolutePath();//attach the screen shot to extent report
	}
	
	/**
	 * This method will take screen shot of Web Element and return the absolute path of it
	 * @param element
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String screenShotOfWebElement(WebElement element,String screenShotName) throws Throwable {
		File src = element.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();
	}
	
	//JavascriptExecuter utility
	/**
	 * This method will perform scrolling of web page upto 500 pixel verticaly
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.srollBy(0,500)","" );
	}
	
	/**
	 * This method will perform scrolling of web page upto visibility of element
	 * @param driver
	 * @param element
	 */
	public void scrollByVisibilityOfElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element );
	}
	
	/**
	 * This method will drow a border around the element by Javascript Executer
	 * @param driver
	 * @param element
	 */
	public void drowBorder(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element );
	}
	
	/**
	 * This method will return the title of the page by Javascript Executer
	 * @param driver
	 * @return
	 */
	public String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();
	}
	
	/**
	 * This method will perform click action on the element by Javascript Executer
	 * @param driver
	 * @param element
	 */
	public void clickOnElementByJS(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element );
	}
	
	/**
	 * This method will generate the Alert pop up by Javascript Executer
	 * @param driver
	 * @param message
	 */
	public void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}
	
	/**
	 * This method will Refresh the web page by Javascript Executer
	 * @param driver
	 */
	public void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
}
