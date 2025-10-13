package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo4Test {

	@Parameters("bro")
	@Test
	public void Case4(String Browser) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
		WebDriver driver=null;
		
		if(Browser.equals("chrome")){
			driver=new ChromeDriver();
		}else if(Browser.equals("edge")){
			driver=new EdgeDriver();
		}else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
