package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPageLoad extends BasePage {

	@FindBy(xpath = "//div[@id='start']/button")
	public WebElement startBtn;

	@FindBy(xpath = "//div[@id='finish']/h4")
	public WebElement actualMsg;

	public DynamicPageLoad(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
