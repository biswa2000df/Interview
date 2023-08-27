package First;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flightBooking {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
//				ChromeDriver driver = new ChromeDriver(options);
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://blazedemo.com/index.php");
		
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath("//*[text()='Welcome to the Simple Travel Agency!']"));
		System.out.println(ele.isDisplayed());
		
		Thread.sleep(1000);
			
		driver.findElement(By.linkText("destination of the week! The Beach!")).click();
		
		System.out.println("hello");
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		WebElement from=driver.findElement(By.xpath("//*[@name='fromPort']"));
		
		Select s=new Select(from);
		
		s.selectByVisibleText("Mexico City");
		
		Thread.sleep(2000);
		
		
		WebElement to=driver.findElement(By.xpath("//*[@name='toPort']"));
		
		Thread.sleep(2000);
		
		
		Select s1=new Select(to);
			s1.selectByIndex(2);
			
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		
		List al=new ArrayList();
		List al1=new ArrayList();
		
		for(int i=1;i<=5;i++)
		{
		
	WebElement tab=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr["+i+"]/td[6]"));
		
	System.out.println(tab.getText());
	
	
	al.add(tab.getText());
	al1.add(tab.getText());
		}
		
		System.out.println(al);
		
		
		
		Collections.sort(al);
		
		String price=(String) al.get(0);
		
		System.out.println(price);
		
		
			for(int k=1;k<al1.size();k++) {
				
				if(al1.get(k).equals(price))
				{
					System.out.println(al1.get(k));
					driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr["+k+"]/td[1]/input")).click();
				}
					
				
			}
			
			
			WebElement ele4=driver.findElement(By.xpath("//*[text()='Total Cost: ']"));
			
			if(ele4.isDisplayed())
			{
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				
			}
			
			
			
			
//			driver.findElement(By.id("inputName")).sendKeys("Biswajit sahoo");
//			
//			driver.findElement(By.id("address")).sendKeys("mumbai");
//			
//		
//			driver.findElement(By.id("city")).sendKeys("mumbai");
//			
//			driver.findElement(By.id("state")).sendKeys("odisha");
//			
//			
//			driver.findElement(By.id("zipCode")).sendKeys("754204");
//			
//			
//			
//			
//			
//			Select s2=new Select(driver.findElement(By.id("cardType")));
//			
//			s2.selectByVisibleText("Visa");
//			
//			driver.findElement(By.id("creditCardNumber")).sendKeys("1478523699874561");
//			
//			
//			driver.findElement(By.id("creditCardMonth")).sendKeys("11");
//			
//			driver.findElement(By.id("creditCardYear")).sendKeys("2023");
//			
//			
//			driver.findElement(By.id("nameOnCard")).sendKeys("biswajit sahoo");
//			
		
			
		
			
			WebElement thanku=driver.findElement(By.xpath("//*[text()='Thank you for your purchase today!']"));
			System.out.println(thanku.getText());
			
			
			WebElement id=driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]"));
			
			System.out.println("The id is "+id.getText());
	
			driver.close();
		
		
//		driver.findElement("/html/body/div[2]/table/tbody/tr[3]/td[1]/input").click();
	}
}
