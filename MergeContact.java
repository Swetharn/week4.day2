package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * //Pseudo Code
 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
 * 2. Enter UserName and Password Using Id Locator
 * 3. Click on Login Button using Class Locator
 * 4. Click on CRM/SFA Link
 * 5. Click on contacts Button	
 * 6. Click on Merge Contacts using Xpath Locator
 * 7. Click on Widget of From Contact 
 * 8. Click on First Resulting Contact
 * 9. Click on Widget of To Contact
 * 10. Click on Second Resulting Contact
 * 11. Click on Merge button using Xpath Locator
 * 12. Accept the Alert
 * 13. Verify the title of the page
 */

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("(//table)[4]"));
		List<WebElement> rowElements = driver.findElements(By.tagName("tr"));
		List<WebElement> columnElements = rowElements.get(2).findElements(By.xpath("(//table)[4]//tr//td//div//a"));
		WebElement webElement = columnElements.get(0);
		webElement.click();
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<>(windowHandles2);
		driver.switchTo().window(list2.get(1));
		driver.findElement(By.xpath("(//table)[5]"));
		List<WebElement> rowElements1 = driver.findElements(By.tagName("tr"));
		List<WebElement> columnElements1 = rowElements1.get(2).findElements(By.xpath("(//table)[5]//tr//td//div//a"));
		WebElement webElement1 = columnElements1.get(0);
		webElement1.click();
		driver.switchTo().window(list2.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		driver.quit();
	}

}