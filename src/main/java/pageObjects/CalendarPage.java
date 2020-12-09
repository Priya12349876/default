package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='main-nav']/a[2]/span")
	WebElement CalendarButton;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/div")
	static
	WebElement CheckTaskOnCalendar;
	public CalendarPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void clickCalendar() throws Exception{
		CalendarButton.click();
		Thread.sleep(2000);
	}

	public static String displayOnCalendar() {
		// TODO Auto-generated method stub
		return CheckTaskOnCalendar.getText();
	}
}
