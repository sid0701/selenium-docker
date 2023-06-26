package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.AbstractComponent.Abstract;

public class RegistrationConfirmationPage extends Abstract {

	private WebDriver driver;

	public RegistrationConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//h1[text()='Registration Confirmation Page']")
	WebElement confirmationMsg;
	
	@FindBy(xpath="//a[text()='Flights']")
	WebElement flightsLink;
	
	public void goToFlightsPage() {
		waitForElementToAppear(confirmationMsg);
		flightsLink.click();
	}

}
