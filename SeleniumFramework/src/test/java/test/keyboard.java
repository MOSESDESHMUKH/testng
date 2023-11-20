package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboard {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		
		/*
		//sendkeys
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Awesome" + Keys.ENTER);
		
		Thread.sleep(2000);
		*/
		/*
		//keydown()
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Awesome" + Keys.ENTER);
		Actions actionProvider = new Actions(driver);
		Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();
		
		Thread.sleep(2000);
		*/
		
		//keyup()
		
		driver.get("https://google.com");
		
		
		Actions actionProvider = new Actions(driver);
		driver.findElement(By.name("q"));
		actionProvider.keyDown(Keys.SHIFT).sendKeys("moses")
		.keyUp(Keys.SHIFT).sendKeys(" moses").perform();
		
		
		Thread.sleep(2000);
		driver.findElement(By.name("q")).clear();
		
		
		
		
		
		
		
		Thread.sleep(2000);
		
		
		
		driver.quit();
	}

}
