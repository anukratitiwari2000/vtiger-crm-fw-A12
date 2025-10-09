package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	
	//Getters
	public WebElement getOrgLink() {
		return orgLink;
	}
	
	
	
	
	}