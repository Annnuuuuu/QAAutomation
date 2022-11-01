package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;	
	public static String environment;
	
	public static void driveSetup() {
		if(PropertyFileReader.getBrowser().equalsIgnoreCase("edge")) {
		//System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\drivers\\msedgedriver.exe");
		WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(PropertyFileReader.getBrowser().equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		setDriver(driver);
	}
	
	public static void setDriver(WebDriver driver) 
	{
		Driver.driver = driver;
	}
		
		public static WebDriver getDriver()
		{
			return driver;
		}

		
	}

	

	


