import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitialSetup {	
	public static FirefoxDriver firefoxDriver;
	
	@BeforeClass
	public static void openBrowser() {
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Before
	public void setUp() {
		firefoxDriver.get("https://github.com/");
	}
	
	@After
	public void tearDown() {
		
	}
	
	@AfterClass
	public static void closeBrowser() {
		firefoxDriver.quit();
	}
}
