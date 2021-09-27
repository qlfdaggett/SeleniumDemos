package TestNGTestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTestFile {
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "/Users/fdaggett/Documents/WebDriver/chromedriver";
	public WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	}
	
  @Test(priority = 3, alwaysRun = true)
  public void f() {
	  
	  String expectedTitle = "Welcome: Mercury Tours";
	  String actualTitle = driver.getTitle();
	  
	  Assert.assertEquals(actualTitle,expectedTitle);
  }
  
  @Test(priority = 0, alwaysRun = false)
  public void a() {
	  Assert.fail();
  }
  
  @Test(priority = 1)
  public void b() {
	  Assert.assertTrue(true);
  }
  
  @Test(priority = 7)
  public void c() {
	  throw new SkipException("We're skipping this test");
  }
  
  @AfterTest
  public void terminateBrowser() {
	  driver.close();
  }
}
