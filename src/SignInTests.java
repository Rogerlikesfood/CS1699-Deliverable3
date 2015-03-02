import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * Feature: As a GitHub user
 * 			I want to be able to sign in to my GitHub account
 * 			So that I can manage my GitHub account
 */
public class SignInTests extends InitialSetup {
	private static final String USERNAME = "Deliverable3";
	private static final String PASSWORD = "BillLaboon123";
	
	private WebElement usernameField;
	private WebElement passwordField;
	private WebElement signInButton;
	
	private WebElement errorField;
	
	/*
	 *  Annotating a public void method with @Before causes that method to be run before the @Test
	 *  methods. The @Before methods of superclasses will be run before those of the current class.
	 *  
	 *  Navigates the Firefox browser to https://github.com/login and initializes the username
	 *  field, password field, and sign in button WebElements.
	 */
	@Before
	public void setUp() {
		firefoxDriver.get("https://github.com/login");
		
		usernameField = firefoxDriver.findElement(By.name("login"));
		passwordField = firefoxDriver.findElement(By.name("password"));
		signInButton = firefoxDriver.findElement(By.name("commit"));
	}
	
	/*
	 * Scenario: I sign in but I do not have a GitHub account
	 *     Given no username 
	 *     And no password
	 *     When I try to sign in with no credentials
	 *     Then I should receive a message stating that an "Incorrect username or password" has been entered
	 *     
	 * Tests to see if GitHub allows a user to sign in if they do not have a GitHub account.
	 */
	@Test
	public void signInWithoutHavingAGitHubAccount() {
		signInButton.click();
		
		errorField = firefoxDriver.findElement(By.cssSelector("div[class='flash flash-error']"));
		assertEquals("Incorrect username or password.", errorField.getText());
	}
	
	/*
	 * Scenario: I sign in with an incorrect username and an incorrect password
	 *     Given an incorrect username 
	 *     And an incorrect password
	 *     When I try to sign with those credentials
	 *     Then I should receive a message stating that an "Incorrect username or password" has been entered
	 *     
	 * Tests to see if GitHub allows a user to sign in with an incorrect username and an incorrect
	 * password.
	 */
	@Test
	public void signInWithIncorrectUsernameAndIncorrectPassword() {
		usernameField.sendKeys("IncorrectUsername");
		passwordField.sendKeys("IncorrectPassword");
		signInButton.click();
		
		errorField = firefoxDriver.findElement(By.cssSelector("div[class='flash flash-error']"));
		assertEquals("Incorrect username or password.", errorField.getText());
	}
	
	/*
	 * Scenario: I sign in with an incorrect username and a correct password
	 *     Given an incorrect username
	 *     And a correct password
	 *     When I try to sign with those credentials
	 *     Then I should receive a message stating that an "Incorrect username or password" has been entered
	 * 
	 * Tests to see if GitHub allows a user to sign in with an incorrect username and a correct
	 * password.
	 */
	@Test
	public void signInWithIncorrectUsernameAndCorrectPassword() {
		usernameField.sendKeys("IncorrectUsername");
		passwordField.sendKeys(PASSWORD);
		signInButton.click();
		
		errorField = firefoxDriver.findElement(By.cssSelector("div[class='flash flash-error']"));
		assertEquals("Incorrect username or password.", errorField.getText());
	}
	
 	/*
	 * Scenario: I sign in with a correct username and an incorrect password
	 *    Given a correct username
	 *    And an incorrect password 
	 *    When I try to sign with those credentials
	 *    Then I should receive a message stating that an "Incorrect username or password" has been entered
	 * 
	 * Tests to see if GitHub allows a user to sign in with a correct username and an incorrect
	 * password.
	 */
	@Test
	public void signInWithCorrectUsernameAndIncorrectPassword() {
		usernameField.sendKeys(USERNAME);
		passwordField.sendKeys("IncorrectPassword");
		signInButton.click();
		
		errorField = firefoxDriver.findElement(By.cssSelector("div[class='flash flash-error']"));
		assertEquals("Incorrect username or password.", errorField.getText());
	}
	
	/*
	 * Scenario: I sign in with a correct username and a correct password
	 *     Given a correct username
	 *     And a correct password
	 *     When I try to sign with those credentials
	 *     Then I should be signed into my GitHub account
	 * 
	 * Tests to see if GitHub allows a user to sign in with a correct username and a correct
	 * password.
	 */
	@Test
	public void signInWithCorrectUsernameAndCorrectPassword() {
		usernameField.sendKeys(USERNAME);
		passwordField.sendKeys(PASSWORD);
		signInButton.click();
		
		errorField = firefoxDriver.findElement(By.cssSelector("div[class='flash flash-error']"));
		assertNotEquals("Incorrect username or password.", errorField.getText());
	}
	
	/*
	 * Annotating a public void method with @After causes that method to be run after the @Test
	 * methods. All @After methods are guaranteed to run even if a @Before or @Test method throws 
	 * an exception. The @After methods declared in superclasses will be run after those of the
	 * current class.
	 * 
	 * Deletes all cookies stored by the Firefox browser. This forcibly signs a user out after
	 * every test.
	 */
	@After
	public void tearDown() {
		firefoxDriver.manage().deleteAllCookies();
	}
}
