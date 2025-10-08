package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration
	@FindBy(className="app_logo")
	private WebElement logo;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_label']//button")
	private WebElement addToCartBackpack;

	@FindBy(id="shopping_cart_container")
	private WebElement cartIcon;
	
	//Getters
	public WebElement getLogo() {
		return logo;
		}

	public WebElement getAddToCartBackpack() {
		return addToCartBackpack;
		}
	
	public WebElement getCartIcon() {
		return cartIcon;
	}
	
}
