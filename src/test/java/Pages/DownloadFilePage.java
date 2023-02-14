package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadFilePage extends BasePage {
	
    @FindBy(xpath = "//a[text() = 'some-file.txt']")
    public WebElement file;


    public DownloadFilePage(WebDriver driver) {
        super(driver);
    }

}
