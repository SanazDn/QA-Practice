package com.expedia.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.FloatingMenuPag;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloatingMenue {
	private WebDriver driver;
	private String baseUrl;
	FloatingMenuPag fMenu;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/floating_menu#about";

		fMenu = new FloatingMenuPag(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
       
        List<WebElement> els = fMenu.menus;
        String[] expectedMenuOptions = {"Home", "News", "Contact", "About"};

        for(int i = 0; i < els.size(); i++) {
        	assertEquals(expectedMenuOptions[i]	, els.get(i).getText().trim());
        }

	}

	@After
	public void afterClass() {
		driver.quit();
	}


}
