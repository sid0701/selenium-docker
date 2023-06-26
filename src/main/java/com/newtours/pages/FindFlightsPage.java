package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.AbstractComponent.Abstract;

public class FindFlightsPage extends Abstract {
	
	private WebDriver driver;
	
	public FindFlightsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="reserveFlights")
	WebElement firstSubmitBtn;
	
	@FindBy(id="buyFlights")
	WebElement secondSubmitBtn;
	
	public void submitFindFlightPage() {
		waitForElementToAppear(firstSubmitBtn);
		firstSubmitBtn.click();
	}
	
	public void goToOrderConfirmationPage() {
		waitForElementToAppear(secondSubmitBtn);
		secondSubmitBtn.click();
	}
	
}
