package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxesPage {
	WebDriver driver;
	
	@FindBy(xpath = "//form[@id='checkboxes']//input[1]")
    public WebElement checkBox1;

    @FindBy(xpath = "//form[@id='checkboxes']//input[2]")
    public WebElement checkBox2;
    
    public CheckBoxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
