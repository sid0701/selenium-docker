package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.AbstractComponent.Abstract;

public class FlightConfirmationPage extends Abstract{

	private WebDriver driver;
	
	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//font[contains(text(),'Flight Itinerary')]")
	private WebElement header;
	
	@FindBy(xpath="//td[text()='Total Price']/../td/font")
	private WebElement price;
	
	@FindBy(linkText="SIGN-OFF")
	private WebElement signoffLink;
	
	public String getPrice() {
		waitForElementToAppear(header);
		System.out.println(price.getText());
		return price.getText();
	}
}
