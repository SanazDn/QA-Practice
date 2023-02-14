package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import Pages.DragDropPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class DragDrop {

	private WebDriver driver;
	private String baseUrl;
	DragDropPage dragDropPage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/drag_and_drop";

		dragDropPage = new DragDropPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.clickAndHold(dragDropPage.elemntA).moveToElement(dragDropPage.elemntB).click().release().build()
				.perform();
		Thread.sleep(2000);
		String headerA = dragDropPage.headerA.getText().trim();
		String headerB = dragDropPage.headerB.getText().trim();
		Assert.assertEquals("A", headerB);
		Assert.assertEquals("B", headerA);
	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
