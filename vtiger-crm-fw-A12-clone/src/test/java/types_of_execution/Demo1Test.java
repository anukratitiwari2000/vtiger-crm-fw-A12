package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1Test {
	@Test
	public void Case1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void Case101() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.quit();
	}
}
