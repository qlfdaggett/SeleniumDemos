package ParallelTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ParallelTest {
	public static void main(String[] args) {
		WebDriver sDriver = new SafariDriver();
		
		sDriver.get("http://google.com");
	}

}
