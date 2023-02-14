package com.expedia.assignment;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import junit.framework.Assert;
import Pages.DownloadFilePage;

public class DownloadFile {
	private WebDriver driver;
	private String baseUrl;
	DownloadFilePage downloadFile;

	@Before
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:7080/download";
		downloadFile = new DownloadFilePage(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws Exception {
		String expectedFile = "some-file.txt";
		downloadFile.file.click();
		Thread.sleep(2000);
		String path = "src/test/java/utilities/TestData";

		File directoryPath = new File(path);
		String contents[] = directoryPath.list();
		for (int i = 0; i < contents.length; i++) {
			Assert.assertEquals(expectedFile, contents[i]);
		}
		File downloadFile = new File(path + "/" + expectedFile);
		if (downloadFile.exists()) {
			downloadFile.delete();
		}

	}

	@After
	public void afterClass() {
		driver.quit();
	}

}
