package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.JSAlertPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class JsAlert {

	private WebDriver driver;
	private String baseUrl;
	JSAlertPage javasAlert;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/javascript_alerts";
		javasAlert = new JSAlertPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {

		javasAlert.btnJsAlert.click();
		Alert jsAlert = driver.switchTo().alert();
		assertEquals("I am a JS Alert", jsAlert.getText().trim());
		jsAlert.accept();
		assertEquals("You successfuly clicked an alert", javasAlert.result.getText().trim());
		Thread.sleep(1000);

		javasAlert.btnJsConfirm.click();
		Alert jsConfirm = driver.switchTo().alert();
		assertEquals("I am a JS Confirm", jsConfirm.getText().trim());
		jsConfirm.accept();
		assertEquals("You clicked: Ok", javasAlert.result.getText().trim());
		Thread.sleep(1000);

		javasAlert.btnJsPrompt.click();
		Alert jsPrompt = driver.switchTo().alert();
		jsPrompt.sendKeys("Hi there!");
		jsPrompt.accept();

		assertTrue(javasAlert.result.getText().contains("Hi there!"));
		Thread.sleep(1000);
	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
