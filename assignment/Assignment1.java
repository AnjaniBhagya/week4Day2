package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public void drganddrpby() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");		
		WebElement drgframe = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(drgframe);
		WebElement drgElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		int x = drgElement.getLocation().getX();
		int y = drgElement.getLocation().getY();
		System.out.println("The X point is: " + x+" and Y point is: "+y);
		int xtomove = 30, ytomove = 65;
		System.out.println("The To-move X point is: " + xtomove+" and To-move Y point is: "+ytomove);
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.dragAndDropBy(drgElement, xtomove, ytomove).build().perform();
		Thread.sleep(2000);
		driver.close();
	}
	
	public void droptoelement() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");		
		WebElement drgframe = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(drgframe);
		WebElement drgElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.dragAndDrop(drgElement, dropElement).build().perform();
		Thread.sleep(2000);
		driver.close();
	}
	
	public void resizeele() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://jqueryui.com/resizable/");		
		WebElement drgframe = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(drgframe);
		WebElement drgElement = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));		
		int xtomove = -25, ytomove = -35;
		System.out.println("The To-move X point is: " + xtomove+" and To-move Y point is: "+ytomove);
		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.dragAndDropBy(drgElement, xtomove, ytomove).build().perform();
		//mybuild.perform();
		Thread.sleep(2000);
		driver.close();
	}
	
	public void selectele() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://jqueryui.com/selectable/");
		WebElement drgframe = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(drgframe);
		WebElement selecElement1 = driver.findElement(By.xpath("//ol/li[text()='Item 3']"));
		WebElement selecElement2 = driver.findElement(By.xpath("//ol/li[text()='Item 5']"));
		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.dragAndDrop(selecElement1, selecElement2).build().perform();		
		Thread.sleep(2000);
		driver.close();
	}
	
	public void sortele() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://jqueryui.com/sortable/");
		WebElement drgframe = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(drgframe);
		WebElement selecElement1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 4']"));
		WebElement selecElement2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 2']"));
		Actions builder = new Actions(driver);
		WebElement selecElement3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 5']"));
		WebElement selecElement4 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 1']"));
		Thread.sleep(3000);
		builder.build();
		builder.clickAndHold(selecElement3).moveToElement(selecElement4).release().perform();
		builder.build();
		Thread.sleep(3000);
		builder.clickAndHold(selecElement1).moveToElement(selecElement2).release().perform();
		Thread.sleep(5000);
		driver.close();
	}
	

	public static void main(String[] args) throws InterruptedException {
		Assignment1 obj = new Assignment1();
		obj.drganddrpby();
		obj.droptoelement();
		obj.resizeele();
		obj.selectele();
		obj.sortele();
	}

}
