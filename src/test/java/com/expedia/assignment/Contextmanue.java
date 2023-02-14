package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import Pages.ContextMenuPage;
import junit.framework.Assert;

public class Contextmanue {

	private WebDriver driver;
	private String baseUrl;
	ContextMenuPage contextMenuPage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/javascript_error";
		contextMenuPage = new ContextMenuPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		Actions actions = new Actions(driver);
		actions.contextClick(contextMenuPage.contextmenu).perform();
		Thread.sleep(3000);

		String actualAlertText = driver.switchTo().alert().getText();
		String expTextString = "You selected a context menu";
		System.out.println(actualAlertText);
		Assert.assertEquals(actualAlertText, expTextString);
		driver.switchTo().alert().accept();
	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
