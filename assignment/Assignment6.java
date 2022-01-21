package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment6 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://www.leafground.com/pages/sorttable.html");
		List<WebElement> webNameList = driver.findElements(By.xpath("//table[@id='table_id']//tr[@role='row']/td[2]"));
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for (WebElement ele : webNameList)			
		{
			list1.add(ele.getText());
		}
		int len = list1.size();
		System.out.println(list1);
		for (int i = 1; i <= len; i++)
		{
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			list2.add(text);
		}
		System.out.println(list2);
		if (list1.equals(list2))
		{
			System.out.println("Both list are same.");
		} 
		else
		{
			System.out.println("Both list are not same.");
		}
	}

}
