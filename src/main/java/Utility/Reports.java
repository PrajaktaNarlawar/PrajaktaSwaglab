package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports 
{
	public static ExtentReports getReports()
	{
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("Report.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Test", "Regression Test");
		report.setSystemInfo("CreatedBy:", "Prajakta");
		report.setSystemInfo("Designation", "Test Engineer");
		return report;
	}

}
