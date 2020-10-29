package com.datadriven.utills;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	 public static ExtentHtmlReporter reports;
	 public static ExtentReports repo;
	
	 public static ExtentReports getInstance(){
		 Date d= new Date();
		 String s=d.getDate()+" "+d.getHours()+" "+d.getMinutes()+d.getSeconds();
		 String s1=s.replace(":", "_").replace(" ","_");
  reports= new ExtentHtmlReporter("E:\\Testingproject\\datadriven\\test-output\\Extentreport.html");
  reports.config().setReportName("datadriven");
  reports.config().setDocumentTitle("datadriven test");
   reports.config().setEncoding("utf-8");
   reports.config().setTheme(Theme.DARK);
   
  
  repo= new ExtentReports();
  repo.attachReporter(reports);
   
  return repo;

		
	}

}
