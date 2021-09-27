package PomDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	protected WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Return the title of the webpage
	public String getTitle() {
		return driver.getTitle();
	}

	public boolean verifyLogin(String username)
	{
		boolean verify;
		
		try {
			String wikiUser = driver.findElement(By.linkText(username)).getText();
			verify = wikiUser.contains(username); 
		}catch(Exception e){
			return false;
		}
		return verify;
	}
}
