package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Modularcode {
	
	static WebDriver driver;
	public static String browser;

	public static void main(String[] args) throws InterruptedException, IOException {
//		setBrowser();
		
		PropertiesFile.readProperty();
//		PropertiesFile.writeProperties();
//		PropertiesFile.readProperty();
		setBrowserConfig();
		runTest();
		

	}
	//setBrowser
	//setBrowserConfig
	//runTest
	
//	public static void setBrowser() {
//		
//		browser = "Firefox";
//		
//	}
	
	public static void setBrowserConfig() {
		
		if (browser.contains("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\deshmose\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		
		if (browser.contains("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
//			System.setProperty("webdriver.firefox.driver", "C:\\Users\\deshmose\\eclipse-workspace\\SeleniumFramework\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		
	}
	
	public static void runTest() throws InterruptedException, IOException {
		
		
		//implicit wait...polling frequency is 500ms
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.get("https://www.google.com/");
		
//		String originalWindow = driver.getWindowHandle();
		/*
		driver.navigate().to("https://www.youtube.com/");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		 
		
		
//		driver.switchTo().window(originalWindow);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.navigate().to("https://www.google.com/");
		
		*/
//		driver.navigate().to("https://www.amazon.in/");
		
		WebElement search = driver.findElement(By.name("q"));
		
		search.sendKeys("amazon india" + Keys.ENTER);
		driver.manage().window().maximize();
		
		
		
		
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Online Shopping site in India: Shop Online for Mobiles, Books ..."))).click();
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath(browser)));
		
//		String originalWindow = driver.getWindowHandle();
//		driver.findElement(By.linkText("org.openqa.selenium")).click();
//		driver.findElement(By.xpath("/html/body")).click();
//		driver.switchTo().window(originalWindow);
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		driver.manage().window().minimize();
//		Thread.sleep(2000);
//		driver.manage().window().fullscreen();
//		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/div")).click();
//		driver.switchTo().defaultContent();
//		System.out.println(driver.manage().window().getPosition().getX());
		
//		driver.close();
		
//		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
//		FileUtils.copyFile(SrcFile, new File("./homepage.png"));
	
//		WebElement element  = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
		
//		File ScrFile1 = element.getScreenshotAs(OutputType.FILE);
		
//		FileUtils.copyFile(ScrFile1, new File("./logo.png"));
		
//		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		
		
		
//		driver.findElement(By.id("ap_email")).sendKeys("7030981017" + Keys.ENTER);
//		
//		driver.findElement(By.id("ap_password")).sendKeys("mosesjosh" + Keys.ENTER);
		
		
		
		
		
		
		
		
		
//		
		
		
		
		System.out.println("Test Successfull");
//		driver.quit();
		
		
		
		
	}

}
