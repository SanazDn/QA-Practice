package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import Pages.DynamicContentPage;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class DrynamicContent {
	private WebDriver driver;
	private String baseUrl;
	DynamicContentPage dynamiccontent;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/dynamic_content?with_content=static";
		dynamiccontent = new DynamicContentPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		String textBeforClickString = dynamiccontent.thirdContext.getText();
		System.out.println(textBeforClickString);

		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(dynamiccontent.clickhere).click().perform();

		Thread.sleep(3000);

		String textAfterClickString = dynamiccontent.thirdContext.getText();
		System.out.println(textAfterClickString);

		assertNotSame(textBeforClickString, textAfterClickString);

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
