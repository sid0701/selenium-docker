package com.newtours.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract {
	
	private WebDriver driver;
	
	public Abstract(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	

}
