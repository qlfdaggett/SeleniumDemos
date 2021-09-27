package PomDemoTests;

import PomDemo.HomePage;
import PomDemo.SearchPage;
import PomDemo.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PomDemoTests {
	protected WebDriver chromeDriver;
	protected WebDriver firefoxDriver;
	protected WebDriver safariDriver;
	
	
	public String baseUrl = "http://en.wikipedia.org";
	
	String chromeProp = "webdriver.chrome.driver";
	String firefoxProp = "webdriver.gecko.driver";
	
	String chromeDriverPath = "/Users/fdaggett/Documents/WebDriver/chromedriver";
	String firefoxDriverPath = "/Users/fdaggett/Documents/WebDriver/geckodriver";
	
	@BeforeTest
	public void launchBrowser() {
		System.setProperty(chromeProp, chromeDriverPath);
		System.setProperty(firefoxProp, firefoxDriverPath);
		
		//chromeDriver = new ChromeDriver();
		//firefoxDriver = new FirefoxDriver();
		safariDriver = new SafariDriver();
	}

	// Verifys that a wikipedia search term will direct to a page containing the expected title
	public void verifyWikiSearch(WebDriver driver, String searchTerm, String expectedTitle) {
		driver.get(baseUrl);
		
		SearchPage searchPage = new SearchPage(driver);
		HomePage searchRes = searchPage.useSearchBar(searchTerm);
		
		String actualTitle = searchRes.getTitle();
		
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
	
	public void capySearch(WebDriver driver) {
		verifyWikiSearch(driver, "capybara","Capybara - Wikipedia");
	}
	
	public void napoleonSearch(WebDriver driver) {
		verifyWikiSearch(driver, "napoleon","Napoleon - Wikipedia");
	}
	
	public void searchFail(WebDriver driver) {
		verifyWikiSearch(driver, "Cats", "Dogs - Wikipedia");
	}
	
	public void loginVerify(WebDriver driver, String username, String password) {
		driver.get(baseUrl);
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage loginRes = loginPage.logInFromSplash(username,password);
		
		Assert.assertTrue(loginRes.verifyLogin(username));
	}
	
	public void verifyFdaggett(WebDriver driver) {
		loginVerify(driver, "FdaggettQL", "m(^\"F7\\b$mCV]jLP");
	}
	
	public void verifyFail(WebDriver driver) {
		loginVerify(driver, "FdaggettQL", "badpassword");
	}
	
	@Test
	public void chromeVerifyLogin()
	{
		verifyFdaggett(chromeDriver);
	}
	
	@Test
	public void firefoxVerifyLogin()
	{
		verifyFdaggett(firefoxDriver);
	}
	
	@Test
	public void safariVerifyLogin()
	{
		verifyFdaggett(safariDriver);
	}
	
	@Test
	public void chromeVerifyFail()
	{
		verifyFail(chromeDriver);
	}
	
	@Test
	public void firefoxVerifyFail()
	{
		verifyFail(firefoxDriver);
	}
	
	@Test
	public void safariVerifyFail()
	{
		verifyFail(safariDriver);
	}
	
	@Test
	public void chromeCapySearch()
	{
		capySearch(chromeDriver);
	}
	
	@Test
	public void firefoxCapySearch()
	{
		capySearch(firefoxDriver);
	}
	
	@Test
	public void safariCapySearch()
	{
		capySearch(safariDriver);
	}
	
	@Test
	public void chromeNapoleonSearch()
	{
		napoleonSearch(chromeDriver);
	}
	
	@Test
	public void firefoxNapoleonSearch()
	{
		napoleonSearch(firefoxDriver);
	}
	
	@Test
	public void safariNapoleonSearch()
	{
		napoleonSearch(safariDriver);
	}
	
	@AfterTest
	public void closeBrowser() {
		chromeDriver.close();
		firefoxDriver.close();
		safariDriver.close();
	}
}
