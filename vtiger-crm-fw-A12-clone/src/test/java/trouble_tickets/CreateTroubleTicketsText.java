package trouble_tickets;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateTroubleTicketsText {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys("admin");

		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();

		// click on trouble ticket module
		driver.findElement(By.linkText("Trouble Tickets")).click();

		// Create Trouble Tickets
		driver.findElement(By.cssSelector("img[alt='Create Ticket...']")).click();

		// Title Text field
		WebElement title = driver.findElement(By.name("ticket_title"));
		String tit="Automation With Anukrati";
		title.sendKeys(tit);

		// Priority dropDown
		WebElement priorityDD = driver.findElement(By.name("ticketpriorities"));
		Select priority = new Select(priorityDD);
		priority.selectByValue("High");

		// Severity dropDown
		WebElement severityDD = driver.findElement(By.name("ticketseverities"));
		Select severity = new Select(severityDD);
		severity.selectByValue("Critical");

		// Category dropDown
		WebElement categoryDD = driver.findElement(By.name("ticketcategories"));
		Select category = new Select(categoryDD);
		category.selectByValue("Small Problem");

		// Status dropDown
		WebElement statusDD = driver.findElement(By.name("ticketstatus"));
		Select status = new Select(statusDD);
		status.selectByValue("In Progress");

		// Choose organization
		WebElement selorgDD = driver.findElement(By.name("parent_type"));
		Select selorg = new Select(selorgDD);
		selorg.selectByValue("Accounts");

		// Select organization using child window.

		String PID = driver.getWindowHandle();

		driver.findElement(By.xpath("//tr[3]//img[@alt='Select']")).click();

		Set<String> IDs = driver.getWindowHandles();

		for (String i : IDs) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains("Accounts&action")) {
				WebElement choose = driver.findElement(By.linkText("anukratiautomation13"));
				Actions act = new Actions(driver);
				act.moveToElement(choose).click().build().perform();
				break;
			}
		}
		driver.switchTo().window(PID);

		// To select Product Name using child window

		String PID1 = driver.getWindowHandle();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//tr[4]//img[@alt='Select']")).click();

		Set<String> ID = driver.getWindowHandles();

		Thread.sleep(2000);

		for (String i : ID) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains("Products&action")) {
				WebElement choose1 = driver.findElement(By.linkText("abcd1234"));
				Actions act = new Actions(driver);
				act.moveToElement(choose1).click().build().perform();
				break;
			}
		}
		driver.switchTo().window(PID);

		// Fill data in hours textField.
		WebElement hours = driver.findElement(By.id("hours"));
		String hour = "24";
		hours.sendKeys(hour);

		// Fill the data in days text field.
		WebElement days = driver.findElement(By.id("days"));
		String day = "10";
		days.sendKeys(day);

		// Description for trouble tickets.
		WebElement description = driver.findElement(By.name("description"));
		String des = "The Given information about description textfield is Correct...!";
		description.sendKeys(des);

		// save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verfication
		String actTitle = driver.findElement(By.id("dtlview_Title")).getText();
		System.out.println(actTitle);
		if (actTitle.equals(tit)){
			System.out.println("Create title sucessfully.....!");
		} else {
		
			System.out.println("Failed");
		}
		
		//hover on administration.
		 WebElement administration= driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(administration).click().build().perform();
		 Thread.sleep(2000);
		
		 //sign out
		 driver.findElement(By.linkText("Sign Out")).click();
		 
		 
		 
		Thread.sleep(2000);
		driver.quit();

	}
}
