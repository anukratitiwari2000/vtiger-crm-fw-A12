package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationText{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		//Get the data From Excel Sheet.
		FileInputStream FisExcel = new FileInputStream("./src/test/resources/GetDataFromExcelFile.java.xlsx");
		
		Workbook wb = WorkbookFactory.create(FisExcel);
		
		Sheet sh = wb.getSheet("org");
		
		Row row = sh.getRow(5);
		
		Cell cell=	row.getCell(0);
		
		String orgName=cell.getStringCellValue()+(int)(Math.random()*1000);

		//Open the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

		// user name
		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys("admin");

		// password
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");

		// click on login
		driver.findElement(By.id("submitButton")).click();

		// Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		// Filling data to organization text field
		WebElement orgField = driver.findElement(By.name("accountname"));
		//	String orgName = "anukratiautomation14";
		orgField.sendKeys(orgName);

		// Filling data to phone no.
		WebElement PhNo = driver.findElement(By.name("phone"));
		String Number = "6261876439";
		PhNo.sendKeys(Number);

		// Filling data to other phone no.
		WebElement otherPhNo = driver.findElement(By.id("otherphone"));
		String otherNo = "7000654378";
		otherPhNo.sendKeys(otherNo);

		// Filling data to email
		WebElement email = driver.findElement(By.id("email1"));
		email.sendKeys("anu@gmail.com");

		// Filling data to rating dropdown
		WebElement RatingDD = driver.findElement(By.name("rating"));
		Select rate = new Select(RatingDD);
		rate.selectByValue("Active");

		// Filling data to Website
		WebElement website = driver.findElement(By.name("website"));
		website.sendKeys("www.automationproject.in");

		// step 1> get the home address/ParentId
		String PID = driver.getWindowHandle();

		// Step2> perform the task which will open new window/s.
		driver.findElement(By.cssSelector("img[alt='Select']")).click();

		// Step3> Get all the Windows id/children IDs.
		Set<String> IDs = driver.getWindowHandles();

		// Step4> Switch to particular window
		for (String i : IDs) {
			driver.switchTo().window(i);

			// Step5> perform the Task
			if (driver.getCurrentUrl().contains("specific_account_address")) {
				Thread.sleep(2000);
				WebElement choose = driver.findElement(By.linkText("anukratiautomation"));
				Actions act = new Actions(driver);
				act.moveToElement(choose).click().build().perform();
				driver.switchTo().alert().accept();
				break;
			}
		}

		// Step6> come back to homepage/parent.
		driver.switchTo().window(PID);
//	//Filling Member Of using "+" icon.
//	driver.findElement(By.cssSelector("img[alt='Select']")).click();
//	
//	//selecting member.
//	driver.findElement(By.linkText("AutomationWithAnukrati")).click();
//	
		// save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// Verfication
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Created Organization Sucessfully...!");
		} else {
			System.out.println("Failed....");

		}
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
