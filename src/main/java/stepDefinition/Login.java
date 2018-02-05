package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Checks.*;

public class Login {
	private WebDriver driver;

	// Set up du test, on ouvre un navigateur qui va sur jobnroll.fr
	@Before
	public void setUp1() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver(new ChromeOptions().addArguments("disable-infobars"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jobnroll.fr/users/sign_in");
	}
	
	@Given("^User is on Login Page$")
	public void userIsOnLoginPage() throws Throwable {
		// Etre sur le site de jobnroll et le formulaire de connexion
		assertTrue(isElementPresent(driver, By.id("new_user")));
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userTryToLogin(String email, String password) throws Throwable {
	    // L'utilisateur tape son email
		driver.findElement(By.id("user_email")).sendKeys(email);
	    // L'utilisateur tape son mot de passe
		driver.findElement(By.id("user_password")).sendKeys(password);
		// Appuyer sur la touche "se connecter"
		driver.findElement(By.className("submit-btn")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("^User is redirect on home page$")
	public void redirectToHomePage() throws Throwable {
		// Etre sur la page d'accueil
		Thread.sleep(2000);
		isElementPresent(driver, By.className("user-menu"));
	}
	
	@Given("^User is connected with \\\"([^\\\"]*)\\\" and \\\"([^\\\"]*)\\\"$")
	public void is_connected(String email, String password) throws Throwable {
		// Etre sur la page d'accueil
		if(isElementPresent(driver, By.className("user-menu")) == false) {
			// L'utilisateur tape son email
			driver.findElement(By.id("user_email")).sendKeys(email);
		    // L'utilisateur tape son mot de passe
			driver.findElement(By.id("user_password")).sendKeys(password);
			// Appuyer sur la touche "se connecter"
			driver.findElement(By.className("submit-btn")).sendKeys(Keys.ENTER);
		}
		
		//Click sur le bouton fermer popup
		Thread.sleep(1000);
		driver.findElement(By.className("close")).click();
			
	}

	@When("^click on disconnected button$")
	public void click_on_disconnected_button() throws Throwable {
	    //Click sur le boutton 
		driver.findElement(By.className("menu-session")).click();
	}

	@Then("^User is disconnected$")
	public void user_is_disconnected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		isElementPresent(driver, By.className("user-menu-offline"));
		Thread.sleep(2000);
	}
	
	
	// Après le test, on ferme le navigateur
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
