package com.expedia.assignment;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.LogInPage;
import junit.framework.Assert;

public class LoginFailure {

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
		logInPage.LogIn("tomsmith", "Password!");

		String expErrorMessage = "Your password is invalid!";
		String actualErrorMessage = logInPage.errorMessage.getText().replace("×", "").trim();
		System.out.println("Actual error message: " + actualErrorMessage);
        Assert.assertEquals(expErrorMessage, actualErrorMessage);

	}

	@After
	public void afterClass() {
	}
}
