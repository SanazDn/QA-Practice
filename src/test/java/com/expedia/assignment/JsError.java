package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import Pages.JsErrorPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class JsError {

	private WebDriver driver;
	private String baseUrl;
	JsErrorPage jsError;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/login";
		jsError = new JsErrorPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {

		String expectedErrStr = "Cannot read property 'xyz' of undefined";
		Logs logs = driver.manage().logs();
		LogEntries logEntries = logs.get(LogType.BROWSER);

		for (LogEntry entry : logEntries) {

			String errorLog = entry.getMessage().toString();

			if (errorLog.contains(expectedErrStr)) {
				assertTrue(true);
				return;
			}
		}
		assertTrue(false, "Page does not contain any error from console");
	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
