package com.expedia.assignment;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.LogInPage;
import Pages.OpenNewTabPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;
//import pageclasses.SearchPageFactory;

public class OpenNewTab {

	private WebDriver driver;
	private String baseUrl;
	OpenNewTabPage oNewTabPage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/windows";

		oNewTabPage = new OpenNewTabPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		oNewTabPage.cLickhere.click();
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iter = windowHandles.iterator();

		while (iter.hasNext()) {
			String handle = iter.next();
			if (!currentWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}

		WebElement newWindowTxt = driver.findElement(By.tagName("h3"));
		assertEquals("New Window", newWindowTxt.getText().trim());

	}

	@After
	public void afterClass() {
	}

}
