package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.DynamicControlsPage;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import junit.framework.Assert;

public class DynamicControls {

	private WebDriver driver;
	private String baseUrl;
	DynamicControlsPage dynamicControl;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/dynamic_controls";
		dynamicControl = new DynamicControlsPage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {

		dynamicControl.removeAddBtn.click();

		String checkBeforeClick = dynamicControl.checkboxElement.getText();
		System.out.println(checkBeforeClick);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dynamicControl.removeAddBtn));

		String msgAfterClick = dynamicControl.actualMessage.getText();
		System.out.println(msgAfterClick);

		String expTextString = "It's gone!";

		Assert.assertEquals(msgAfterClick, expTextString);

		dynamicControl.enableBTN.click();

		wait.until(ExpectedConditions.elementToBeClickable(dynamicControl.enableBTN));

		String msgEnableString = dynamicControl.enableDisableMsg.getText();
		String expMsgString = "It's enabled!";

		Assert.assertEquals(msgEnableString, expMsgString);

		dynamicControl.enableBTN.click();
		wait.until(ExpectedConditions.elementToBeClickable(dynamicControl.enableBTN));
		String msgDisableString = dynamicControl.enableDisableMsg.getText();
		String expMsgDisable = "It's disabled!";

		Assert.assertEquals(msgDisableString, expMsgDisable);

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
