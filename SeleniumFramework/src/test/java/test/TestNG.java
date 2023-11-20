package test;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.GoogleSearchPage;

public class TestNG {
	
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public static void setUpTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public static void googleSearch() {
		
		
		driver.get("https://google.com");
		
		GoogleSearchPage.search_box(driver).sendKeys("Moses");
		GoogleSearchPage.button_Search(driver).sendKeys(Keys.RETURN);
			
	}
	
	@AfterTest
	public static void testTearDown() {
		
		System.out.println("Done");
		driver.close();
		driver.quit();
		
	}

}
