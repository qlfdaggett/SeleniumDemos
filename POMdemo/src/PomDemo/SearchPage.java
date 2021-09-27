package PomDemo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	protected WebDriver driver;
	
	private By searchBy = By.name("search");
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// Try to use the search bar and send return the new page as a HomePage
	public HomePage useSearchBar(String searchStr) {
		WebElement searchBar = driver.findElement(searchBy);
		
		searchBar.sendKeys(searchStr);
		searchBar.submit();
		
		
		return new HomePage(driver);
	}

}
