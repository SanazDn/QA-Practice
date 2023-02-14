package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HoverOverPage extends BasePage {


	@FindBy(xpath = "./div/h5")
	public WebElement user;

	@FindBy(tagName = "img")
	public WebElement img;

	@FindBy(xpath = "//div[@class='figure']")
	public List<WebElement> figures;

	public HoverOverPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
