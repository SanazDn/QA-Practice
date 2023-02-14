package com.expedia.assignment;

import static org.junit.Assert.assertNotSame;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import Pages.UploadFilePage;
import junit.framework.Assert;

public class UploadFile {
	private WebDriver driver;
	private String baseUrl;
	UploadFilePage uFilePage;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/upload";

		uFilePage = new UploadFilePage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		String filePath = "/Users/sanazdehghan/Desktop/report-demo.html";
		uFilePage.chooseFile.sendKeys(filePath);
		uFilePage.uploadBtn.click();
        String fileName = "report-demo.html";
        String fileUploaded = uFilePage.veriffyUploadedFile.getText();
        Assert.assertEquals(fileName, fileUploaded);
			

	}

	@After
	public void afterClass() {
	}


}
