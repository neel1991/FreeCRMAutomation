package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logo;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='right carousel-control skrollable skrollable-between']")
	WebElement slideshowRightButton;
	
	@FindBy(xpath="//h3[text()='CRM Contacts']/following-sibling::a")
	WebElement clickOnCRMContactsSignUpButton;
	
	@FindBy(xpath="//section[@id='customers']")
	WebElement moveToSection;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateLogo() {
		if(logo.isDisplayed()) {
			logo.click();	
		}
	}
	
	public DashboardPage doLogin(String username, String pass) {
		
		userName.sendKeys(username);
		password.sendKeys(pass);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		boolean isVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(isVisible) {
			loginBtn.click();
		}
		return new DashboardPage();
		
	}
	
	public String validateTitle() {
		return driver.getCurrentUrl();
	}
	
	public void clickOnSlideShowRightButton() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		boolean isVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(isVisible) {
			slideshowRightButton.click();
		}
	}
	
	public void clickOnCRMContactsSignUpButton() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		boolean isVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if(isVisible) {
			clickOnCRMContactsSignUpButton.click();
		}
	}
	
	public void moveToSectionUsingJS() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", moveToSection);
	}
}
