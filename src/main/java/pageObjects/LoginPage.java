package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	static WebDriver driver;
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[1]")
	WebElement clickfirstLogin;

	@FindBy(name="email")
	WebElement UserName;

	@FindBy(name="password")
	WebElement Password;  

	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	WebElement login;
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	static
	WebElement warning;

	public LoginPage(WebDriver driver){

		LoginPage.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void clickfirstLogin(){

		clickfirstLogin.click();
	}

	//setters

	public void setUserName(String strUserName){

		UserName.sendKeys(strUserName);     
	}
	//Set password in password textbox

	public void setPassword(String strPassword){

		Password.sendKeys(strPassword);
	}
	public void clickLogin(){
		login.click();
	}
	public static String validateLoginTitle()
	{
		return	driver.getTitle();
	}
	public static String checkCredentials() {
		return warning.getText();
	}



}
