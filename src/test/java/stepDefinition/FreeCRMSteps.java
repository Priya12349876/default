package stepDefinition;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CalendarPage;
import pageObjects.ContactsPage;
import pageObjects.DealsPage;
import pageObjects.LoginPage;
import pageObjects.TaskPage;

public class FreeCRMSteps {
	String driverPath = "C:\\driver\\chromedriver.exe";
	WebDriver driver;

	LoginPage objLogin;

	ContactsPage objContactsPage;
	DealsPage objDealsPage;
	TaskPage objTaskPage;
	CalendarPage objCalendarPage;
	@Before
	public void setup(){
	System.setProperty("webdriver.chrome.driver", driverPath);

	driver = new ChromeDriver(); //Launch chrome

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	driver.get("https://freecrm.co.in/"); //Open the FreeCRM website
	
	driver.manage().window().maximize();

	objLogin = new LoginPage(driver);
	objContactsPage= new ContactsPage(driver);
	objDealsPage= new DealsPage(driver);
	objTaskPage= new TaskPage(driver);
	objCalendarPage= new CalendarPage(driver);
	}

	@Given("^User is on Login page$")
	public void user_is_on_Login_page() throws Exception {
		objLogin.clickfirstLogin();  //calls the method clickfirstLogin
		String title=LoginPage.validateLoginTitle();
		Thread.sleep(3000); //delay
		Assert.assertEquals(title,"Cogmento CRM"); //compare the login page title with actual title

	}

	@When("^User enters valid UserName and Password$")
	public void user_enters_valid_UserName_and_Password() throws Exception{ 
		objLogin.setUserName("mounikapriyapyla@gmail.com"); //calls the method Enters username in the Username field
		Thread.sleep(1000);
		objLogin.setPassword("Priya$&26"); //calls the method which Enters the password
		Thread.sleep(1000);

	}

	@When("^clicks on login$")
	public void clicks_on_login(){
		objLogin.clickLogin(); //calls the method which clicks on login
	}

	@Then("^User should be navigated to Home Page$")
	public void user_should_be_navigated_to_Home_Page()  {

		String homePagetitle=driver.getTitle();
		Assert.assertEquals(homePagetitle,"Cogmento CRM");
		System.out.println(homePagetitle);

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2)  {
		objLogin.setUserName(arg1);
		objLogin.setPassword(arg2);
		

	}

	@Then("^Displays an alert Message$")
	public void displays_an_alert_Message() {
		String alert=LoginPage.checkCredentials();
		System.out.println(alert);
		
	}

	@Given("^User is on Home page$")
	public void user_is_on_Home_page() throws Exception {
		objLogin.clickfirstLogin();
		objLogin.setUserName("mounikapriyapyla@gmail.com");
		objLogin.setPassword("Priya$&26");
		objLogin.clickLogin();
		Thread.sleep(1000);
		String title1=driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals(title1,"Cogmento CRM");
	}

	@When("^user clicks on contacts$")
	public void user_clicks_on_contacts() throws Exception  {

		objContactsPage.Contacts_button();
		Thread.sleep(1000);
	}

	@When("^user navigated to contacts page$")
	public void user_navigated_to_contacts_page() throws Exception {
		String ContactPageTitle=driver.getTitle();
		Assert.assertEquals(ContactPageTitle,"Cogmento CRM");
		Thread.sleep(1000);
	}

	@Then("^User clicks on new$")
	public void user_clicks_on_new() throws Throwable {
		objContactsPage.New_Contact();
		Thread.sleep(1000);
		//		System.out.println("user on contact page");
	}

	@Then("^User is able to create a new contact on filling the FirstName and LastName fields$")
	public void user_is_able_to_create_a_new_contact_on_filling_the_FirstName_and_LastName_fields() throws Throwable {
   	objContactsPage.Contacts_formFill("Priya", "moni", "p", "capgemini");
   	driver.quit();
//
//		objContactsPage.setFirstName("mounikapyla"); Thread.sleep(1000);
//		objContactsPage.setLastName("priya$&26");Thread.sleep(1000);
//		objContactsPage.setMiddleName("priya$&26");Thread.sleep(1000);
//		objContactsPage.setCompanyName("priya$&26");Thread.sleep(1000);
//		objContactsPage.Save_contact();
		
	}

	@Then("^User leaves the FirstName field empty and clicks on save$")
	public void user_leaves_the_FirstName_field_empty_and_clicks_on_save() throws Throwable {
		objContactsPage.Contacts_formFill("", "moni", "p", "capgemini");
	}

	@Then("^Display an firstname alert Message$")
	public void display_an_firstname_alert_Message() throws Throwable {
		String fnamealert=ContactsPage.firstnamealert();
		Assert.assertEquals(fnamealert, "The field First Name is required");
	}
	@Then("^User leaves the LastName field empty and clicks on save$")
	public void user_leaves_the_LastName_field_empty_and_clicks_on_save() throws Throwable {
		objContactsPage.Contacts_formFill("priya", "", "ps", "capgemini");
	}
	@Then("^Display an lastname alert Message$")
	public void display_an_lastname_alert_Message() throws Throwable {
		String lnamealert=ContactsPage.lastnamealert();
		Assert.assertEquals(lnamealert, "The field Last Name is required");
	}

	@When("^user clicks on Deals$")
	public void user_clicks_on_Deals() throws Throwable {
		objDealsPage.Deals_button();
		Thread.sleep(1000);
     
	}

	@When("^user navigated to Deals page$")
	public void user_navigated_to_Deals_page() throws Throwable {
		String DealsPageTitle=driver.getTitle();
		Assert.assertEquals(DealsPageTitle,"Cogmento CRM");
		Thread.sleep(1000);

	}
	@Then("^User clicks on new deal$")
	public void user_clicks_on_new_deal() throws Throwable {
		objDealsPage.New_Deal();
		Thread.sleep(1000);
		//		System.out.println("user on contact page");
	}
	

	@Then("^User is able to create a new Deal on filling the Title field$")
	public void user_is_able_to_create_a_new_Deal_on_filling_the_Title_field() throws Throwable {
       objDealsPage.FillDealForm("Mobile software", "Capgemini");
       
	}

	@When("^user clicks on Tasks$")
	public void user_clicks_on_Tasks() throws Throwable {
		objTaskPage.Tasks_button();
		Thread.sleep(1000);
	}

	@When("^user navigated to Tasks page$")
	public void user_navigated_to_Tasks_page() throws Throwable {
		String TasksPageTitle=driver.getTitle();
		Assert.assertEquals(TasksPageTitle,"Cogmento CRM");
		Thread.sleep(1000);
	}
	@Then("^User clicks on new task$")
	public void user_clicks_on_new_task() throws Throwable {
		objTaskPage.NewTasks();
		Thread.sleep(1000);

	}

	@Then("^User is able to create a new Task on filling the Title field$")
	public void user_is_able_to_create_a_new_Task_on_filling_the_Title_field() throws Throwable {
		 objTaskPage.FillTaskForm("To complete testing Mobile software","This is to test the all test cases that are executed or not");
	}

	@When("^user clicks on Calendar$")
	public void user_clicks_on_Calendar() throws Throwable {
		
		objCalendarPage.clickCalendar();
		Thread.sleep(1000);
	}

	@When("^user navigated to Calendar page$")
	public void user_navigated_to_Calendar_page() throws Throwable {
		String CalendarPageTitle=driver.getTitle();
		Assert.assertEquals(CalendarPageTitle,"Cogmento CRM");
		Thread.sleep(1000);
		
	}

	@Then("^Created tasks should be displayed on Calendar Page$")
	public void created_tasks_should_be_displayed_on_Calendar_Page() throws Throwable {
		String taskmessage=CalendarPage.displayOnCalendar();
		Thread.sleep(1000);
		Assert.assertEquals(taskmessage,"To complete testing Mobile software");
	}


}
