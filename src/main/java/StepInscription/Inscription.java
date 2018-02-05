package StepInscription;

import static org.junit.Assert.assertTrue;
import static utils.Checks.isElementPresent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Inscription {
	private WebDriver driver;
	
	// Set up du test, on ouvre un navigateur qui va sur jobnroll.fr
	@Before
	public void setUp2() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver(new ChromeOptions().addArguments("disable-infobars"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jobnroll.fr/users/sign_up?role=student");
		 
	}

	@Given("^User is on inscription page$")
	public void user_is_on_inscription_page() throws Throwable {
	    //On est bien sur la page d'inscription
		Thread.sleep(2000);
		isElementPresent(driver, By.id("signup-secondpart"));
	}

	@When("^User tape \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_tape_and_and(String mail, String pwd, String confirmpwd) throws Throwable {
		// L'utilisateur tape un email
		driver.findElement(By.id("user_email")).sendKeys(mail);
	    // L'utilisateur tape un mdp
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		// L'utilisateur tape un mdp
		driver.findElement(By.id("user_password_confirmation")).sendKeys(confirmpwd);
		Thread.sleep(2000);
		driver.findElement(By.className("submit-btn2")).click();
	}

	@Then("^User is redirect to confirm page$")
	public void user_is_redirect_to_confirm_page() throws Throwable {

		if(isElementPresent(driver, By.className("errors")) == false) {
			
		}
		else {
			isElementPresent(driver, By.className("notice"));
		}
		Thread.sleep(1000);
	}
	
	// Après le test, on ferme le navigateur
	@After
	public void tearDown() {
		driver.quit();
	}

}
