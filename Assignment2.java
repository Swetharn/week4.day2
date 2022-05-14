package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
driver.switchTo().frame("frame1");
int size = driver.findElements(By.tagName("iframe")).size();
System.out.println(size);
//driver.switchTo().frame("frame3");
driver.findElement(By.xpath("//b[@id='topic']/following :: input")).sendKeys("swetha");
driver.switchTo().defaultContent();
driver.switchTo().frame("frame2");
int size1 = driver.findElements(By.tagName("iframe")).size();
System.out.println(size1);
WebElement findElement = driver.findElement(By.xpath("//select[@id='animals']"));
Select sel = new Select(findElement);
sel.selectByValue("babycat");
driver.switchTo().defaultContent();
driver.switchTo().frame("frame1");
driver.switchTo().frame("frame3");
int size2 = driver.findElements(By.tagName("iframe")).size();
System.out.println(size2);
driver.findElement(By.xpath("//input[@id='a']")).click();
driver.quit();
	}

}
