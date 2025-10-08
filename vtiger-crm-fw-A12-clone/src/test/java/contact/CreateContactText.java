package contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactText {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		//Get data using properties file
		FileInputStream FIS=new FileInputStream("./src/test/resources/CommonData.properties");
	
		Properties pObj = new  Properties();
		pObj.load(FIS);

		//String BROWSER=pObj.getProperty("bro");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("un");
		String PASSWORD=pObj.getProperty("pwd");
		
		
		//Get data using excel file
		FileInputStream FisExcel = new FileInputStream("./src/test/resources/GetDataFromExcelFile.java.xlsx");
		Workbook wb = WorkbookFactory.create(FisExcel);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		Cell cell=	row.getCell(0);
		String lastname =cell.getStringCellValue();
		wb.close();
		
		//open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

		// user name
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);

		// password
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		// click on login
		driver.findElement(By.id("submitButton")).click();

		// click on contacts.
		driver.findElement(By.linkText("Contacts")).click();

		// click on create contacts "+" icon.
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

		// filling the last name text field.
		WebElement ln = driver.findElement(By.name("lastname"));
		 ln.sendKeys(lastname);

		// Using child window clicking on organization name.
		String PID = driver.getWindowHandle();

		driver.findElement(By.cssSelector("img[alt='Select']")).click();

		Set<String> IDs = driver.getWindowHandles();

		for (String i : IDs) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains("specific_contact_account_address")) {
				WebElement choose = driver.findElement(By.linkText("AutomationWithAnukrati"));
				Actions act = new Actions(driver);
				act.moveToElement(choose).click().build().perform();
				break;
			}
		}
		// switch to PID.
		driver.switchTo().window(PID);

		// save
		driver.findElement(By.xpath("//input[ @value='  Save  ' and @type='submit']")).click();
		
		// verification.
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		System.out.println(actLastName);
		if (actLastName.equals(lastname)) {
			System.out.println("Create contact sucessfully...!");
		
		}else
			System.out.println("Failed....");

		// hover on Administrator
		WebElement administrator = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);

		act.moveToElement(administrator).build().perform();

		Thread.sleep(2000);

		// sign out
		driver.findElement(By.linkText("Sign Out"));
		Thread.sleep(3000);
		driver.quit();

	}

}
