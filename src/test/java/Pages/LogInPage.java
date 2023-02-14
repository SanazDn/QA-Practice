package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(xpath = "//button[@class= 'radius']")
	public WebElement logInBtn;

	@FindBy(xpath = "//div[@id='flash']")
	public WebElement actualSuccessMessage;

	@FindBy(xpath = "//div[@id='flash']")
	public WebElement errorMessage;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void LogIn(String user, String pass) throws InterruptedException {

		username.sendKeys(user);
		password.sendKeys(pass);
		Thread.sleep(2000);
		logInBtn.click();

	}

}
