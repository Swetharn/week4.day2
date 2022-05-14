package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		// driver.findElement(By.xpath("//button[@id='home']")).click();
//	Set<String> windowHandles = driver.getWindowHandles();
//	List<String> list = new ArrayList<>(windowHandles);
//	driver.switchTo().window(list.get(1));
//	driver.findElement(By.xpath("//h5[text()='Edit']")).click();
//	driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<>(windowHandles1);
		System.out.println(list1.size());
		driver.switchTo().window(list1.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list1.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(list1.get(0));
		System.out.println(driver.getTitle());
		// ydriver.close();
	}
}
