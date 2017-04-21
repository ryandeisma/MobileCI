package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BasePage {
	public String getStartDate(){
		Date now = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		String timeStamp = formatter.format(now);	
		return timeStamp;
	}
	public String getReturnDate(int noOfDays){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_YEAR, noOfDays);
		Date date = now.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
		String timeStamp = formatter.format(date);	
		return timeStamp;
	}
	public WebElement staleProtect(RemoteWebDriver driver, By loc){
		WebElement elem = null;
		for(int i=0; i<5; i++){
			try{
				elem = driver.findElement(loc);
				break;
        	} catch(StaleElementReferenceException e) {
        	}
		}
		return elem;
	}
}
