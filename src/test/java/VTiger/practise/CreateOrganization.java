package VTiger.practise;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver= null;
		//Step 1: Read all the necessary data
		/* Read data from property File - Common Data */
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browers");
		String USERNAME = pObj.getProperty("Username");
		String PASSWORD = pObj.getProperty("Password");
		String URL=pObj.getProperty("Url");
		
		/* Read Data from Excel sheet - Test data */
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestDataVtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sheet = wb.getSheet("Organizations");
		Row row = sheet.getRow(1);
		String orgName=row.getCell(2).getStringCellValue();
		
		
		//Step 2: Launch the browser - driver is acting based runtime data - RunTime polymorphism
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			System.out.println(BROWSER+" --- Browser launched");
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println(BROWSER+" --- Browser launched");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" --- Browser launched");
		}else
		{
			System.out.println("invalid Browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Step 3: Load the URL
		driver.get(URL);
		
		//Step 4: Login to the Application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).submit();
		
		//Step 5: Click on Organizations Link
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
				
		//Step 6: click on Create Organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
		//Step 7: create Organization 
		Random random=new Random();
		String randomOrgName = orgName+random.nextInt(100);
		driver.findElement(By.name("accountname")).sendKeys(randomOrgName);
		
		//Step 8: Choose 'Chemicals' in industry drop down
	    WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue("Chemicals");
		
		//Step 9: Save. 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Step 10: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(randomOrgName))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step 11: Logout of Application
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout successfull");
	}
}
