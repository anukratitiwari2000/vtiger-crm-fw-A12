package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.Test;

import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class OrganizationText {

	@Test
	public void CreateOrganization() throws IOException, InterruptedException {
		
	
		// Get the data From Excel Sheet.
		FileInputStream FisExcel = new FileInputStream("./src/test/resources/GetDataFromExcelFile.java.xlsx");

		Workbook wb = WorkbookFactory.create(FisExcel);

		Sheet sh = wb.getSheet("org");

		Row row = sh.getRow(5);

		Cell cell = row.getCell(0);

		String orgName = cell.getStringCellValue() + (int) (Math.random() * 1000);

		// Open the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/");

		// OBJECT CREATION FOR ALL THE WEBPAGE
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		FillDataOnOrg fdo = new FillDataOnOrg(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		OrgPage op = new OrgPage(driver);

		// login the application
		lp.getLogin();

		// Click on Organization Link
		hp.getOrgLink().click();

		// Click on Plus Button on OrgPage
		op.getPlusBtn().click();

		fdo.getFillDataOnCreateOrgPage(driver);

		vop.getActOrgName();

		// Hover And Then SignOut From OrgPage
		op.getOrgPage(driver);

		Thread.sleep(3000);
		driver.quit();

	}
}
