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

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		options.addArguments("--disable-notifications");
		driver.get("https://www.myntra.com/");
		Actions builder = new Actions(driver);		
		Thread.sleep(1000);
		WebElement menElement = driver.findElement(By.xpath("//div[@class='desktop-navLink' and @data-reactid='20']/a"));			
		builder.build();
		builder.moveToElement(menElement).perform();
		Thread.sleep(1000);
		WebElement jacketElement = driver.findElement(By.xpath("//li[@data-reactid='40']/a"));
		builder.build();
		builder.moveToElement(jacketElement).click().perform();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String countjacket= text.replaceAll("[^0-9]", "");
		System.out.println("Total number of Jacket items : "+countjacket);
		String text2 = driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::span")).getText();
		String countcategory = text2.replaceAll("^[0-9]", "");
		text2 = countcategory.replaceAll("[(,)]", "");
		System.out.println("Total number of Jackets in categories  : "+text2);
		if (countjacket.equals(text2)) 
		{
			System.out.println("Yes the total number of Jackets matches with Categories.");
		} else
		{
			System.out.println("No the total number of Jackets does not matches with Categories.");
		}
		driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='FilterDirectory-list']/li[2]//div[@class='common-checkboxIndicator']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		List<WebElement> brandEleList = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int count=0;
		for (WebElement webElement : brandEleList)
		{
			String str = webElement.getText();			
			if(str.equals("Duke"))
			{
				count++;
			}
		}
		
		if (count == brandEleList.size())
		{
			System.out.println("Yes, all brands are Duke");
		}
		else
		{
			System.out.println("No, all brands are not Duke");
		}
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='sort-list']/li[3]")).click();
		Thread.sleep(1000);
		String text3 = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("Price of Jacket : "+text3);
		 driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).click();
		 Thread.sleep(3000);
		 Set<String> winh = driver.getWindowHandles();
		 List<String> win = new ArrayList<String>(winh);
		 driver.switchTo().window(win.get(1));
		 File source = driver.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./images/MyntraJacket.png");
		 FileUtils.copyFile(source, dest);
		 driver.findElement(By.xpath("//a[@class='desktop-wishlist']/span[2]")).click();
		 Thread.sleep(3000);
		 driver.quit();		
	}

}
