package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePage extends BasePage{
	
	By originTxt = By.id("Origin");
	By destinationTxt = By.id("Destination");
	By departDateTxt = By.id("DepartDate");
	By returnDateTxt = By.id("ReturnDate"); 	
	By searchBtn = By.id("flightBookingSubmit");
	By editSearch = By.xpath("//button[contains(@class, 'btn-show-new-search')]");
	By subSearch = By.xpath("//button[contains(@class, 'edit-search-submit')][@name='search']");
	
	public void navigateSearchEngine(RemoteWebDriver driver, String url){
		driver.get(url);
	}
	public void navigateHome(RemoteWebDriver driver, String url){
		
		driver.get(url);
	}
	public void enterCities(RemoteWebDriver driver, String start, String end){
		
		WebElement origin = staleProtect(driver, originTxt);
		origin.sendKeys(start);
		WebElement dest = staleProtect(driver, destinationTxt);
		dest.sendKeys(end);	

	}
	public void enterDates(RemoteWebDriver driver){
		String leaving = getStartDate();
		WebElement dep = staleProtect(driver, departDateTxt);
		dep.sendKeys(leaving);
		
		String returning = getReturnDate(7);
		WebElement arr = staleProtect(driver, returnDateTxt);
		arr.sendKeys(returning);
		driver.findElement(searchBtn).click();
		
	}
		
}
