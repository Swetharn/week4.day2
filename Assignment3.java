package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		WebElement firstDropDown = driver.findElement(By.id("dropdown1"));
		Select s1 = new Select(firstDropDown);
		s1.selectByIndex(2);
		WebElement secondDropDown = driver.findElement(By.name("dropdown2"));
		Select s2 = new Select(secondDropDown);
		s2.selectByVisibleText("UFT/QTP");
		WebElement thirdDropDown = driver.findElement(By.id("dropdown3"));
		Select s3 = new Select(thirdDropDown);
		s3.selectByValue("4");
		WebElement fourthDropDown = driver.findElement(By.className("dropdown"));
		Select s4 = new Select(fourthDropDown);
		int size = s4.getOptions().size() - 1;
		System.out.println("The no of options available in drope dwn is:: " + size);
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("Appium");
		WebElement sixthDropDown = driver.findElement(By.xpath("(//select)[5]"));
		Select s6 = new Select(sixthDropDown);
		s6.selectByVisibleText("Loadrunner");
		String text = s3.getFirstSelectedOption().getText();
		System.out.println("First selected option is:: " + text);
		driver.quit();

	}
}
