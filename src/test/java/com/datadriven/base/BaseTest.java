package com.datadriven.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;

public class BaseTest {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties loco = new Properties();
	public static FileInputStream fis;
	public static Logger lo = Logger.getLogger("devpinoyLogger");
	public ExtentReporter reporter;
	public static WebDriverWait wait;

	@BeforeSuite
	public void pre_setup() throws IOException {
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			lo.debug("config file not found");
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lo.debug("file is loading");
		loco.load(fis);

		if (config.getProperty("browser").equals("chrome")) {
			lo.debug("launching browser");

			System.setProperty("webdriver.chrome.driver",
					"E:\\Testingproject\\Integerationproject\\src\\test\\resources\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver.get("https://www.google.com");
		} else if (config.getProperty("browser").equals("firefox")) {

		} else if (config.getProperty("browser").equals("ie")) {

		}
		// driver.get("https://www.google.com");
		// driver.manage().window().maximize();
		lo.debug("navgiating to url");
		driver.get(config.getProperty("websit"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait= new WebDriverWait(driver, 100);

	}

	@AfterSuite
	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}
}