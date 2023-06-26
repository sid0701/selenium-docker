package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.AbstractComponent.Abstract;

public class RegistrationPage extends Abstract {

	private WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstName")
	private WebElement firstName;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(css="input[name='password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmPwd;
	
	@FindBy(xpath="//input[@name='register']")
	private WebElement submitBtn;
	
	public void goTo() {
		driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
		waitForElementToAppear(firstName);
	}
	
	public void enterUserDetails(String fName, String lName) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
	}
	
	public void enterUserCredentials(String uName, String password) {
		userName.sendKeys(uName);
		pwd.sendKeys(password);
		confirmPwd.sendKeys(password);
	}
	
	public void submit() {
		submitBtn.click();
	}
	
}
