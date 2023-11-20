import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserTest {
	
	public static void main(String[] args) {
		
		
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\deshmose\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
//		WebDriver driver1 = new ChromeDriver();
		
//		driver1.get("https://www.amazon.in/");
//		try {
//			Thread.sleep(3000);
//		}
//		catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		//driver1.close();
		
		driver.get("https://www.google.com/");
		
//		driver1.findElement(By.id("input")).sendKeys("Moses");
		
//		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		
//		textbox.sendKeys("Moses");
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"APjFqb\"]"));
		
		int count = list.size();
		
		System.out.print(count);
		
		
		
	}

}
