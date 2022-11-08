package Test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POJO.Browser;
import POM.LoginPage;
import POM.ProductsPage;
import Utility.BaseClass;
import Utility.Reports;



@Listeners(Utility.Listeners.class)
public class AddToCartTest extends BaseClass
{
	
	ExtentReports report;
	ExtentTest test;
	
@BeforeTest()
public void configureReports()
{
	report=Reports.getReports();
}

@BeforeMethod()
public void LaunchBrowser()
{
driver=Browser.openChrome();

}

@Test
public void verifyAddToCartButton()
{
	test= report.createTest("verifyAddToCartButton");
	LoginPage LoginPage =new LoginPage(driver);
	LoginPage.enterUserName("standard_user");
	LoginPage.enterPassword("secret_sauce");
	LoginPage.clickOnLogin();
	ProductsPage productPage=new ProductsPage(driver);
	productPage.clickOnAddToCart(2);
	Assert.assertTrue(productPage.isRemoveButtonDisplay(1));
	
}

@Test
public void verifyAddingMultipleProductsToCart()
{
	test= report.createTest("verifyAddingMultipleProductsToCart");
	LoginPage LoginPage =new LoginPage(driver);
	LoginPage.enterUserName("standard_user");
	LoginPage.enterPassword("secret_sauce");
	LoginPage.clickOnLogin();
	ProductsPage productPage=new ProductsPage(driver);
	int addToCart=productPage.getNumberOfAddToCartButton();
	productPage.addMultipleProductToCart();
	Assert.assertEquals(productPage.getNumberOfRemoveButton(),addToCart );
}


@AfterMethod
public void getTestResult(ITestResult result)
{
	if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS,result.getName());
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
public void publishReport()
{
	report.flush();
}
}
