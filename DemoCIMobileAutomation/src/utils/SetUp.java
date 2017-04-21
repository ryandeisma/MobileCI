package utils;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;

public class SetUp {
	
	public RemoteWebDriver SetCapabilities() throws IOException{
		String browserName = "MobileOS";
		String host = "partners.perfectomobile.com";
		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
        capabilities.setCapability("user", "davidd@perfectomobile.com");
        capabilities.setCapability("password", "Perfecto123");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("location", "NA-US.*");
        // add pre-defined persona and script name
        capabilities.setCapability(WindTunnelUtils.WIND_TUNNEL_PERSONA_CAPABILITY, WindTunnelUtils.GEORGIA);
        capabilities.setCapability("scriptName", "CI Automation Demo");     
        capabilities.setCapability("deviceName","0715F7752C4B3038");
        RemoteWebDriver driver = null;
        
        // create driver
         driver = new RemoteWebDriver(new URL("http://" + host + "/nexperience/perfectomobile/wd/hub"),
                        capabilities);
        
        // implicit wait set to 30 due to slowness and timeout issues
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //Return the driver for other tests
        return driver;   
	}//End Setup
	public RemoteWebDriver setupFireFoxDriver(RemoteWebDriver driver, String driverPath){
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		System.setProperty("webdriver.gecko.driver", driverPath);
		capabilities.setCapability("marionette", true);		
		driver = new FirefoxDriver(capabilities);
		// Add an implicit wait to the driver
		driver.manage().timeouts().implicitlyWait(
		        10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public RemoteWebDriver setupChromeDriver(RemoteWebDriver driver, String driverPath){
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		// Add an implicit wait to the driver
		driver.manage().timeouts().implicitlyWait(
		        10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}
}//End SetUp
