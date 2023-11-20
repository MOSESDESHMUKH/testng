package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoading {
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		 
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);	
		
		driver.get("https://google.com");
		driver.quit();
		
		
		
		
		
	}
}
