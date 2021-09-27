package tests;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class parallelTests {

	String chromeProp = "webdriver.chrome.driver";
	String chromeDriverPath = "/Users/fdaggett/Documents/WebDriver/chromedriver";
	
	String baseUrl = "https://www.fakehandshake.com/";

	@BeforeTest
	public void initChromeProp() {
		System.setProperty(chromeProp, chromeDriverPath);
	}

	@Test
	public void addToCartTest() {
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);

		HomePage homePage = new HomePage(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		
		homePage.clickFirstProduct();
		productPage.addToCart();
		
		Assert.assertTrue(cartPage.verifyItemsInCart());
		
		driver.close();
		
	}
	
	@Test
	public void removeFromCartTest() {
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);

		HomePage homePage = new HomePage(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		
		homePage.clickFirstProduct();
		productPage.addToCart();
		cartPage.removeItem();
		
		Assert.assertTrue(!cartPage.verifyItemsInCart());
		
		driver.close();
		
	}
}
