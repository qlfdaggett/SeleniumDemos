package ParallelTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class ParallelNG {
	String chromeDriverLoc = "/Users/fdaggett/Documents/WebDriver/chromedriver";
	String chromeDriverProp = "webdriver.chrome.driver";
	
	String firefoxDriverProp = "webdriver.gecko.driver";
	String firefoxDriverLoc = "/Users/fdaggett/Documents/WebDriver/geckodriver";
	
	String url = "http://google.com";
	
	@Test
	public void session0() throws InterruptedException {
		System.setProperty(chromeDriverProp, chromeDriverLoc);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("asdf");
	}
	
	@Test
	public void session1() throws InterruptedException {
		WebDriver driver = new SafariDriver();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("qwer");
	}
	
	@Test
	public void session2() throws InterruptedException {
		System.setProperty(firefoxDriverProp, firefoxDriverLoc);
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("zxcv");
	}
	
	//WebDriver driver;
/*
	@Test
	public void chromeTest() {
		System.setProperty("webdriver.chrome.driver", chromeDriverLoc);
		driver = new ChromeDriver();
		
		driver.get(url);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void safariTest() {
		driver = new SafariDriver();
		driver.get(url);
	}
	*/
}
