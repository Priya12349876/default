package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {

		@FindBy(xpath="//*[@id='main-nav']/a[6]/span")
		WebElement Tasks;
		@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button")
		WebElement NewTasks;
		
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")
		WebElement Title;
		
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div")
		WebElement taskType;
		
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/div[2]/div[4]/span")
		WebElement taskTypeSelect;
		
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div[1]/div/input")
		WebElement dateClick;
		
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[6]")
		WebElement taskDateSelect;
		
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[3]/div[1]/div/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li[37]")
		WebElement taskTimeSelect;

		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div")
		WebElement assignedClick;
		
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/div[2]/div/span")
		WebElement assignedSelect;
		@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div[2]/form/div[6]/div[1]/div/textarea")
		WebElement Description;
		
		
		
		@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
		WebElement saveTask;

		WebDriver driver;

		public TaskPage(WebDriver driver){

			this.driver = driver;
			PageFactory.initElements(driver, this);

		}


		public void Tasks_button() throws Exception {
			Tasks.click();
			Thread.sleep(1000);

		}


		public void NewTasks() throws Exception {

			NewTasks.click();
			Thread.sleep(1000);
		}


		public void FillTaskForm(String strTitleName, String strDescription) {
			this.setTitleName(strTitleName);
			
			this.assignclick();
			this.assignselect();
			this.taskType();
			this.taskTypeSelect();
			this.dateClick();
			this.taskDateSelect();
			this.taskTimeSelect();
	
			this.setDescription(strDescription);
			this.SaveTask();

		}


		private void setDescription(String strDescription) {
			// TODO Auto-generated method stub
			Description.sendKeys(strDescription);
			
		}


		private void taskTypeSelect() {
			// TODO Auto-generated method stub
			taskTypeSelect.click();
			
		}


		private void taskType() {
			// TODO Auto-generated method stub
			taskType.click();
			
		}


		private void taskTimeSelect() {
			// TODO Auto-generated method stub
			taskTimeSelect.click();
			
		}


		private void taskDateSelect() {
			// TODO Auto-generated method stub
			taskDateSelect.click();
			
		}


		private void dateClick() {
			// TODO Auto-generated method stub
			 dateClick.click();
		}


		private void assignclick() {
			// TODO Auto-generated method stub
			assignedClick.click();

		}


		private void assignselect() {
			// TODO Auto-generated method stub
			assignedSelect.click();
		}


		private void SaveTask() {
			// TODO Auto-generated method stub
			saveTask.click();
		}


		private void setTitleName(String strTitleName) {
			// TODO Auto-generated method stub
			Title.sendKeys(strTitleName);
		}


		}




