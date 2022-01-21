package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions o = new ChromeOptions();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		o.addArguments("--disable-notifications");
		driver.get(" https://www.amazon.in/");		
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price is: "+text);
		String price;
		price = text.replaceAll("[^0-9]", "");
		int priceint = Integer.parseInt(price);
		
		WebElement text1 = driver.findElement(By.xpath("(//div[@class='a-row a-size-small']/span)[1]/span"));
		text1.click();
		String text2 = driver.findElement(By.xpath("(//div[@id='a-popover-content-2']//span)[1]")).getText();
		System.out.println("Rating is: "+text2);
		builder.build();
		
		//builder.moveToElement(text1).pause(Duration.ofSeconds(5)).perform();
		Thread.sleep(3000);
		String text3 = driver.findElement(By.xpath("(//span[@class='a-size-base']/a[contains(@title,'5 stars')] )[2]")).getText();
		System.out.println("Percentage of 5stars : "+text3);
		String text4 = driver.findElement(By.xpath("(//span[@class='a-size-base']/a[contains(@title,'4 stars')] )[2]")).getText();
		System.out.println("Percentage of 5stars : "+text4);
		String text5 = driver.findElement(By.xpath("(//span[@class='a-size-base']/a[contains(@title,'3 stars')] )[2]")).getText();
		System.out.println("Percentage of 5stars : "+text5);
		String text6 = driver.findElement(By.xpath("(//span[@class='a-size-base']/a[contains(@title,'2 stars')] )[2]")).getText();
		System.out.println("Percentage of 5stars : "+text6);
		String text7 = driver.findElement(By.xpath("(//span[@class='a-size-base']/a[contains(@title,'1 stars')] )[2]")).getText();
		System.out.println("Percentage of 5stars : "+text7);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Thread.sleep(2000);
		Set<String> winh = driver.getWindowHandles();
		 List<String> win = new ArrayList<String>(winh);
		 driver.switchTo().window(win.get(1));
		Thread.sleep(2000);File source = driver.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./images/AmazonePhone.png");
		 FileUtils.copyFile(source, dest);
		 driver.findElement(By.id("add-to-cart-button")).click();
		 Thread.sleep(3000);
		 String text8 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();	
		 String temp=text8.replaceAll("[^0-9.]", "");
		 float fnum = Float.parseFloat(temp);
		 int value= (int) fnum;
		 if (priceint == value) 
		 {
			System.out.println("View Price and Checkout Price is same");
		 } 
		 else
		 {
			 System.out.println("View Price and Checkout Price is not same");
		 }
		
		 driver.quit();
		

	}

}
