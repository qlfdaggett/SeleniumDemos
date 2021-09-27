package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends HomePage {

	By cartItemBy = By.className("cart_items");
	By quantityBy = By.className("quantity");
	By inputBy = By.xpath("input");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyItemsInCart() {
		return driver.findElements(cartItemBy).size() > 0;
	}

	public void removeItem() {
		WebElement inputDiv = driver.findElement(quantityBy);
		WebElement input = inputDiv.findElement(inputBy);
	
		input.clear();
		try {
			input.sendKeys("0");
		} catch(Exception e) {
		}
	}
}
