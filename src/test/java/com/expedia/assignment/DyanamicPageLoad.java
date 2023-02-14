package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.DynamicPageLoad;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class DyanamicPageLoad {
	private WebDriver driver;
	private String baseUrl;
	DynamicPageLoad dynamicPage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/dynamic_loading/2";

		dynamicPage = new DynamicPageLoad(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		dynamicPage.startBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dynamicPage.actualMsg));

		String actualTextString = dynamicPage.actualMsg.getText();
		String expTextString = "Hello World!";

		Assert.assertEquals(actualTextString, expTextString);
	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
