package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutTwo {

	//initialization
	public CheckOutTwo(WebDriver driver){
	PageFactory.initElements(driver,this);
		}
	
	//declaration
	@FindBy(linkText="FINISH")
	private WebElement Finish;
	
	//Getters
	public WebElement getFinish() {
		return Finish;
	}
}
