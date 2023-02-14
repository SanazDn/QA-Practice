package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import Pages.HoverOverPage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class HoverOver {

	private WebDriver driver;
	private String baseUrl;
	HoverOverPage hPage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/hovers";
		hPage = new HoverOverPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {

		for (int i = 0; i < hPage.figures.size(); i++) {

			// Creating object of an Actions class
			Actions actions = new Actions(driver);

			// Performing the mouse hover action on the target element.
			actions.moveToElement(hPage.figures.get(i)).build().perform();
			WebElement img = hPage.figures.get(i).findElement(By.tagName("img"));
			WebElement name = hPage.figures.get(i).findElement(By.xpath("./div/h5"));

			assertTrue(img.isDisplayed());
			assertTrue(name.isDisplayed());
			Thread.sleep(1000);
		}

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
