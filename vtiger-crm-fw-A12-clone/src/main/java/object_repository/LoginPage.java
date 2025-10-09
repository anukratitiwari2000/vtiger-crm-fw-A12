package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement un;
	
	@FindBy(name="user_password")
	private WebElement pwd;
	
	@FindBy(id="submitButton")
	private WebElement login;
	
	public WebElement getUn() {
		return un;
	}
	
	public WebElement getPwd() {
		return pwd;
	}
	
	public WebElement getClickOnLogin() {
		return login;
	}
	
	public void getLogin() {
		un.sendKeys("admin");
		pwd.sendKeys("manager");
		login.click();
	}
}
