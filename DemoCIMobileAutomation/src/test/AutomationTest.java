package test;

import java.io.IOException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.SetUp;

public class AutomationTest {
	utils.SetUp setUp = new SetUp();
	pages.HomePage home = new pages.HomePage();
	pages.ResultsPage res = new pages.ResultsPage();
	
	RemoteWebDriver driver;
	String firstFrom = "Raleigh/Durham, NC, US (RDU)";	
	String firstEnd = "Minneapolis/St. Paul, MN, US (MSP)";
	String secondFrom = "New York, NY, US (JFK - Kennedy)";
	String secondEnd = "Los Angeles, CA, US (LAX)";
	String chromeDrivePath = "src/utils/chromedriver.exe";
	String foxDrivePath = "src/utils/geckodriver.exe";
	String url = "https://www.united.com/ual/en/us/";
	
	
	public void driverSetup(String browser) throws IOException{

		if(browser.equals("OS")){
			driver = setUp.SetCapabilities();	
		}
		else if (browser.equals("Chrome")){
			driver = setUp.setupChromeDriver(driver, chromeDrivePath);
		}
		else if (browser.equals("Firefox")){
			driver = setUp.setupFireFoxDriver(driver, foxDrivePath);
		}
		
	}
	@Test
	@Parameters("browser")
	public void automationScript(String browser) throws IOException{
	
		System.out.println("Start test");
		driverSetup(browser);
		home.navigateSearchEngine(driver, "https://www.google.com/");
		home.navigateHome(driver, url);
		home.enterCities(driver, firstFrom, firstEnd);
		home.enterDates(driver);
		res.editSearch(driver);
		res.editDates(driver);
		res.editCities(driver, secondFrom, secondEnd);
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver.quit();
	}
}
