package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOne {

	//initialization
	public CheckOutOne(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	//declaration
	@FindBy(id="first-name")
	private WebElement FirstName;
	
	@FindBy(id="last-name")
	private WebElement LastName;
	
	@FindBy(id="postal-code")
	private WebElement ZipCode;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	private WebElement Continue;

	//Getters
	public WebElement getFirstName() {
		return FirstName;
		}
	public WebElement getLastName() {
		return LastName;
		}
	public WebElement getZipCode() {
		return ZipCode;
		}
	
	public WebElement getContinue() {
		return Continue;
		}
}
