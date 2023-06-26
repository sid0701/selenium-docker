package com.both.testcomponents;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws MalformedURLException, InterruptedException {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("--disable-popup-blocking");
//		driver = new ChromeDriver(options);
//		
//	}


		String host = System.getProperty("HUB_HOST") != null ? System.getProperty("HUB_HOST") : "localhost";
//		Capabilities dc;
		DesiredCapabilities dc = new DesiredCapabilities();


		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
//			dc = new FirefoxOptions();
			dc.setBrowserName("firefox");
		} else {
//			List<String> options = new ArrayList<>();
//			options.add("--disable-extensions");
//			options.add("--headless");
//			options.add("--disable-gpu");
//			options.add("--no-sandbox");
//			options.add("--incognito");
//			options.add("--disable-application-cache");
//			options.add("--disable-dev-shm-usage");
//			options.add("--remote-allow-origins=*");
//			dc = new ChromeOptions().addArguments(options);
			dc.setBrowserName("chrome");
		}

		String url = "http://" + host + ":4444/";
		driver = new RemoteWebDriver(new URL(url), dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();;
	}
}
