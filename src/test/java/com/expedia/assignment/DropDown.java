package com.expedia.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Pages.DropDownPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class DropDown {
	private WebDriver driver;
	private String baseUrl;
	DropDownPage dropdown;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/dropdown";
		dropdown = new DropDownPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		Select sel = new Select(dropdown.dropArrow);
		String[] expected = { "Please select an option", "Option 1", "Option 2" };
		List<WebElement> options = sel.getOptions();
		// assert values
		for (int i = 0; i < options.size(); i++) {
			String actualVal = options.get(i).getText();
			String expectedVal = expected[i];
			Assert.assertEquals(expectedVal, actualVal);
		}

		// select Option 2
		sel.selectByIndex(2);
		Assert.assertTrue(dropdown.option2.isSelected());

		// select Option 1
		sel.selectByIndex(1);
		Assert.assertTrue(dropdown.option1.isSelected());

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
