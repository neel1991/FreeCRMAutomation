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
	
//	@Test
//	public void validateFreeCRMLogo() {
//		homepage.validateLogo();
//	}
	
	
	@Test
	public void validateTitle() {
		System.out.println(homepage.validateTitle());
	}
	
	@Test
	public void clickOnSlideShowRightSide() {
		homepage.clickOnSlideShowRightButton();
	}
	
	@Test
	public void clickOnCRMContactsSignUpButton() {
		homepage.clickOnCRMContactsSignUpButton();
	}
	
	@Test
	public void moveToSection() {
		homepage.moveToSectionUsingJS();
	}
	
	@Test
	public void doLogin() {
		homepage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
