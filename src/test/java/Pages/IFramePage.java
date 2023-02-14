package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage extends BasePage{
	

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement editor;

    @FindBy(xpath = "//div[@class='tox-icon']//..")
    public WebElement crossBtn;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    public WebElement realmsg;

	public IFramePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
