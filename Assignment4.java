package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*1.Load the URL https://www.amazon.in/
2.search as oneplus 9 pro 
3.Get the price of the first product
4. Print the number of customer ratings for the first displayed product
5. Click the first text link of the first image
6. Take a screen shot of the product displayed
7. Click 'Add to Cart' button
8. Get the cart subtotal and verify if it is correct.
9.close the browser*/
public class Assignment4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> findElements1 = driver.findElements(By.xpath("//span[@class='a-price-symbol']"));
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		String text = findElements1.get(0).getText() + findElements.get(0).getText();
		System.out.println(text);
		System.out.println("The price of the first product:: " + text);
		List<WebElement> findElements2 = driver.findElements(By.xpath("//span[@class='a-size-base s-underline-text']"));
		String text2 = findElements2.get(0).getText();
		System.out.println("The number of customer ratings for the first displayed product:: " + text2);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<>(windowHandles);
		System.out.println(list.size());
		driver.switchTo().window(list.get(1));
		TakesScreenshot scrsht = ((TakesScreenshot) driver);
		File sourceImage = scrsht.getScreenshotAs(OutputType.FILE);
		File destImage = new File(".\\Screenshots\\IMG001.png");
		FileUtils.copyFile(sourceImage, destImage);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(3000);
		String text3 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		String subTotal2 = text3.replaceAll(".00", "");
		String subTotal = subTotal2.substring(0);
		System.out.println(subTotal);
		if (subTotal.equals(text)) {
			System.out.println("The price of the product is same as expected:: " + subTotal);

		}
		driver.quit();
	}

}
