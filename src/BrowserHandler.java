import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHandler {
	private static FirefoxDriver firefoxDriver;
	
	@BeforeClass
	public static void setUp() {
		firefoxDriver = new FirefoxDriver();
	}
	
	@AfterClass
	public static void tearDown() {
		firefoxDriver.quit();
	}
}