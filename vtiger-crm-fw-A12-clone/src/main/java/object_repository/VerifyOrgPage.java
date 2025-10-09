package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrgPage {
	
	//initialization
	public VerifyOrgPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//DECLARATION-Verify Actual Organization Name
	@FindBy(id="dtlview_Organization Name")
	private WebElement actOrgName;


	//Getters
	public WebElement getActOrgName() {
		Object orgField = "anukratiautomation16";
		if (actOrgName.equals(orgField)) {
			System.out.println("Created Organization Sucessfully...!");
		} else {
			System.out.println("Failed....");

		}
		return actOrgName;
	}




}


