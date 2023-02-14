package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPag extends BasePage {

	@FindBy(xpath = "//div[@id ='menu']/ul/li")
	public List<WebElement> menus;

	public FloatingMenuPag(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
