package Test;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POJO.Browser;
import POM.LoginPage;
import Utility.BaseClass;
import Utility.Parameterization;
import Utility.Reports;

@Listeners(Utility.Listeners.class)
public class LoginPageTest extends BaseClass
{

	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports()
	{
		report=Reports.getReports();
	}
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver=Browser.openChrome();
	}
	
	@DataProvider(name="LoginData")
	public Object[][] data() throws EncryptedDocumentException, IOException
	{
		String password=Parameterization.getData("Sheet1", 1, 1);
		return new Object[][] {{Parameterization.getData("Sheet1", 1, 0),password},{Parameterization.getData("Sheet1", 2, 0),password}};
	}
	
	@Test(dataProvider="LoginData")
	
	public void LoginPageTestWithValidCreds(String name,String pass)
	{
		test= report.createTest("LoginPageTestWithValid");
		LoginPage LoginPage =new LoginPage(driver);
		LoginPage.enterUserName(name);
		LoginPage.enterPassword(pass);
		LoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		
		
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	
	public void publishResult()
	{
		report.flush();
	}
	
}
