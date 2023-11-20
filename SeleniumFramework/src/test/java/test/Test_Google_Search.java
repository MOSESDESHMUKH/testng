package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.GoogleSearchPage;

public class Test_Google_Search {
	
	
	private static WebDriver driver = null;
	

	public static void main(String[] args) {
		
		googleSearch();
		

	}
	
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		
		GoogleSearchPage.search_box(driver).sendKeys("Moses");
		GoogleSearchPage.button_Search(driver).sendKeys(Keys.RETURN);
		
		System.out.println("Done");
		
		
	}

}
