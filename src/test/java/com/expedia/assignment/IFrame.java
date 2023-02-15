package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import Pages.IFramePage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import junit.framework.Assert;

public class IFrame {

	private WebDriver driver;
	private String baseUrl;
	IFramePage iframe;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/iframe";
		iframe = new IFramePage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		driver.switchTo().frame("mce_0_ifr");

		Actions action = new Actions(driver);
		action.moveToElement(iframe.realmsg).click().perform();
		
		//clear the text
		iframe.realmsg.clear();
		
		//send message 
		action.sendKeys(Keys.CONTROL, "Hi!").build().perform();

		String realtext = iframe.realmsg.getText();
		System.out.println(realtext);
		String expText = "Hi!";

		Thread.sleep(3000);

		Assert.assertEquals(realtext, expText);

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
