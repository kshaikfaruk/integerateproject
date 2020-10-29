package com.datadriven.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.datadriven.base.BaseTest;

public class LoginTest extends BaseTest {
	@Test
	public void login() throws InterruptedException {
		lo.debug("login ");
		WebElement elebtn = driver.findElement(By.xpath(loco.getProperty("managerlogin")));
		elebtn.click();
		  throw new SkipException(" login");
	}

}
