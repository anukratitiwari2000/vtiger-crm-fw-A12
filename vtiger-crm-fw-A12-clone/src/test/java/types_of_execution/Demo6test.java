package types_of_execution;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo6test {
	
	@Test(groups="smoke")
	public static void Case6() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(groups="reg")
	public static void Case61() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(groups="reg")
	public static void Case601() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
	
}
	

