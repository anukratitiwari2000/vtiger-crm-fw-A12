package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation {
	
	//initialization
	public Confirmation(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}

	//declaration
	@FindBy(id="checkout_complete_container")
	private WebElement confirm;
	
	//Getters
	public WebElement getConfirmation() {
		return confirm;
	}
}
