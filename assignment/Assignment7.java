package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions o = new ChromeOptions();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		o.addArguments("--disable-notifications");
		driver.get("https://erail.in/");
		Thread.sleep(2000);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("Chennai Egmore",Keys.TAB);
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("Madurai");		
		if(driver.findElement(By.id("chkSelectDateOnly")).isSelected())
		{
			System.out.println("Is Selected.");
		}
		else
		{
			driver.findElement(By.id("chkSelectDateOnly")).click();
		}
		Thread.sleep(2000);
		List<WebElement> webNameList = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr//td[2]//a[1]"));
		List<String> list1 = new ArrayList<String>();		
		for (WebElement ele : webNameList)			
		{
			list1.add(ele.getText());
		}
		Collections.sort(list1);
		System.out.println(list1);
		driver.close();
	}
	
		
}
