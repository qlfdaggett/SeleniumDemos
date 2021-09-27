package SeleniumDemo;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserLaunch {
	
	public static void main(String[] args) {
	
		// Import the chrome webdriver
		System.setProperty("webdriver.chrome.driver","/Users/fdaggett/Documents/WebDriver/chromedriver" );
	
		// Initialize driver
		WebDriver driver = new ChromeDriver();
		
		// Direct driver to google
		driver.get("http://wikipedia.org");
		//driver.manage().window().maximize();
		
		// Print the webpage's title
		System.out.println(driver.getTitle());
		
		// identify element
		WebElement sBar = driver.findElement(By.name("search"));
	
		// enter text into the search bar
		sBar.sendKeys("capybara");
		
		// Wait condition for the serach results
		// TODO: understand this lol
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		wdw.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
	
		// Enter Serach
		sBar.submit();
	
		// Wait until webpage is loaded
		wdw.until(d -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
	
		// Find all elements with the tag "a" (hyperlinks) and add to list
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	
		// Iterate through every link in the list and print their title and url
		for(WebElement link : allLinks)
		{
			String url = link.getAttribute("href");
			String title = link.getText();
			
			// Match out non-wikipedia web searches and blank titles
			if (url != null &&
				Pattern.matches(".*/wiki/.*",url) && !title.equals(""))
			{
				System.out.println(title + "-" + url); 
			}
		}
		
		
		
		driver.close();
		
		
	}

}
