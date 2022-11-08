package Utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener
{

	public void onTestStart(ITestResult result)
	{
		
	}
	
	public void onTestSucess(ITestResult result)
	{
		
	}
	
	public void onTestFailure(ITestResult result) 
	{
		try {
			ScreenShot.screen(driver, result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
}
