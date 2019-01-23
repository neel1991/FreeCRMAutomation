package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;

	/*
	 * public static void main(String args[]) { TestBase base = new TestBase();
	 * base.initialization(); }
	 */

	public TestBase() {
		properties = new Properties();
		try {
			FileInputStream stream = new FileInputStream(
					"C:\\Users\\ciphe\\neon-workspace-selenium\\FreeCRM\\src\\main\\java\\com\\qa\\config\\config.properties");
			properties.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = properties.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		
	}

}
