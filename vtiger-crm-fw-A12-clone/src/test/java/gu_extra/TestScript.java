package gu_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import webdriver_utility.WebDriverUtility;

public class TestScript {
	public static void main(String[] args) {
		
	WebDriver driver=new ChromeDriver();
	
	WebDriverUtility wdUtil=new WebDriverUtility(driver,null );
	
	wdUtil.openUrl();//driver.get("https://www.facebook.com/");
	
	wdUtil.winMax();//driver.manage().window().maximize();
	
	
	}	
}
