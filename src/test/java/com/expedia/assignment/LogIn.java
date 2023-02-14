package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.LogInPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import junit.framework.Assert;


public class LogIn {
	private WebDriver driver;
	private String baseUrl;
	LogInPage logInPage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/login";
		logInPage = new LogInPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		logInPage.LogIn("tomsmith", "SuperSecretPassword!");

		String expectedMsg = "You logged into a secure area!";
		String reallMsg = logInPage.actualSuccessMessage.getText().replace("×","").trim();
		System.out.println(expectedMsg);
		System.out.println(reallMsg);
		Assert.assertEquals(expectedMsg, reallMsg);
	}

	@After
	public void afterClass() {
		driver.quit();
	}
}
