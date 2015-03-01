import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitialSetup {
	private static final int IMPLICIT_WAIT_TIMEOUT = 30;
	
	public static FirefoxDriver firefoxDriver;
	
	@BeforeClass
	public static void openBrowser() {
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void closeBrowser() {
		firefoxDriver.quit();
	}
}
