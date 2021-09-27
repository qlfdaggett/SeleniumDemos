package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends HomePage {
	
	By addItemBy = By.name("submit");
/*	
	@FindBy(xpath = "button")
	WebElement checkoutButton;
	*/

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void addToCart() {
		WebElement checkoutButton = driver.findElement(addItemBy);
		checkoutButton.click();
	}

}
