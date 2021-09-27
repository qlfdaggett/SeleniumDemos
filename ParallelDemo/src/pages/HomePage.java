package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	By productLiBy = By.className("product");
	By linkBy = By.xpath("a");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickFirstProduct() {
		//WebElement productLi = driver.findElement(productLiBy);
		//WebElement productLink = productLi.findElement(linkBy);
		//driver.get(productLink.getAttribute("href"));
		clickNthProduct(0);
	}
	
	public boolean clickNthProduct(int n) {
		 List<WebElement> products = driver.findElements(productLiBy);

		 // Check to see if n is out of range or product list is empty
		 if (products.size() <= 0 || n >= products.size()) {
			 return false;
		 }
		 
		WebElement productLink = products.get(n).findElement(linkBy);
		driver.get(productLink.getAttribute("href"));
		 
		return true;
	}
}
