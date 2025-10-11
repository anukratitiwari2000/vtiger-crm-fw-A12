package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class Demo3Test {
	public void Case3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.quit();
	}
}
