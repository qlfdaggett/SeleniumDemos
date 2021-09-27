package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
/*
public class AddItemTest {
	private int n;
	
	public AddItemTest(int n) {
		this.n = n;
	}
	
	@Test 
	public void addNthItemTest() {
		
	}
	
}
*/

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class FactoryTests implements org.testng.ITest{
	public int n;

	private static int numTests = 10;

	String chromeProp = "webdriver.chrome.driver";
	String chromeDriverPath = "/Users/fdaggett/Documents/WebDriver/chromedriver";

	String baseUrl = "https://www.fakehandshake.com/";
	
	private String testCaseName;

	@BeforeTest
	public void initChromeProp() {
		System.setProperty(chromeProp, chromeDriverPath);
	}

	@Factory(dataProvider = "dataMethod")
	public FactoryTests(int n) {
		this.n = n;
		testCaseName = "Test_" + n;
	}

	@DataProvider
	public static Object[][] dataMethod() {
		Object[][] testCases = new Object[numTests][1];

		for (int i = 0; i < numTests; i++) {
			testCases[i][0] = i;
		}

		return testCases;
	}

	@Override
	public String getTestName() {
		return this.testCaseName;
	}

	@Test(description = "adding item to cart")
	public void addNthItemTest() {
		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);

		HomePage homePage = new HomePage(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);

		homePage.clickNthProduct(n);
		try {
			productPage.addToCart();
			Assert.assertTrue(cartPage.verifyItemsInCart());
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

		driver.close();
	}
}
