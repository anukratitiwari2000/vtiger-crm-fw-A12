package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void Case1() {
		System.out.println("Hey...!!!");
		}
	
	@Test
	public void Case2() {
		Reporter.log(" Case2: Are you here....?");
	}
	
	@Test
	public void Case3() {
		Reporter.log("Case3: Are you here.....?",true);
		
	}
}
