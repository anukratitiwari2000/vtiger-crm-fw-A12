package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sauceDemo {
public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.saucedemo.com/v1/");

	
	LoginPage lp=new LoginPage(driver);

	//login
	//declaration with initialization
	
	WebElement un=lp.getUn();
	WebElement pwd=lp.getPwd();
	WebElement login=lp.getLogin();
	
	//utilization
	un.sendKeys("standard_user");
	pwd.sendKeys("secret_sauce");
	login.click();
	
	
	//verify
	HomePage hp=new HomePage(driver);
	
	//declaration with initialization
	//logo
	WebElement logo=hp.getLogo();
	
	//addToCart
	WebElement addToCartBackpack=hp.getAddToCartBackpack();
	addToCartBackpack.click();
		
	//Click On CartIcon
	WebElement cartIcon=hp.getCartIcon();
	cartIcon.click();
	
	//CartPage is Displaying
	CartPage cp=new CartPage(driver);
	
	WebElement checkout=cp.getCheckout();
	checkout.click();
	
	//CheckOutOne
	CheckOutOne co=new CheckOutOne(driver);
	
	//declaration and initialization
	WebElement FirstName=co.getFirstName();
	WebElement LastName=co.getLastName();
	WebElement ZipCode=co.getZipCode();
	WebElement Continue=co.getContinue();
	
	//utilization
	FirstName.sendKeys("Anukrati");
	LastName.sendKeys("Tiwari");
	ZipCode.sendKeys("485001");
	Continue.click();
	
	
	//CheckOutTwo
	CheckOutTwo ct=new CheckOutTwo(driver);
	
	WebElement Finish=ct.getFinish();
	Finish.click();
	
	//Confirmation
	Confirmation cf=new Confirmation(driver);
	
	WebElement confirm=cf.getConfirmation();
	
	if(confirm.isDisplayed())
		System.out.println("Order Successfully...!!!");
	else
		System.out.println("Order Failed...");
	Thread.sleep(3000);
	driver.quit();
	}
}
