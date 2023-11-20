package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.time.Duration;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
//		JSAlert
		
		/*driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		
		if (driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("You successfully clicked an alert");
		}
		
		System.out.println("=============================");
		
		*/
		
//		JSconfirm
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		
		Thread.sleep(2000);
		alert2.dismiss();		
		
		if (driver.getPageSource().contains("You clicked: Cancel")) {
			System.out.println("Test successfull");
		}
		
		System.out.println("=============================");
		
		
//		Jsprompt
		
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		
		Alert alert3 = driver.switchTo().alert();
		
		Thread.sleep(2000);
		
		alert3.sendKeys("Nice one");
		
		Thread.sleep(2000);
		
		alert3.accept();
		
		if(driver.getPageSource().contains("You entered: Nice one")) 
			System.out.println("Test successfull");
		
		System.out.println("========================");
		
		
		
		driver.close();
		driver.quit();
		
		
		
		
		
	}

}
