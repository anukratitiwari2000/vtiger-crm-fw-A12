package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo5Test {
	
	@Parameters("bro")
	@Test
	public void Case5(String Browser) throws InterruptedException {
		WebDriver driver=null;
		
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
