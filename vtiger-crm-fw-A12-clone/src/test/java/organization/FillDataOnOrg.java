package organization;

import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FillDataOnOrg {
	
	//initialzation
	public FillDataOnOrg(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	
	//DECLARATION-For Organization TextField
	@FindBy(name="accountname")
	private WebElement orgField;
	
	//DECLARATION-For Phone Number TextField
	@FindBy(name="phone")
	private WebElement phNoField;
	
	//DECLARATION-Other Phone Number TextField
	@FindBy(id="otherphone")
	private WebElement otPhNoField;
	
	//DECLARATION-Email TexField
	@FindBy(id="email1")
	private WebElement emailField;
	
	//DECLARATION-Select Rating DropDown
	@FindBy(name="rating")
	private WebElement ratingDD;
	
	//DECLARATION-WebSite TextField
	@FindBy(name="website")
	private WebElement websiteField;
	
	//DECLARATION-Click plus Icon to Select Member Of From Child Window
	
	@FindBy(css="img[alt='Select']")
	private WebElement plusBtnMemberOf;
	
	//DECLARATION-Choose Member Of From Child Window
	@FindBy(linkText="anukratiautomation")
	private WebElement chooseMember;
	
	//DECLARATION-Save
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Getters
	public WebElement getOrgField() {
		return orgField;
	}

	public WebElement getPhNoField() {
		return phNoField;
	}

	public WebElement getOtPhNoField() {
		return otPhNoField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getRatingDD() {
		return ratingDD;
	}

	public WebElement getWebsiteField() {
		return websiteField;
	}

	public WebElement getPlusBtnMemberOf() {
		return plusBtnMemberOf;
	}
	
	public WebElement getChooseMember() {
		return chooseMember;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void getFillDataOnCreateOrgPage(WebDriver driver) throws InterruptedException {
		
		//FILL THE DATA ON ORGTEXTFIELD
		orgField.sendKeys("anukratiautomation16");
		
		//FILL THE DATA ON PHONETEXTFIELD
		phNoField.sendKeys("6261876439");
		
		//FILL THE DATA ON OTHERPHONETEXTFIELD
		otPhNoField.sendKeys("7000654378");
		
		//FILL THE DATA ON EMAILTEXTFIELD
		emailField.sendKeys("anu@gmail.com");
		
		//SELECT RATING DROPDOWN
		Select rate = new Select(ratingDD);
		rate.selectByValue("Active");
		
		//FILL THE DATA ON WEBSITE TEXT FIELD
		websiteField.sendKeys("www.automationproject.in");
		
		//CLICK ON MEMBER OF PLUS ICON AND HANDEL CHILD WINDOW AND CHOOSE MEMEBER OF
		
		// step 1> get the home address/ParentId
		String PID = driver.getWindowHandle();
		// Step2> perform the task which will open new window/s.
		plusBtnMemberOf.click();
		//driver.findElement(By.cssSelector("img[alt='Select']")).click();
		// Step3> Get all the Windows id/children IDs.
		Set<String> IDs = driver.getWindowHandles();
		// Step4> Switch to particular window
		for (String i : IDs) {
			driver.switchTo().window(i);
		// Step5> perform the Task
			if (driver.getCurrentUrl().contains("specific_account_address")) {
				Thread.sleep(2000);
				//WebElement choose = driver.findElement(By.linkText("anukratiautomation"));
				Actions act = new Actions(driver);
				act.moveToElement(chooseMember).click().build().perform();
				driver.switchTo().alert().accept();
				break;
			}
		}
		// Step6> come back to OrgPage/parent.
		driver.switchTo().window(PID);
		
		//CLICK ON SAVE BUTTON
		saveBtn.click();
		
		
		
		
	} 





}
