package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewTabPage extends BasePage {
	
	@FindBy(xpath = "//a[text() = 'Click Here']")
    public WebElement cLickhere;

	public OpenNewTabPage(WebDriver driver) {
		super(driver);
	}

}
