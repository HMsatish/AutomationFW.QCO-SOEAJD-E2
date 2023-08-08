package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenersImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String mathodeName=result.getMethod().getMethodName();
		System.out.println("----Execution Start----"+mathodeName);
		test=report.createTest(mathodeName);
	}

	public void onTestSuccess(ITestResult result) {
		String mathodeName=result.getMethod().getMethodName();
		//System.out.println("----PASS----"+mathodeName);
		test.log(Status.PASS, mathodeName);
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		String mathodeName=result.getMethod().getMethodName();
		
		//System.out.println("----FAIL----"+mathodeName);
		test.log(Status.FAIL, mathodeName);
		
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
		
		/*Take screen shot for failed test scripts - to attach with bug rising*/
		String screenShotName = mathodeName+jUtil.getSystemDateinFormat();
		try {
			String path = wUtil.takesScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String mathodeName=result.getMethod().getMethodName();
		//System.out.println("----SKIP----"+mathodeName);
		test.log(Status.SKIP, mathodeName);
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("----Suite Execution Started----");
		
		//configure the extent Report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateinFormat()+".html");
		htmlReport.config().setDocumentTitle("VTiger Execution Report");
		htmlReport.config().setReportName("Build 3 VTiger report");
		htmlReport.config().setTheme(Theme.DARK);
		
		//Report Generation
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Testing-env");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter", "Satish");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("----suite Execution Ended----");
		
		//Report Generation
		report.flush();
	}

	
}
