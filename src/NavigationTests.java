import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationTests extends InitialSetup {
	private static final String USERNAME = "Deliverable3";
	private static final String PASSWORD = "BillLaboon123";
	
	private WebElement usernameField;
	private WebElement passwordField;
	private WebElement signInButton;
	
	@Before
	public void setUp() {
		firefoxDriver.get("https://github.com/login");
		
		usernameField = firefoxDriver.findElement(By.name("login"));
		passwordField = firefoxDriver.findElement(By.name("password"));
		signInButton = firefoxDriver.findElement(By.name("commit"));
		
		usernameField.sendKeys(USERNAME);
		passwordField.sendKeys(PASSWORD);
		
		signInButton.click();
	}
	
	@Test
	public void gitHubIconRedirectsToRoot() {
		String currentUrl;
		WebElement gitHubIcon;
		
		firefoxDriver.navigate().to("https://github.com/");
		gitHubIcon = firefoxDriver.findElement(By.cssSelector("span[class='mega-octicon octicon-mark-github']"));;
		gitHubIcon.click();
		currentUrl = firefoxDriver.getCurrentUrl();
		assertEquals("https://github.com/", currentUrl);
		
		firefoxDriver.navigate().to("https://github.com/explore");
		gitHubIcon = firefoxDriver.findElement(By.cssSelector("span[class='mega-octicon octicon-mark-github']"));;
		gitHubIcon.click();
		currentUrl = firefoxDriver.getCurrentUrl();
		assertEquals("https://github.com/", currentUrl);
		
		firefoxDriver.navigate().to("https://github.com/Deliverable3");
		gitHubIcon = firefoxDriver.findElement(By.cssSelector("span[class='mega-octicon octicon-mark-github']"));;
		gitHubIcon.click();
		currentUrl = firefoxDriver.getCurrentUrl();
		assertEquals("https://github.com/", currentUrl);
		
		firefoxDriver.navigate().to("https://github.com/settings/profile");
		gitHubIcon = firefoxDriver.findElement(By.cssSelector("span[class='mega-octicon octicon-mark-github']"));;
		gitHubIcon.click();
		currentUrl = firefoxDriver.getCurrentUrl();
		assertEquals("https://github.com/", currentUrl);
	}
	
	@After
	public void tearDown() {
		firefoxDriver.manage().deleteAllCookies();
	}
}
