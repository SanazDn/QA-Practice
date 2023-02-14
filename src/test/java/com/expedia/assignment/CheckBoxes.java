package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.CheckBoxesPage;
import junit.framework.Assert;

public class CheckBoxes {

	private WebDriver driver;
	private String baseUrl;

	CheckBoxesPage checkbox;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/checkboxes";
		checkbox = new CheckBoxesPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		Assert.assertFalse(checkbox.checkBox1.isSelected());
		Assert.assertTrue(checkbox.checkBox2.isSelected());

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
