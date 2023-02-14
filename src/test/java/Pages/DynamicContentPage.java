package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
	WebDriver driver;

	@FindBy(xpath = "//a[text()='click here']")
	public WebElement clickhere;

	@FindBy(xpath = "//div[@id='content']/div[@class='row'][3]/div[2]")
	public WebElement thirdContext;

	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
