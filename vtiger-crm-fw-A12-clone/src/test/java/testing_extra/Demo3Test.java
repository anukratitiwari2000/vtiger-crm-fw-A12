package testing_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo3Test {

	@Test
	public void Create() {
		System.out.println("Create Facebook Account");
	}

	@Test(dependsOnMethods = "Create")
	public void Modify() {
		Assert.assertTrue(false);
		System.out.println("Login....");
	}

	@Test(dependsOnMethods = "Modify")
	public void Deactivate() {
		System.out.println("Deactivate the Account....");
	}
}
