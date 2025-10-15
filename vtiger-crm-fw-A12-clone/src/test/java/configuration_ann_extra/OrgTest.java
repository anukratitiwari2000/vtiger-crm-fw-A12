package configuration_ann_extra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrgTest {
	
	@BeforeClass
	public void openBro() {
		System.out.println("OPen Browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("login");
	}
	
	@Test
	public void createVoid() {
		System.out.println("Create"+" and Verify");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("logout");
	}
	
	@AfterClass
	public void closeBro() {
		System.out.println("Close Browser");
	}
}
