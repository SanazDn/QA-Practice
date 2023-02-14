package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage {
	
	@FindBy(xpath = "//form[@id='checkbox-example']/button")
    public WebElement removeAddBtn;
	
	@FindBy(id="checkbox")
	public WebElement checkboxElement;

    @FindBy(xpath = "//form[@id='checkbox-example']/p[@id='message']")
    public WebElement actualMessage;

    @FindBy(xpath = "//form[@id='input-example']/button")
    public WebElement enableBTN;

    @FindBy(xpath = "//form[@id='input-example']/p")
    public WebElement actualBtnMsg;

    @FindBy(xpath = "//form[@id='input-example']/p[@id='message']")
    public WebElement enableDisableMsg;
    

	public DynamicControlsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

}
