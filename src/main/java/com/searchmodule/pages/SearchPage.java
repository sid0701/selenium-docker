package com.searchmodule.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement searchBox;

	@FindBy(css = "a[data-zci-link='videos']")
	WebElement videosLink;

	@FindBy(css = ".tile--vid")
	List<WebElement> videos;

	public void goTo() {
		driver.get("https://duckduckgo.com");

	}

	public void doSearch(String keyword) {
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(keyword);
	}

	public void doClick() {

		searchBox.submit();

	}

	public void goToVideos() {
		wait.until(ExpectedConditions.visibilityOf(videosLink));
		videosLink.click();
	}

	public int noOfVideos() {
		By by = By.className("tile--vid");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
		System.out.println(videos.size());
		return videos.size();
	}

}
