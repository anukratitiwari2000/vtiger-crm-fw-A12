package testing_extra;

import org.testng.annotations.Test;

public class Demo2Text {
	@Test(priority=-1)
	public void Create() {
		System.out.println("Create Facebook Account....");
	}
	
	@Test
	public void Modify() {
		System.out.println("Login....");
	}
	@Test(priority=1)
	public void Deactivate() {
		System.out.println("Deactivate the Account....");
	}

}
