package vtiger.GenericUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println(" =====Database connection Done =====");
	}
	
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig() throws Throwable 
	{
		//1)Launch Browser.
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" --- Browser launch successful ---");
		} 
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+" --- Browser launch successful ---");
		} 
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" --- Browser launch successful ---");
		}
		else
		{
			System.out.println("Ivalid Browser Name");
		}
		
		sDriver=driver; // take screen shot
		wUtil.maximizeWindow(driver);
		wUtil.waitForElementsToLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws Throwable
	{
		//2)Login to application with valid credentials
			String USERNAME = pUtil.getDataFromPropertyFile("username");
			String PASSWORD = pUtil.getDataFromPropertyFile("password");
			
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println(" --- Login is Successful ---");
	}
		
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void amConfig() throws InterruptedException 
	{
		//7)logout of Application
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.logOutOfApp(driver);
		System.out.println(" --- Logout is Successful ---");
	}
	
    @AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void acConfig() 
	{
		wUtil.minimizeWindow(driver);
		driver.quit();
		System.out.println(" --- browser closed Successfully ---");
	}
    
    @AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println(" =====Database connection Closed =====");
	}
}
