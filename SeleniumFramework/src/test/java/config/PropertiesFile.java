package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.Modularcode;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	
	
	public static void main(String[] args) {
		
		readProperty();
		writeProperties();
		readProperty();
			
	}
	
	public static void readProperty() {
		
		
		
		try {
			
			InputStream input = new FileInputStream("C:\\Users\\deshmose\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\config\\config.properties");
			prop.load(input);
//			System.out.println(prop.getProperty("browser"));
			Modularcode.browser = prop.getProperty("browser");
			
			System.out.println(Modularcode.browser);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeProperties() {
		
		try {
			OutputStream output = new FileOutputStream("C:\\Users\\deshmose\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\config\\config.properties");
			prop.setProperty("browser", "Chrome");
			prop.store(output, "wow");
			prop.setProperty("result", "pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
	
