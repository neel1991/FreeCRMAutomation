package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logo;
	
	@FindBy(name="username")
	WebElement userName;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateLogo() {
		if(logo.isDisplayed()) {
			logo.click();	
		}
	}
	
	public void enterDataIntoUsername() {
		userName.sendKeys("pneel141");
	}
	
	public String validateTitle() {
		return driver.getCurrentUrl();
	}
}
