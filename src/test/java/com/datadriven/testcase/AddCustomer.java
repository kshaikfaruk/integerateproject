package com.datadriven.testcase;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datadriven.base.BaseTest;
import com.google.common.io.Files;

public class AddCustomer extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void custom(String fname, String lname, String postcd, String msg) throws IOException, InterruptedException {

		driver.findElement(By.xpath(loco.getProperty("addcustomer"))).click();
		lo.debug("sending data");
		driver.findElement(By.xpath(loco.getProperty("fname"))).sendKeys(fname);
		driver.findElement(By.xpath(loco.getProperty("lname"))).sendKeys(lname);
		driver.findElement(By.xpath(loco.getProperty("pcode"))).sendKeys(postcd);
		 Date d= new Date();
		 String s=d.getDate()+" "+d.getHours()+" "+d.getMinutes()+d.getSeconds();
		 String s1=s.replace(":", "_").replace(" ","_");
		 TakesScreenshot file=(TakesScreenshot)driver;
		  File img=file.getScreenshotAs(OutputType.FILE);
		  Files.move(img,  new File("E:\\Testingproject\\datadriven\\src\\test\\resources\\screenshot\\"+ s1+".jpg"));
		
		driver.findElement(By.xpath(loco.getProperty("addbtn"))).click();
		 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
         alert.accept();
//		 Reporter.log("screenshot");
//		 Reporter.log("<a href=> link</a>");
//		 System.setProperty("org.uncommons.reportng.escape-output", "false");

        // Thread.sleep(10000);
      	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][4];
		data[0][0] = "shaik";
		data[0][1] = "shaik";
		data[0][2] = "515003";
		data[0][3] = "Customer added successfully ";
		return data;
	}
}


