package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSAlertPage extends BasePage {

	@FindBy(xpath = "//li/button[text()='Click for JS Alert']")
	public WebElement btnJsAlert;

	@FindBy(xpath = "//li/button[text()='Click for JS Confirm']")
	public WebElement btnJsConfirm;

	@FindBy(xpath = "//li/button[text()='Click for JS Prompt']")
	public WebElement btnJsPrompt;

	@FindBy(id = "result")
	public WebElement result;

	public JSAlertPage(WebDriver driver) {
		super(driver);
	}

}
