package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.both.testcomponents.BaseTest;
import com.newtours.pages.FindFlightsPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;

public class BookFlightTest extends BaseTest {

	private String noOfPassengers;
	private String expectedPrice;

	@BeforeTest
	@Parameters({ "noOfPassengers", "expectedPrice" })
	public void setupParameters(String noOfPassengers, String expectedPrice) {
		this.noOfPassengers = noOfPassengers;
		this.expectedPrice = expectedPrice;
	}

	@Test
	public void registrationPageTest() {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.goTo();
		rp.enterUserDetails("Selenium", "docker");
		rp.enterUserCredentials("Selenium", "docker");
		rp.submit();
	}

	@Test(dependsOnMethods = "registrationPageTest")
	public void registrationConfirmationPageTest() {
		RegistrationConfirmationPage rcp = new RegistrationConfirmationPage(driver);
		rcp.goToFlightsPage();
	}

	@Test(dependsOnMethods = "registrationConfirmationPageTest")
	public void flightDetailsPageTest() {
		FlightDetailsPage fdp = new FlightDetailsPage(driver);
		fdp.selectPassengers(noOfPassengers);
		fdp.goToFindFlightsPage();
	}

	@Test(dependsOnMethods = "flightDetailsPageTest")
	public void findFlightsPageTest() {
		FindFlightsPage ffp = new FindFlightsPage(driver);
		ffp.submitFindFlightPage();
		ffp.goToOrderConfirmationPage();
	}

	@Test(dependsOnMethods = "findFlightsPageTest")
	public void flightConfirmationPageTest() {
		FlightConfirmationPage fcp = new FlightConfirmationPage(driver);
		String actualprice = fcp.getPrice();
		Assert.assertEquals(actualprice, expectedPrice);
	}

}
