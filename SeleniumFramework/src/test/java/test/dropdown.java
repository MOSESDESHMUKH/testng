package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement drop = driver.findElement(By.id("dropdown"));
		
		Select selectObject = new Select(drop);
		
		
		/*
//		selectObject.selectByIndex(1);
//		Thread.sleep(2000);
		
		selectObject.selectByValue("1");
		Thread.sleep(2000);
//		drop.click();
		selectObject.selectByVisibleText("Option 2");
		
		*/
		List<WebElement> allAvailableOptions = selectObject.getOptions();
		
		for (WebElement options : allAvailableOptions) {
			System.out.println(options.getText());
			if (options.getText().equalsIgnoreCase("option 2"));
			options.click();
		}
				
		Thread.sleep(2000);
		driver.quit();
		
		System.out.println("Done");
	}

}
