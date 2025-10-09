package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	//initialization
	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//DECLARATION-Click On Plus Button
	@FindBy(css="img[alt='Create Organization...']")
	private WebElement plusBtn;
	
	//DECLARATION-Hover On Administration
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement administration;
	
	//DECLARATION-SignOut
	@FindBy(linkText="Sign Out")
	private WebElement signOut;

	//Getters
	public WebElement getPlusBtn() {
		return plusBtn;
	}
	
	public WebElement getAdministration() {
		return administration;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}
	
	public void getOrgPage(WebDriver driver) {
		
		//To Hover On Administration
		Actions act = new Actions(driver);
		act.moveToElement(administration).build().perform();

		//Click On SignOut
		signOut.click();
		
	}
		
	
}
