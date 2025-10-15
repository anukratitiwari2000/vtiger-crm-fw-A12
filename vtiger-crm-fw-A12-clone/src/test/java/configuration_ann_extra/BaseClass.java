package configuration_ann_extra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass extends ContactTest {
	@BeforeClass
	public void openBro() {
		System.out.println("open Browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("login");
	}

	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}
	
	@AfterClass
	public void closeBro() {
		System.out.println("Close the Browser");
	}
}
