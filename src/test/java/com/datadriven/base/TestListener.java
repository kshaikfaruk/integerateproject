package com.datadriven.base;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.datadriven.utills.ExtentManager;

public class TestListener implements ITestListener {
 
	ExtentReports repos=ExtentManager.getInstance();
	 public  ExtentTest test;
	public void onTestStart(ITestResult result) {
	test=repos.createTest(result.getTestClass().getName()+"@"+result.getMethod().getMethodName());

		
	}

	public void onTestSuccess(ITestResult result) {
		 System.setProperty("org.uncommons.reportng.escape-output", "false");
			Reporter.log("<img src=/>");
			test= repos.createTest(result.getMethod().getMethodName());
			 String methodname= result.getMethod().getMethodName();
			  Markup  m= MarkupHelper.createLabel(methodname, ExtentColor.GREEN);
			test.pass(m);
			
	}

	public void onTestFailure(ITestResult result) {
		test= repos.createTest(result.getMethod().getMethodName());
		 String methodname= result.getMethod().getMethodName();
		  Markup  m= MarkupHelper.createLabel(methodname, ExtentColor.RED);
		  String expectmessage= Arrays.toString(result.getThrowable().getStackTrace());
			test.fail("<details><summary>  excetion message</summary>"+ expectmessage+"</details>");
		  test.log(Status.FAIL,m);

		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test= repos.createTest(result.getMethod().getMethodName());
		 String methodname= result.getMethod().getMethodName();
		  Markup  m= MarkupHelper.createLabel(methodname, ExtentColor.YELLOW);
		   String expectmessage= Arrays.toString(result.getThrowable().getStackTrace());
		   test.skip("<details><summary>  excetion message</summary>"+ expectmessage+"</details>");
		  test.log(Status.SKIP, m);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		  repos.flush();
	
		
	}
	 
	

}
