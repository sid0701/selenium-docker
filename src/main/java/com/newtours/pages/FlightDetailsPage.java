package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newtours.AbstractComponent.Abstract;

public class FlightDetailsPage extends Abstract{

	private WebDriver driver;
	
	public FlightDetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="passCount")
	private WebElement passCount;
	
	@FindBy(id="findFlights")
	private WebElement continueBtn;
	
	
	public void selectPassengers(String noOfPassengers) {
		waitForElementToAppear(passCount);
		Select sel = new Select(passCount);
		sel.selectByValue(noOfPassengers);
	}
	
	public void goToFindFlightsPage() {
		continueBtn.click();
	}
	
	
}
