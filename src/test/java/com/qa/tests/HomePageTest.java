package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void validateFreeCRMLogo() {
		homepage.validateLogo();
	}
	
	@Test
	public void enterDataToUserName() {
		homepage.enterDataIntoUsername();
	}
	
	@Test
	public void validateTitle() {
		System.out.println(homepage.validateTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
