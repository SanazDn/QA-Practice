package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPage {
	WebDriver driver;
	
	@FindBy(xpath = "//select[@id='dropdown']")
    public WebElement dropArrow;

    @FindBy(xpath = "//select[@id='dropdown']/option[text() = 'Option 2']")
    public WebElement option2;

    @FindBy(xpath = "//select[@id='dropdown']/option[text() = 'Option 1']")
    public WebElement option1;
	
	
	
	public DropDownPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
