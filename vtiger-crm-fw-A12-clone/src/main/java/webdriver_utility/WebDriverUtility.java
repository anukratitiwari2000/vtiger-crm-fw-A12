package webdriver_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	WebDriver driver;
	Actions act;
	
	
	public WebDriverUtility(WebDriver driver,Actions act) {
		this.driver=driver;
		this.act=new Actions(driver);
		
	}
	
	public void openUrl() {
		driver.get("https://www.facebook.com/");
	}
	
	public void winMax() {
	 driver.manage().window().maximize();
	}
	
	public void hover(WebElement targetElement) {
	act.moveToElement(targetElement).build().perform();	
	}
	
	public void rightClick(WebElement targetElement) {
	act.contextClick(targetElement).build().perform();	
	}
	
	public void doubleClick(WebElement targetElement) {
	act.doubleClick(targetElement).build().perform();	
	}
	
	public void click(WebElement targetElement) {
	act.click(targetElement).build().perform();	
	}
	
	public void clickAndHold(WebElement targetElement) {
	act.clickAndHold(targetElement).build().perform();	
	}
	
	public void release(WebElement targetElement) {
	act.release(targetElement).build().perform();	
	}

	public void dragAndDrop(WebElement targetElement) {
	act.dragAndDrop(targetElement, targetElement).build().perform();
	}

	public void scrollByAmount(WebElement targetElement) {
	act.scrollByAmount(0, 0).build().perform();
	}
	
	public void scrollToElement(WebElement targetElement) {
	act.scrollToElement(targetElement).build().perform();	
	}
	
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	public void select(String visibleText,WebElement element) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void select(WebElement targetElement) {
		Select sel=new Select(targetElement);
		sel.getFirstSelectedOption();
	}


}
