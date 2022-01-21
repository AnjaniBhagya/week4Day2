package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static boolean isSorted(Integer[] arr) 
	{
		boolean temp=false;
	  
	    int j=0;
		while (j<arr.length-1)
	    {
	    	
		
	    	 if ((arr[j] <= arr[j+1]))
		        {
		            temp=true;
		           
		        } 
		        else
		        {
		           temp=false; 
		           
		        }
			j=j+1;
	    }
		return temp;
		
	    
	}
	
	public static void main(String[] args) throws InterruptedException, IOException
	{
		    WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			ChromeOptions o = new ChromeOptions();			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.get(" https://www.snapdeal.com/");
			o.addArguments("--disable-notifications");
			Thread.sleep(4000);
			WebElement element1 = driver.findElement(By.xpath("//div[@id='category1Data']/preceding-sibling::a"));
			WebElement element2 = driver.findElement(By.xpath("//div[@id='category1Data']//div//p[2]/a"));			
			Actions builder = new Actions(driver);
			builder.moveToElement(element1).pause(Duration.ofSeconds(4)).moveToElement(element2).click().build().perform();
			Thread.sleep(5000);
			String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();			
			System.out.println("Count of Shoes: "+count);
			driver.findElement(By.xpath("//div[text()='Training Shoes']/parent::a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'Popularity')]/following::li[2]")).click();
			Thread.sleep(4000);
			List<Integer> shoeprice = new ArrayList<Integer>();						
			List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='lfloat product-price'] "));
			for(WebElement e:priceElements)
			{
				String price= e.getAttribute("display-price");
				int intprice = Integer.parseInt(price.trim());
				shoeprice.add(intprice);
			}			 
			Integer[] arr = new Integer[shoeprice.size()];
	        arr = shoeprice.toArray(arr);
	        System.out.println("Are the given prices Sorted(Checking) : ");
	        if (isSorted(arr)) {
				System.out.println("Yes Sorted");
			}
	        else {
	        	System.out.println("Not Sorted");
			}
	        driver.findElement(By.name("fromVal")).clear();
	        Thread.sleep(2000);
	        driver.findElement(By.name("fromVal")).sendKeys("900");
	        driver.findElement(By.name("toVal")).clear();
	        Thread.sleep(2000);
	        driver.findElement(By.name("toVal")).sendKeys("1200");
	        driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
	        Thread.sleep(2000);	
	        driver.findElement(By.xpath("((//div[@class='filter-inner filter-inner-height'])/following-sibling::button)[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label")).click();	       
	        Thread.sleep(2000);
	        String text = driver.findElement(By.xpath("(//a[@data-key='Price|Price'])[1]")).getText();
	        System.out.println("The Price Range is : "+text);
	        String text2 = driver.findElement(By.xpath("(//a[@data-key='Color_s|Color'])[1]")).getText();
	        System.out.println("The colour is : "+text2);
	        WebElement picelement = driver.findElement(By.xpath("(//div[@class='product-tuple-image '])[1]/a/picture/img"));
	        Actions builder2 = new Actions(driver);
	        builder2.build();
	        builder2.moveToElement(picelement).perform();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]/div")).click();
	        Thread.sleep(2000);
	        String text3 = driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[1]")).getText();
	        System.out.println("The Price is : " +text3);
	        String text4 = driver.findElement(By.xpath("(//div[@class='product-price pdp-e-i-PAY-l clearfix']/span)[2]")).getText();
	        System.out.println("The Discount is : " +text4);
	        WebElement shoepicelement = driver.findElement(By.xpath("//ul[@id='bx-slider-qv-image-panel']/li/img"));
	        File screenshoe = shoepicelement.getScreenshotAs(OutputType.FILE);
	        File destshoepic = new File("./images/SnapShePic.png");
	        FileUtils.copyFile(screenshoe, destshoepic);
	        driver.findElement(By.xpath("//div[@class='close close1 marR10']/i[@class='sd-icon sd-icon-delete-sign']")).click();
	        Thread.sleep(5000);
	        driver.close();
	        
			
	}
}
