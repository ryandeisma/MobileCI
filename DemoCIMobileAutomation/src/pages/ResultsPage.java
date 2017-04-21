package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ResultsPage extends BasePage{
	
	By originTxt = By.id("Origin");
	By destinationTxt = By.id("Destination");
	By departDateTxt = By.id("DepartDate");
	By returnDateTxt = By.id("ReturnDate"); 	
	By searchBtn = By.id("flightBookingSubmit");
	By editSearch = By.xpath("//button[contains(@class, 'btn-show-new-search')]");
	By subSearch = By.xpath("//button[contains(@class, 'edit-search-submit')][@name='search']");
	
	public void editSearch(RemoteWebDriver driver){
		WebElement edit = staleProtect(driver, editSearch);
		edit.click();
	}
	public void editDates(RemoteWebDriver driver){
		String returning = getReturnDate(5);
		WebElement arr = staleProtect(driver, returnDateTxt);
		arr.clear();
		arr.sendKeys(returning);
		
		String newDep = getReturnDate(3);
		WebElement dep = staleProtect(driver, departDateTxt);
		dep.clear();
		dep.sendKeys(newDep);
		
		
	}
	public void editCities(RemoteWebDriver driver, String newOrigin, String newDest){
		
		WebElement origin = staleProtect(driver, originTxt);
		origin.clear();
		origin.sendKeys(newOrigin);
		
		WebElement dest = staleProtect(driver, destinationTxt);
		dest.clear();
		dest.sendKeys(newDest);
		
		WebElement search = staleProtect(driver, subSearch);
		search.click();
	}
}
