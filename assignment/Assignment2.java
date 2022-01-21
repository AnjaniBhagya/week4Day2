package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions o = new ChromeOptions();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		o.addArguments("--disable-notifications");
		driver.get("https://www.nykaa.com/");		
		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		WebElement brandEle = driver.findElement(By.xpath("(//div[@id='black_layer'])[1]/following-sibling::ul[2]//a[contains(text(),'brands')]"));
		builder.build();
		builder.moveToElement(brandEle).perform();
		WebElement lorealEle = driver.findElement(By.xpath("(//div[@id='list_topbrands']/following-sibling::div)[6]/a[1]"));
		builder.build();
		builder.moveToElement(lorealEle).click().perform();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//div[@id='filter-sort']//div[1]//button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='radio_customer top rated_undefined']/following-sibling::label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='first-filter']//div")).click();
		Thread.sleep(0);
		driver.findElement(By.xpath("//ul[@id='custom-scroll']//li[1]/div")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']/parent::div")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Concern']/parent::div")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']/parent::div")).click();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("((//div[@id='filters-listing']//div)[3]//span)[1]")).getText();
		String text1 = driver.findElement(By.xpath("((//div[@id='filters-listing']//div)[3]//span)[2]")).getText();
		System.out.println("The Two filter applied are : "+text+" and "+text1);
		driver.findElement(By.xpath("((//div[@id='product-list-wrap']//div)[1]//div)[1]/div[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> win = new ArrayList<String>(windowHandles);
		driver.switchTo().window(win.get(1));
		WebElement select = driver.findElement(By.tagName("select"));
		Select dd = new Select(select);
		dd.selectByVisibleText("175ml");
		System.out.println("The price of the shampoo is : "+driver.findElement(By.xpath("(//div[contains(text(),'taxes')]/preceding-sibling::span)[2]")).getText());
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG']/parent::button)[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='cart-count']/ancestor::button")).click();
		Thread.sleep(1000);
		WebElement fraElement = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(fraElement);
		String text2 = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("The Grand total Price is: "+text2);
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		String text3 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		if (text2.equals(text3))
		{
			System.out.println("Yes the Grand Total Price is same.");
		} 
		else {
			System.out.println("No the Grand Total Price is not the same.");
		}
		driver.quit();
	}

}
