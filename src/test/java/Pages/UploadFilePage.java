package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFilePage extends BasePage {
	
	@FindBy(xpath = "//input[@id='file-upload']")
    public WebElement chooseFile;

    @FindBy(xpath = "//input[@id='file-submit']")
    public WebElement uploadBtn;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    public WebElement veriffyUploadedFile;

	public UploadFilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
