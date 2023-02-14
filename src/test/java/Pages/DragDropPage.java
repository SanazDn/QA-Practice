package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDropPage {

	WebDriver driver;

	@FindBy(id = "column-a")
	public WebElement elemntA;

	@FindBy(id = "column-b")
	public WebElement elemntB;

	@FindBy(xpath = "//div[@id='column-a']/header")
	public WebElement headerA;

	@FindBy(xpath = "//div[@id='column-b']/header")
	public WebElement headerB;

	public DragDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
