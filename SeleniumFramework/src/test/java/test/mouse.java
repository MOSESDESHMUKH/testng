package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mouse {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		WebElement elem1 = driver.findElement(By.id("column-a"));
		WebElement elem2 = driver.findElement(By.id("column-b"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(elem1, elem2);
		action.build().perform();

		

	}

}
