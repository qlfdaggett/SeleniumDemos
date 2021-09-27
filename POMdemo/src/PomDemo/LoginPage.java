package PomDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This assumes the driver starts at en.wikipedia.org
public class LoginPage {
	protected WebDriver driver;
	
	private By loginButtonBy = By.linkText("Log in");
	
	private By loginBy = By.name("wpName");
	private By passwordBy = By.name("wpPassword");
	private By buttonBy = By.name("wploginattempt");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage logInFromSplash(String username, String password) {
		// Click on the login Button
		WebElement loginButton = driver.findElement(loginButtonBy);
		driver.get(loginButton.getAttribute("href"));
	
		// Enter username and password and log in
		driver.findElement(loginBy).sendKeys(username);
		driver.findElement(passwordBy).sendKeys(password);
		driver.findElement(buttonBy).click();
		
		return new HomePage(driver);
		
		
	}
	
	
	
	
	

}
